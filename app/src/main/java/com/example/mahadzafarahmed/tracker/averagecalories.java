package com.example.mahadzafarahmed.tracker;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.mahadzafarahmed.tracker.ui.viewcalories.ViewCaloriesFragment;

import java.util.ArrayList;


public class averagecalories extends Fragment {

    private Button b2;
    DatabaseHelper db;
    ListView datalist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.averagecalaories, container, false);


        b2 = (Button) v.findViewById(R.id.button20);
        db = new DatabaseHelper(getContext());
        // listItem = new ArrayList<>();
        datalist = v.findViewById(R.id.average_list);
        showlist();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewCaloriesFragment fragment = new ViewCaloriesFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragment);
                transaction.commit();
            }
        });

        return v;
    }


    private void showlist() {
        ArrayList<CaloriesListItems> contactList = new ArrayList();
        contactList.clear();
        Cursor c1 = db.viewAvg();
        Cursor c2 = db.viewData();
        if (c1 != null && c1.getCount() != 0 && c1.moveToFirst()) {
            do {
                CaloriesListItems caloriesListItems = new CaloriesListItems();
                caloriesListItems.setAverage(c1.getString(c1.getColumnIndex("AVG(Breakfast)")));
                //caloriesListItems.setBreakfastString(c2.getColumnName(1));






                contactList.add(caloriesListItems);
            } while(c1.moveToNext());
        }

        c1.close();
        CaloriesListAdapter2 contactListAdapter = new CaloriesListAdapter2(getActivity(), contactList);
        datalist.setAdapter(contactListAdapter);
    }

}
