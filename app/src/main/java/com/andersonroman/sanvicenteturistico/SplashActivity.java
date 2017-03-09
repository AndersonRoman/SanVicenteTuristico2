package com.andersonroman.sanvicenteturistico;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_DELAY=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);  //establece el modo
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);  //quitar appbar
        setContentView(R.layout.activity_splash);
        TimerTask task= new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent().setClass(SplashActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        };
        Timer timer= new Timer();
        timer.schedule(task,SPLASH_DELAY);

    }
}
