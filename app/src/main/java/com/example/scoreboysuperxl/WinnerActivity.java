package com.example.scoreboysuperxl;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WinnerActivity extends AppCompatActivity {

    private TextView winnerText;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        winnerText = (TextView)findViewById(R.id.winnerText);

        Intent i = getIntent();
        message =  i.getStringExtra(MainActivity.EXTRA_MESSAGE);
        winnerText.setText(message);


        //log();
        //winnerText.setText(temp);
    }

    private void log() {
        //Log.d(temp, message);
    }


    public void shareText(View view) {
        Intent i = new Intent(Intent.ACTION_SEND);

        i.putExtra(Intent.EXTRA_TEXT, message);
        i.setType("text/plain");

        startActivity(i);
    }

    public void shareMap(View view) {
        Uri dbf = Uri.parse("geo:0,0?q=Pirate basketball nearest me");
        Intent i = new Intent(Intent.ACTION_VIEW, dbf);
        i.setPackage("com.google.android.apps.maps");

        startActivity(i);
    }

    public void shareCall(View view) {
        Intent i = new Intent(Intent.ACTION_DIAL);

        startActivity(i);
    }
}
