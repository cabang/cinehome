package com.cine.cinehome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.ImageView;


public class Activity_Splash extends Activity {
    ImageView img_left, img_right, img_logo;
    TimeSplash tiempo;
    int width;
    int heigth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("onCreate", "onCreate");
        setContentView(R.layout.activity_splash);
        img_left = (ImageView) findViewById(R.id.img_left);
        img_right = (ImageView) findViewById(R.id.img_right);
        img_left.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                width = img_left.getWidth();
                heigth = img_left.getHeight();
                Log.e("width", "width" + width);
                img_left.animate().translationX(img_left.getX() - width / 3).setDuration(1500).start();
                img_right.animate().translationX(width / 3).setDuration(1500).start();
            }
        });
        tiempo = new TimeSplash(1500, 1500);
        tiempo.start();

    }

    public class TimeSplash extends CountDownTimer{

        public TimeSplash(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        @Override
        public void onTick(long l) {
        }
        @Override
        public void onFinish() {
            Intent intent = new Intent(Activity_Splash.this, Activity_Menu.class);
            startActivity(intent);
            finish();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("ondestroy", "onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("onStart", "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("onPause", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("onStop","onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("onResume","onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("onRestart","onRestart");
    }
}
