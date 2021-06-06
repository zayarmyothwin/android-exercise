package com.zayar.gridviewtesting1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<brandname> list;


    public ImageAdapter(Context context, ArrayList<brandname> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(ArrayList<brandname> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView;
        if (convertView==null){
            rootView=new View(context);
            rootView=inflater.inflate(R.layout.brand,null);
        }
        else {
            rootView=(View)convertView;
        }
        TextView txtView=(TextView)rootView.findViewById(R.id.itemLabel);
        txtView.setText(list.get(position).getName());
        ImageView imgView=(ImageView)rootView.findViewById(R.id.itemImg);
        imgView.setImageResource(list.get(position).getResource_index());
        return rootView;
    }
}
