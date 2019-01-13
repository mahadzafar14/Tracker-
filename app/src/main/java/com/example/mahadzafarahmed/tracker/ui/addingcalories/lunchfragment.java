package com.example.mahadzafarahmed.tracker.ui.addingcalories;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mahadzafarahmed.tracker.CaloriesListAdapter;
import com.example.mahadzafarahmed.tracker.CaloriesListItems;
import com.example.mahadzafarahmed.tracker.DatabaseHelper;
import com.example.mahadzafarahmed.tracker.R;
import com.example.mahadzafarahmed.tracker.ui.viewcalories.view_caloriesdata;

public class lunchfragment extends Fragment {
    private Button b2;
    private Button b3;
    private EditText addlunch;
    DatabaseHelper db;
    String lunch;

    public lunchfragment() {
        String lunch = "Lunch";
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.lunch, container, false);
        b2 = (Button) v.findViewById(R.id.button10);
        b3 = (Button) v.findViewById(R.id.button9);
        addlunch = (EditText) v.findViewById(R.id.editText111);
        db = new DatabaseHelper(getContext());
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddingcaloriesFragment fragment = new AddingcaloriesFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragment);
                transaction.commit();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int lunchcalories = Integer.parseInt(addlunch.getText().toString());
                // inserting note in db and getting
                // newly inserted note id
                long id = db.insertBreakfast(lunchcalories);
                Toast.makeText(getActivity(),"Data Entered Successfully!",Toast.LENGTH_SHORT).show();
                addlunch.getText().clear();
                view_caloriesdata fragment = new view_caloriesdata();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragment);
                transaction.commit();



            }
        });
        return v;    }




}
