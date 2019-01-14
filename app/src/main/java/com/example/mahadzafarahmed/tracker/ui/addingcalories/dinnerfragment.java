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

import com.example.mahadzafarahmed.tracker.DatabaseHelper;
import com.example.mahadzafarahmed.tracker.R;
import com.example.mahadzafarahmed.tracker.ui.viewcalories.view_caloriesdata;

public class dinnerfragment extends Fragment {

    private Button b2;
    private Button b3;
    private EditText adddinner;
    DatabaseHelper db;

    public dinnerfragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dinner, container, false);
        b2 = (Button) v.findViewById(R.id.button12);
        b3 = (Button) v.findViewById(R.id.button11);
        adddinner = (EditText) v.findViewById(R.id.editText3);
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
                String dinner = "Dinner";
                int dinnercalories = Integer.parseInt(adddinner.getText().toString());
                // inserting note in db and getting
                // newly inserted note id
                long id = db.insertBreakfast(dinnercalories);
                Toast.makeText(getActivity(),"Data Entered Successfully!",Toast.LENGTH_SHORT).show();
                adddinner.getText().clear();
                view_caloriesdata fragment = new view_caloriesdata();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragment);
                transaction.commit();






            }
        });

        return v;    }
}
