package com.example.root.aplikasi_oli_x_nelayan.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.root.aplikasi_oli_x_nelayan.R;
import com.example.root.aplikasi_oli_x_nelayan.fragment.login.HomeLoginActivity;

public class Splash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash_Activity.this, HomeLoginActivity.class));
                finish();
            }
        }, 3000L);
    }
}
