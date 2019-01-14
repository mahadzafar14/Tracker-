package com.example.mahadzafarahmed.tracker;
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.mahadzafarahmed.tracker.ui.addingcalories.lunchfragment;

public class CaloriesListAdapter extends BaseAdapter {

    Context context;
    ArrayList<CaloriesListItems> contactList;
    Button b;
    Button b1;
    Button b2;
    Button b3;
    lunchfragment l;


    public CaloriesListAdapter(Context context, ArrayList<CaloriesListItems> list) {

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
            convertView = inflater.inflate(R.layout.adapter_view_layout2, null);

        }
        TextView breakfastc = (TextView) convertView.findViewById(R.id.textView1);
        breakfastc.setText(caloriesListItems.getBreakfastc());
        TextView timestamp = (TextView) convertView.findViewById(R.id.textView2);
        timestamp.setText(caloriesListItems.getTimestamp());
        //TextView breakfastString = (TextView) convertView.findViewById(R.id.textView12);
        //if statement for setting Calories timing
       // breakfastString.setText(caloriesListItems.getBreakfastString());



        return convertView;
    }

}