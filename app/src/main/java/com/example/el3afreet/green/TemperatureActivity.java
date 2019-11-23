package com.example.el3afreet.green;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import me.itangqi.waveloadingview.WaveLoadingView;

public class TemperatureActivity extends AppCompatActivity {

    ImageView cloud;
    WaveLoadingView waveLoadingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        cloud = findViewById(R.id.cloud);
        TranslateAnimation cloud_moving = new TranslateAnimation(
                Animation.ABSOLUTE, 180,
                Animation.ABSOLUTE, -180,
                Animation.ABSOLUTE, 0,
                Animation.ABSOLUTE, 0
        );
        cloud_moving.setDuration(4000);
        cloud_moving.setFillAfter(true);
        cloud_moving.setStartOffset(1000);
        cloud_moving.setRepeatCount(Animation.INFINITE);
        cloud_moving.setRepeatMode(Animation.REVERSE);
        cloud.startAnimation(cloud_moving);
        waveLoadingView=findViewById(R.id.waterwavetemp);
        animatebotle(50);
    }
    public void animatebotle(int filled) {
        waveLoadingView.setProgressValue(80);

        waveLoadingView.setBottomTitle("");
        waveLoadingView.setCenterTitle(String.valueOf(filled+"°C"));
        waveLoadingView.setTopTitle("");

    }
}
