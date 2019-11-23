package com.example.el3afreet.green.NewFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.el3afreet.green.R;
import com.example.el3afreet.green.Utili;

import me.itangqi.waveloadingview.WaveLoadingView;

public class TemperatureFragment extends Fragment {
  ImageView cloud;
  WaveLoadingView waveLoadingView;
  TextView textView;
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootview = inflater.inflate(com.example.el3afreet.green.R.layout.fragment_temprature, container, false);
    Utili utili=new Utili(getActivity());
    textView=rootview.findViewById(R.id.temp);
    textView.setText(utili.getTemperature());
    cloud = rootview.findViewById(com.example.el3afreet.green.R.id.cloud);
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
    waveLoadingView=rootview.findViewById(com.example.el3afreet.green.R.id.waterwavetemp);
    animatebotle(50);
    return rootview;
  }
  public void animatebotle(int filled) {
    waveLoadingView.setProgressValue(80);

    waveLoadingView.setBottomTitle("");
    waveLoadingView.setCenterTitle(String.valueOf(filled+"°C"));
    waveLoadingView.setTopTitle("");

  }
}
