package com.example.el3afreet.green;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.SeekBar;

import me.itangqi.waveloadingview.WaveLoadingView;

public class WaterFlowRateActivity extends AppCompatActivity {


    WaveLoadingView waveLoadingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_flow_rate);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarwater);
        setSupportActionBar(toolbar);
        toolbar.setTitle("WaterFlow");

        waveLoadingView=findViewById(R.id.waterwave);

        animatebotle(50);


    }


    public void animatebotle(int filled){
        waveLoadingView.setProgressValue(filled);
        if (filled==0) {

            waveLoadingView.setBottomTitle(String.format("%d%%",filled));
            waveLoadingView.setCenterTitle("");
            waveLoadingView.setTopTitle("");

        }
        else if (filled>=1&&filled<=10) {
            waveLoadingView.setBottomTitle(String.format("%d%%",filled));
            waveLoadingView.setCenterTitle("");
            waveLoadingView.setTopTitle("");

        }
        else if (filled>=11&&filled<=20) {
            waveLoadingView.setBottomTitle(String.format("%d%%",filled));
            waveLoadingView.setCenterTitle("");
            waveLoadingView.setTopTitle("");

        }
        else if (filled>=21&&filled<=30) {
            waveLoadingView.setBottomTitle("");
            waveLoadingView.setCenterTitle(String.format("%d%%",filled));
            waveLoadingView.setTopTitle("");

        }
        else if (filled>=31&&filled<=40) {
            waveLoadingView.setBottomTitle("");
            waveLoadingView.setCenterTitle(String.format("%d%%",filled));
            waveLoadingView.setTopTitle("");

        }
        else if (filled>=41&&filled<=50) {
            waveLoadingView.setBottomTitle("");
            waveLoadingView.setCenterTitle(String.format("%d%%",filled));
            waveLoadingView.setTopTitle("");

        }
        else if (filled>=51&&filled<=60) {
            waveLoadingView.setBottomTitle("");
            waveLoadingView.setCenterTitle(String.format("%d%%",filled));
            waveLoadingView.setTopTitle("");

        }
        else if (filled>=61&&filled<=70) {
            waveLoadingView.setBottomTitle("");
            waveLoadingView.setCenterTitle(String.format("%d%%",filled));
            waveLoadingView.setTopTitle("");

        }
        else if (filled>=71&&filled<=80) {
            waveLoadingView.setBottomTitle("");
            waveLoadingView.setCenterTitle("");
            waveLoadingView.setTopTitle(String.format("%d%%",filled));
        }
        else if (filled>=81&&filled<=90) {
            waveLoadingView.setBottomTitle("");
            waveLoadingView.setCenterTitle("");
            waveLoadingView.setTopTitle(String.format("%d%%",filled));

        }
        else if (filled>=91&&filled<=100) {
            waveLoadingView.setBottomTitle("");
            waveLoadingView.setCenterTitle("");
            waveLoadingView.setTopTitle(String.format("%d%%",filled));

        }
    }

}
