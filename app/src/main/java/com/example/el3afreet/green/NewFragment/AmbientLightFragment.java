package com.example.el3afreet.green.NewFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.el3afreet.green.R;
import com.example.el3afreet.green.Utili;

public class AmbientLightFragment extends Fragment {
    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(com.example.el3afreet.green.R.layout.fragment_ambient_light, container, false);
        Utili utili=new Utili(getActivity());
        ProgressBar progressBar=rootview.findViewById(R.id.progressBar);
        textView=rootview.findViewById(R.id.txtProgress);
        textView.setText(utili.getAmbientLight());
        progressBar.setMax(10240);
        //progressBar.setProgress(Integer.valueOf(utili.getAmbientLight()));
        return rootview;
    }
}