package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class userregister extends AppCompatActivity {

    EditText rUserName,rUserEmail,rUserPhone,rPassword,rConfirmPassword;
    RadioGroup rUserGender;
//    RadioButton rUserMale,rUserFemale;
    Button signupbtn;
    TextView tvSigIn;
    DBHelper MyDB;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userregister);

        rUserName = (EditText)findViewById(R.id.rUserName);
        rUserEmail = (EditText)findViewById(R.id.rUserEmail);
        rUserPhone = (EditText)findViewById(R.id.rUserPhone);
        rPassword = (EditText)findViewById(R.id.rPassword);
        rConfirmPassword = (EditText)findViewById(R.id.rConfirmPassword);
        rUserGender = findViewById(R.id.rUserGender);
        signupbtn = (Button)findViewById(R.id.signupbtn);
        tvSigIn = (TextView)findViewById(R.id.tvSigIn);

        MyDB = new DBHelper(this);



        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = rUserName.getText().toString();
                String email = rUserEmail.getText().toString();
                String mobile = rUserPhone.getText().toString();
                String password = rPassword.getText().toString();
                String confirm = rConfirmPassword.getText().toString();
                RadioButton checkedBtn = findViewById(rUserGender.getCheckedRadioButtonId());
                String gender = checkedBtn.getText().toString();


                if (username.equals("")||email.equals("")||mobile.equals("")||password.equals("")||confirm.equals("")||gender.equals(""))
                {
                    Toast.makeText(userregister.this, "Fill all the Fields", Toast.LENGTH_SHORT).show();
                    Log.e("tag", " all the Fields");
                }
                else
                    {
                        if(password.equals(confirm))
                        {
                            Boolean usercheckemail = MyDB.checkemail(email);
                            if(!usercheckemail)
                            {
                                Boolean regResult = MyDB.insertData(username,email,mobile,password,gender);
                                if(regResult)
                                {
                                    Toast.makeText(userregister.this, "Registration Successful.", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),home.class);
                                    startActivity(intent);
                                    Log.e("tag", "Successful");
                                }
                                else
                                    {
                                    Toast.makeText(userregister.this, "Registration Failed \n Try Again.", Toast.LENGTH_SHORT).show();
                                        Log.e("tag", "Registration f");

                                    }
                                }
                            else
                                {
                                Toast.makeText(userregister.this, "User Is Already Exists. \n Please Sign In.", Toast.LENGTH_SHORT).show();
                                    Log.e("tag", "Already Exists");

                                }
                        }
                        else
                        {
                        Toast.makeText(userregister.this, "Password Is Not Matching", Toast.LENGTH_SHORT).show();
                            Log.e("tag", "Password Is Not Matching");
                        }
                    }
            }
        });






        tvSigIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                Toast.makeText(userregister.this, "login page", Toast.LENGTH_SHORT).show();
                Log.e("tag", "login page");
            }
        });


    }


}
