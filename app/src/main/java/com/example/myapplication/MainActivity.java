package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText lUserEmail,lPassword;
    Button button;
    TextView register;
    DBHelper MyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lUserEmail = (EditText)findViewById(R.id.lUserEmail);
        lPassword = (EditText)findViewById(R.id.lPassword);
        button = (Button)findViewById(R.id.button);
        register = (TextView)findViewById(R.id.register);

        MyDB = new DBHelper(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailId = lUserEmail.getText().toString();
                String pass = lPassword.getText().toString();


                if (emailId.equals("")||pass.equals("")){
                    Toast.makeText(MainActivity.this, "Please Enter the Credentials.", Toast.LENGTH_SHORT).show();
                    Log.e("tag", "Enter Credentials");
                }
                else{
                    Boolean result = MyDB.checkemailPassword(emailId,pass);
                    if(result == true){
                        Intent intent = new Intent(getApplicationContext(),home.class);
                        startActivity(intent);
                        Log.e("tag", "checking email and Password");
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Invalid Credentials.", Toast.LENGTH_SHORT).show();
                        Log.e("tag", "Invalid Credentials");
                    }
                }
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),userregister.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "login page", Toast.LENGTH_SHORT).show();
                Log.e("tag", "login page");
            }
        });

    }



}
