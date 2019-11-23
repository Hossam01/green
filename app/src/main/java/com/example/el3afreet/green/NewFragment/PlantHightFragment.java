package com.example.el3afreet.green.NewFragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.el3afreet.green.R;
import com.example.el3afreet.green.Utili;

public class PlantHightFragment extends Fragment {
    ImageView treeIamge;
    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(com.example.el3afreet.green.R.layout.fragment_plant_hight, container, false);
        treeIamge=rootview.findViewById(com.example.el3afreet.green.R.id.treeimage);
        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(treeIamge, "scaleX", 0.7f);
        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(treeIamge, "scaleY", 0.7f);
        scaleDownX.setDuration(1500);
        scaleDownY.setDuration(1500);

        ObjectAnimator moveUpY = ObjectAnimator.ofFloat(treeIamge, "translationY", -100);
        moveUpY.setDuration(1500);

        AnimatorSet scaleDown = new AnimatorSet();
        AnimatorSet moveUp = new AnimatorSet();

        scaleDown.play(scaleDownX).with(scaleDownY);
        moveUp.play(moveUpY);

        scaleDown.start();
        moveUp.start();

        Utili utili=new Utili(getActivity());
        textView=rootview.findViewById(R.id.hight);
        textView.setText(utili.getPlantHigh());

        return rootview;
    }
}
