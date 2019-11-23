package com.example.el3afreet.green.NewFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.el3afreet.green.R;
import com.example.el3afreet.green.Utili;

public class PHLevelFragment extends Fragment {
    TextView textView,textView2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_ph_level, container, false);
        textView=rootview.findViewById(R.id.textView2);
        textView2=rootview.findViewById(R.id.textView3);

        Utili utili=new Utili(getActivity());
       String phLevel= utili.getPhLevel();
        textView2.setText(phLevel);

        if (phLevel=="0")
        {
            textView2.setBackgroundResource(R.color.red_dark);
            textView.setText("ACIDIC");

        }
        else if (phLevel=="1")
        {
            textView2.setBackgroundResource(R.color.red);
            textView.setText("ACIDIC");

        }
        else if (phLevel=="2")
        {
            textView2.setBackgroundResource(R.color.orange);
            textView.setText("ACIDIC");

        }
        else if (phLevel=="3")
        {
            textView2.setBackgroundResource(R.color.yellow_dark);
            textView.setText("ACIDIC");
        }
        else if (phLevel=="4")
        {
            textView2.setBackgroundResource(R.color.yellow);
            textView.setText("ACIDIC");

        }
        else if (phLevel=="5")
        {
            textView2.setBackgroundResource(R.color.greencolor);
            textView.setText("ACIDIC");

        }
        else if (phLevel=="6")
        {
            textView2.setBackgroundResource(R.color.green_dark);
            textView.setText("ACIDIC");

        }
        else if (phLevel=="7")
        {
            textView2.setBackgroundResource(R.color.greenblue);
            textView.setText("NEUTRAL");
        }
        else if (phLevel=="8")
        {
            textView2.setBackgroundResource(R.color.blue);
            textView.setText("ALKALINE");
        }

        else if (phLevel=="9")
        {
            textView2.setBackgroundResource(R.color.blue_dark);
            textView.setText("ALKALINE");
        }
        else if (phLevel=="10")
        {
            textView2.setBackgroundResource(R.color.darkblue_dark);
            textView.setText("ALKALINE");
        }
        else if (phLevel=="11")
        {
            textView2.setBackgroundResource(R.color.blueverydark);
            textView.setText("ALKALINE");
        }
        else if (phLevel=="12")
        {
            textView2.setBackgroundResource(R.color.darkviolet);
            textView.setText("ALKALINE");
        }
        else if (phLevel=="13")
        {
            textView2.setBackgroundResource(R.color.violet_dark);
            textView.setText("ALKALINE");
        }
        else if (phLevel=="14")
        {
            textView2.setBackgroundResource(R.color.darkviolet_dark);
            textView.setText("ALKALINE");
        }
        return rootview;
    }
}