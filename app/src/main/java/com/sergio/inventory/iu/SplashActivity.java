package com.sergio.inventory.iu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.sergio.inventory.R;
import com.sergio.inventory.iu.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {
    private static final long WAIT_TIME=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onStart() {
        super.onStart();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initLogin();
            }
        },WAIT_TIME);
    }

    private void initLogin() {
        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        // Vamos a llamar de forma explícita al método finish() que destruye la Activity
        // y no se muestra cuando se pulse el botón back
        finish();
    }
}