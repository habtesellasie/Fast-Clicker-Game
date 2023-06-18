package com.example.fastclickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b_start, b_click1, b_click2;
    TextView tv_time, tv_clicks;
    int numberOfClicks = 0;
    int secondsLeft = 20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_start = findViewById(R.id.b_start);
        b_click1 = findViewById(R.id.b_click1);
        b_click2 = findViewById(R.id.b_click2);
        tv_clicks = findViewById(R.id.tv_clicks);
        tv_time = findViewById(R.id.tv_timeLeft);

        b_click1.setEnabled(false);
        b_click2.setEnabled(false);
        final CountDownTimer timer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                secondsLeft--;
                tv_time.setText("sec left: " + secondsLeft);
            }

            @Override
            public void onFinish() {
                b_click1.setEnabled(false);
                b_click2.setEnabled(false);
            }
        };

        b_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondsLeft = 20;
                numberOfClicks = 0;
                tv_clicks.setText("clicks: " + numberOfClicks);
                b_click1.setEnabled(true);
                b_click2.setEnabled(true);
                timer.start();
            }
        });

        b_click1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOfClicks++;
                tv_clicks.setText("clicks: " + numberOfClicks);
                b_click2.setEnabled(true);
                b_click1.setEnabled(false);
            }
        });

        b_click2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOfClicks++;
                tv_clicks.setText("clicks: " + numberOfClicks);
                b_click2.setEnabled(false);
                b_click1.setEnabled(true);
            }
        });
    }

}