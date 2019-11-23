package com.example.el3afreet.green;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryAdapter  extends BaseAdapter {
    ArrayList<Listitem> arrayitems;
    LayoutInflater vi;
    int Resource;
    ViewHolder viewHolder;
    Listitem listitem;
    Context c;
    HistoryAdapter(){}
    public HistoryAdapter(Context context, int resource, ArrayList<Listitem> objects) {
        //super(context, resource, objects);
        vi = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        Resource = resource;
        arrayitems = objects;
        c=context;
    }

    @Override
    public int getCount() {
        return arrayitems.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayitems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            viewHolder= new ViewHolder();
            v=vi.inflate(Resource,null);
            viewHolder.value=v.findViewById(R.id.value);
            viewHolder.date=v.findViewById(R.id.date);

            v.setTag(viewHolder);
        }else
        {
            viewHolder=(ViewHolder)v.getTag();
        }
        listitem=arrayitems.get(position);
        viewHolder.value.setText(listitem.getValue().toString());
        viewHolder.date.setText(listitem.getDate().toString());

        return v;
    }
    public class ViewHolder {
        TextView value,date;

    }
}
