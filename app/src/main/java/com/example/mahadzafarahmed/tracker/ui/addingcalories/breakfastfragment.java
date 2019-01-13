package com.example.mahadzafarahmed.tracker.ui.addingcalories;

import android.content.Intent;
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
import com.example.mahadzafarahmed.tracker.Register;
import com.example.mahadzafarahmed.tracker.ui.viewcalories.view_caloriesdata;

public class breakfastfragment extends Fragment {

    private Button b2;
    private EditText addbreakfast;
    private Button b3;
    DatabaseHelper db;




    public breakfastfragment() {


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.breakfast, container, false);

        b2 = (Button) v.findViewById(R.id.button8);
        b3 = (Button) v.findViewById(R.id.button7);
        addbreakfast = (EditText) v.findViewById(R.id.editText2);
        db = new DatabaseHelper(getContext());


        // return to previous activity
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddingcaloriesFragment fragment = new AddingcaloriesFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragment);
                transaction.commit();
            }
        });

        // adding data
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int breakfastcalaories = Integer.parseInt(addbreakfast.getText().toString());
                    // inserting note in db and getting
                    // newly inserted note id
                    long id = db.insertBreakfast(breakfastcalaories);
                    Toast.makeText(getActivity(),"Data Entered Successfully!",Toast.LENGTH_SHORT).show();
                    addbreakfast.getText().clear();
                    view_caloriesdata fragment = new view_caloriesdata();
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, fragment);
                    transaction.commit();





            }
        });
        return v;

    }
}
