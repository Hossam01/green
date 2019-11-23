package com.example.el3afreet.green.NewFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.el3afreet.green.HistoryAdapter;
import com.example.el3afreet.green.Listitem;
import com.example.el3afreet.green.DateBaseHistory;
import com.example.el3afreet.green.R;

import java.util.ArrayList;

public class History extends Fragment {
    ListView listView;
    ArrayList<Listitem> arrayitems;
    HistoryAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(com.example.el3afreet.green.R.layout.fragment_history, container, false);

        listView=rootview.findViewById(R.id.listviewvalue);
        DateBaseHistory db = new DateBaseHistory(getActivity());
        arrayitems = db.select();
        adapter = new HistoryAdapter(getActivity(), R.layout.list_item, arrayitems);
        listView.setAdapter(adapter);

        return rootview;
    }
}
