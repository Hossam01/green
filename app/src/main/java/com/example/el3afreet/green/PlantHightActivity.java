package com.example.el3afreet.green;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class PlantHightActivity extends AppCompatActivity {

    ImageView treeIamge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_hight);


        treeIamge=findViewById(R.id.treeimage);
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
    }
}
