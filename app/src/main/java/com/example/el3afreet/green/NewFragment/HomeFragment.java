package com.example.el3afreet.green.NewFragment;

import android.os.Bundle;
import com.example.el3afreet.green.R;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_home, container, false);
        return rootview;
    }


}
