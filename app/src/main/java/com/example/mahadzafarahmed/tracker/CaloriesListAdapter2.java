package com.example.mahadzafarahmed.tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CaloriesListAdapter2 extends BaseAdapter {

    Context context;
    ArrayList<CaloriesListItems> contactList;

    public CaloriesListAdapter2(Context context, ArrayList<CaloriesListItems> list) {

        this.context = context;
        contactList = list;
    }

    @Override
    public int getCount() {

        return contactList.size();
    }

    @Override
    public Object getItem(int position) {

        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup arg2) {
        CaloriesListItems caloriesListItems = contactList.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_view_layout3, null);

        }
        //TextView column_name = (TextView) convertView.findViewById(R.id.textView20);
        //column_name.setText(caloriesListItems.getBreakfastString());
        TextView average_calaories = (TextView) convertView.findViewById(R.id.textView21);
        average_calaories.setText(caloriesListItems.getAverage());



        return convertView;
    }

}