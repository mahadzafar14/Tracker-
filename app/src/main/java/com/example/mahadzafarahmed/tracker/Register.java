package com.example.mahadzafarahmed.tracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private Button b;
    private Button b2;
    private EditText a;
    private EditText c;
    DatabaseHelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        b = (Button) findViewById(R.id.button23);
        b2 = (Button) findViewById(R.id.buttonreturn2);
        a = (EditText) findViewById(R.id.editTextuserregister);
        c = (EditText) findViewById(R.id.edittextpasswordregister);
        db = new DatabaseHelper(getBaseContext());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = a.getText().toString();
                String s2 = c.getText().toString();
                long id = db.insertUser(s1,s2);
                Toast.makeText(v.getContext(),"User Registered Successfully!",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);


            }

        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Login.class);
                startActivity(i);


            }

        });


    }
}
