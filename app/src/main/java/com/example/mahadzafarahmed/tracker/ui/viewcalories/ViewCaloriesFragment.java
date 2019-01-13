package com.example.mahadzafarahmed.tracker.ui.viewcalories;

import android.arch.lifecycle.ViewModelProviders;
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

import com.example.mahadzafarahmed.tracker.MainActivity;
import com.example.mahadzafarahmed.tracker.R;
import com.example.mahadzafarahmed.tracker.averagecalories;

public class ViewCaloriesFragment extends Fragment {

    private ViewCaloriesViewModel mViewModel;
    private Button b2;
    private Button b3;
    private Button b4;



    public static ViewCaloriesFragment newInstance() {
        return new ViewCaloriesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.view_calaories_fragment, container, false);
        b2 = (Button) v.findViewById(R.id.button17);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view_caloriesdata fragment = new view_caloriesdata();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragment);
                transaction.commit();
            }
        });

        b3 = (Button) v.findViewById(R.id.button16);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);
            }
        });

        b4 = (Button) v.findViewById(R.id.button19);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                averagecalories fragment = new averagecalories();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragment);
                transaction.commit();
            }
        });




        return v;

    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ViewCaloriesViewModel.class);
        // TODO: Use the ViewModel
    }

}
