package com.example.mahadzafarahmed.tracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mahadzafarahmed.tracker.ui.viewcalories.ViewCaloriesFragment;

public class view_calories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_calaories_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ViewCaloriesFragment.newInstance())
                    .commitNow();
        }
    }
}
