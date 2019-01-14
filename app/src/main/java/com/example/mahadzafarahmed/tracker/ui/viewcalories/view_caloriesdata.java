package com.example.mahadzafarahmed.tracker.ui.viewcalories;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.mahadzafarahmed.tracker.CaloriesListAdapter;
import com.example.mahadzafarahmed.tracker.CaloriesListItems;
import com.example.mahadzafarahmed.tracker.DatabaseHelper;
import com.example.mahadzafarahmed.tracker.R;
import com.example.mahadzafarahmed.tracker.view_calories;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class view_caloriesdata extends Fragment {

    private Button b;
    DatabaseHelper db;
    ListView calaorieslist;
    private ArrayList<String> listItem;
    private ArrayList<CaloriesListItems> contactList;
    private ArrayAdapter adapter;
    private ListView lvCustomList;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.view_calaoriesdata, container, false);
        b = (Button) v.findViewById(R.id.button18);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), view_calories.class);
                startActivity(i);
            }
        });

        //viewing data
        db = new DatabaseHelper(getContext());
        // listItem = new ArrayList<>();
        calaorieslist = v.findViewById(R.id.calaories_list);
       // viewData();
        showlist();


        return v;
    }



    private void showlist() {
        ArrayList<CaloriesListItems> contactList = new ArrayList();
        contactList.clear();
        Cursor c1 = db.viewData();
        if (c1 != null && c1.getCount() != 0 && c1.moveToFirst()) {
            do {
                CaloriesListItems caloriesListItems = new CaloriesListItems();
                caloriesListItems.setBreakfastc(c1.getString(c1.getColumnIndex("Breakfast")));

                caloriesListItems.setTimestamp(c1.getString(c1.getColumnIndex("Time")));
                //caloriesListItems.setBreakfastString(c1.getColumnName(1));





                contactList.add(caloriesListItems);
            } while(c1.moveToNext());
        }

        c1.close();
        CaloriesListAdapter caloriesListAdapter = new CaloriesListAdapter(getActivity(), contactList);
        calaorieslist.setAdapter(caloriesListAdapter);
    }






}
