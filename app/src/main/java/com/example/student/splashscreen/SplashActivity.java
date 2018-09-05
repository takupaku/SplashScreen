package com.example.student.splashscreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //hide statusBar

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        //hide actionbar
        getSupportActionBar().hide();

        imageView = findViewById(R.id.logoId);
        textView = findViewById(R.id.welcomwTestId);
        progressBar = findViewById(R.id.prgressbarId);

        Animation animation=  AnimationUtils.loadAnimation(this,R.anim.my_anim);
        imageView.startAnimation(animation);
        textView.startAnimation(animation);

        progressBar.setMax(5);
        for(int i=1;i<=5;i++){
            progressBar.setProgress(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        Handler handler =new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //calling run after 5 sec
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);


    }
}
