package com.example.el3afreet.green.NewFragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.el3afreet.green.R;
import com.example.el3afreet.green.Utili;

import static android.content.Context.MODE_PRIVATE;

public class BrightnessFragment extends Fragment  {

    TextView num,txtStatue;
    ImageView imageArrow;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(com.example.el3afreet.green.R.layout.brightness_fragment, container, false);
        num= rootview.findViewById(R.id.textnum);
        txtStatue=rootview.findViewById(R.id.txtStatue);
        imageArrow=rootview.findViewById(R.id.imagearrow);

        Utili utili=new Utili(getActivity());
        num.setText(String.valueOf(utili.getBrightness()));

          /*  if (Integer.valueOf(utili.getBrightness()) < 693)
            {
                txtStatue.setText("LOW");
                imageArrow.setImageResource(R.drawable.arrowdown);
            }
            else {
                txtStatue.setText("High");
                imageArrow.setImageResource(R.drawable.arrowup);
            }*/
        return rootview;
    }



}