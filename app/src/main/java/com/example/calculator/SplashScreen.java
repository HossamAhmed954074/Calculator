package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splachscreen);
        createSplashScreen();


    }
    void createSplashScreen() {
        new Handler().postDelayed(this::startActivityAndFinishTheSplashActivity, 800);
    }

    void startActivityAndFinishTheSplashActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
