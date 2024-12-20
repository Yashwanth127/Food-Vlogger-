package com.example.food;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private TextView welcomeTextView;
    private String welcomeMessage = "Don't Waste Food";
    private int index = 0;
    private long delay = 300; // Delay between letters

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        welcomeTextView = findViewById(R.id.welcomeTextView);
        showWelcomeMessage();
    }


    private void showWelcomeMessage() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (index < welcomeMessage.length()) {
                    welcomeTextView.append(String.valueOf(welcomeMessage.charAt(index)));
                    index++;
                    handler.postDelayed(this, delay);
                } else {

                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
            }
        }, delay);
    }
}
