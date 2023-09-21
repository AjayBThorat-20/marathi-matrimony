package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class settings extends AppCompatActivity {

    LinearLayout logout;
    LinearLayout ln_help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.settingsnav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homenav:
                        startActivity(new Intent(getApplicationContext(),home.class));
                        overridePendingTransition(0,0);
                        return true;
//                    case R.id.searchnav:
//                        startActivity(new Intent(getApplicationContext(),search.class));
//                        overridePendingTransition(0,0);
//                        return true;
                    case R.id.profilenav:
                        startActivity(new Intent(getApplicationContext(),profile.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.settingsnav:

                        return true;



                }
                return false;
            }
        });



        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                startActivity(new Intent(settings.this,MainActivity.class));
                Toast.makeText(settings.this, "login page", Toast.LENGTH_SHORT).show();
                Log.e("tag", "settings page");
            }
        });



        ln_help = findViewById(R.id.ln_help);
        ln_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mailIntent = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("mailto:?subject=" + "Android Development"+ "&body=" + "Hey! Your email text is here" + "&to=" + "ajaythorat988@gmail.com , pratikshelar375@gmail.com");
                mailIntent.setData(data);
                startActivity(Intent.createChooser(mailIntent, "Send mail..."));

                    Toast.makeText(settings.this, "email page", Toast.LENGTH_SHORT).show();
                Log.e("tag", "email page");
            }
        });


    }
}
