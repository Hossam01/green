package com.example.el3afreet.green.NewFragment;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.el3afreet.green.R;

import java.util.Timer;
import java.util.TimerTask;

public class FishFeedingFragment extends Fragment {

    Handler handler=new Handler();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(com.example.el3afreet.green.R.layout.fragment_fish_feeding, container, false);

        final ProgressBar progressBar=rootview.findViewById(R.id.progressfish);
        final TextView second=rootview.findViewById(R.id.timesecond);
        final TextView minte=rootview.findViewById(R.id.timemint);

        new CountDownTimer(600000, 1000) {

            public void onTick(long millisUntilFinished) {
                int i= (int) (millisUntilFinished % 60000 /1000 );
                second.setText(String.valueOf(i));
                final int minte1=(int) millisUntilFinished /60000;
                minte.setText(String.valueOf(minte1));

                progressBar.setMax(10);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setProgress(minte1);
                    }
                });


                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
            }

        }.start();
        return rootview;
    }
}
