package com.example.scoreboysuperxl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class WinnerActivity extends AppCompatActivity {

    private TextView winnerText;
    private String message;

    private String temp = "YEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE";

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


}
