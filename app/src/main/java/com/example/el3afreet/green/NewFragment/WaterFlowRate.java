package com.example.el3afreet.green.NewFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.el3afreet.green.R;
import com.example.el3afreet.green.Utili;

import me.itangqi.waveloadingview.WaveLoadingView;

public class WaterFlowRate extends Fragment {
    WaveLoadingView waveLoadingView;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(com.example.el3afreet.green.R.layout.fragment_water_flow_rate, container, false);

        Utili utili=new Utili(getActivity());

        waveLoadingView=rootview.findViewById(com.example.el3afreet.green.R.id.waterwave);
        textView=rootview.findViewById(R.id.waterlevel);
        textView.setText(utili.getWaterLevel());
        animatebotle(50);

        return rootview;
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
