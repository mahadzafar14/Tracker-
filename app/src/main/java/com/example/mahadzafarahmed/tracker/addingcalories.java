package com.example.mahadzafarahmed.tracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.mahadzafarahmed.tracker.ui.addingcalories.AddingcaloriesFragment;

public class addingcalories extends AppCompatActivity {

    private Button b;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addingcalaories_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, AddingcaloriesFragment.newInstance())
                    .commitNow();


        }



    }
}
