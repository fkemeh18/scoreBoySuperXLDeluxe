package com.example.scoreboysuperxl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import static java.lang.Math.abs;


public class MainActivity extends AppCompatActivity implements TextWatcher, View.OnClickListener {

    public static final String EXTRA_MESSAGE = "com.example.scoreboysuperxl.extra.MESSAGE";
    private String messenger = "message";

    int t1Points = 0;
    int t2Points = 0;

    private TextView t1;
    private TextView t1Score;
    private TextView t2;
    private TextView t2Score;

    private Button t1M;
    private Button t1P;
    private Button t2M;
    private Button t2P;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = (TextView) findViewById(R.id.tv_team1);
        t2 = (TextView) findViewById(R.id.tv_team2);

        t1Score = (TextView) findViewById(R.id.tv_t1S);
        t1M = (Button) findViewById(R.id.bt_t1M);
        t1P = (Button) findViewById(R.id.bt_t1P);

        t2Score = (TextView) findViewById(R.id.tv_t2S);
        t2M = (Button) findViewById(R.id.bt_t2M);
        t2P = (Button) findViewById(R.id.bt_t2P);

        buttonBuilder(t1M, "t1M");
        buttonBuilder(t1P, "t1P");
        buttonBuilder(t2M, "t2M");
        buttonBuilder(t2P, "t2P");
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    private void buttonBuilder(final Button button, final String buttonType) {

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch (buttonType) {
                    case "t1M":
                        decT1S(t1Score);
                        break;
                    case "t1P":
                        incT1S(t1Score);
                        break;
                    case "t2M":
                        decT2S(t2Score);
                        break;
                    case "t2P":
                        incT2S(t2Score);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
    }

    public String scoreCount(int toastCount) {
        return Integer.toString(toastCount);
    }

    private void decT1S(View view) {
        t1Points -= 1;
        t1Score.setText(scoreCount(t1Points));
    }

    private void incT1S(View view) {
        t1Points += 1;
        t1Score.setText(scoreCount(t1Points));

        if (t1Points >= 5) {
            winnerText("Team 1");
        }
    }

    private void decT2S(View view) {
        t2Points -= 1;
        t2Score.setText(scoreCount(t2Points));
    }

    private void incT2S(View view) {
        t2Points += 1;
        t2Score.setText(scoreCount(t2Points));

        if (t2Points >= 5) {
            winnerText("Team 2");
        }
    }

    private void winnerText(String team) {
        String winText;
        int dif = t1Points - t2Points;

        if(dif > 0){
            winText = team + " won by " + dif + " points! Congratulations!";
            Log.d(messenger, winText);
        }else{
            dif = abs(dif);
            winText = team + " won by " + dif + " points! Congratulations!";
            Log.d(messenger, winText);
        }

        launchWinner(winText);
    }

    private void launchWinner(String winText) {
        Intent intent = new Intent(this, WinnerActivity.class);
        intent.putExtra(EXTRA_MESSAGE, winText);
        startActivity(intent);
    }

}
