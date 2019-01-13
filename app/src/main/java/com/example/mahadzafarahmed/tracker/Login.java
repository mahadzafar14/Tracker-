package com.example.mahadzafarahmed.tracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private Button b;
    private Button b2;
    private EditText a;
    private EditText c;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b = (Button) findViewById(R.id.buttonx);
        b2 = (Button) findViewById(R.id.buttony);
        a = (EditText) findViewById(R.id.editTextuserusername);
        c = (EditText) findViewById(R.id.editTextpassworduser);
        db = new DatabaseHelper(getBaseContext());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Register.class);
                startActivity(i);
            }
        });
        // login button on click listener
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getting username and password from login page
                String username = a.getText().toString();
                String password = c.getText().toString();

                //getting password from database for verification
                String storedPassword = db.getSinlgeEntry(username);

                // check if the Stored password matches the other password
                if(password.equals(storedPassword)) {
                    Toast.makeText(v.getContext(),"Login Successful!",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(v.getContext(), MainActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(v.getContext(),"Password or username incorrect.Please try again or register!",Toast.LENGTH_SHORT).show();

                }

            }
        });


    }
}
