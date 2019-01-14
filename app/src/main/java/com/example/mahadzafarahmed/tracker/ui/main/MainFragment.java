package com.example.mahadzafarahmed.tracker.ui.main;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mahadzafarahmed.tracker.Login;
import com.example.mahadzafarahmed.tracker.R;
import com.example.mahadzafarahmed.tracker.addingcalories;
import com.example.mahadzafarahmed.tracker.view_calories;


public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private Button b;
    private Button b2;
    private Button b3;


    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_fragment, container, false);

        // button on click method area
        b = (Button) v.findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), addingcalories.class);
                startActivity(i);
            }
        });

        b2 = (Button) v.findViewById(R.id.button15);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), view_calories.class);
                startActivity(i);
            }
        });
        b3 = (Button) v.findViewById(R.id.buttonreturn);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Login.class);
                startActivity(i);
            }
        });

        return v;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }



    

}
