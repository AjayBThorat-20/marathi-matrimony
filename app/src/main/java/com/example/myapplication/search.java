//package com.example.myapplication;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.MenuItem;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//
//public class search extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search);
//
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//
//        bottomNavigationView.setSelectedItemId(R.id.searchnav);
//
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.homenav:
//                        startActivity(new Intent(getApplicationContext(),home.class));
//                        overridePendingTransition(0,0);
//                        return true;
////                    case R.id.searchnav:
////                        return true;
//                    case R.id.profilenav:
//                        startActivity(new Intent(getApplicationContext(),profile.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.settingsnav:
//                        startActivity(new Intent(getApplicationContext(),settings.class));
//                        overridePendingTransition(0,0);
//                        return true;
//
//
//
//                }
//                return false;
//            }
//        });
//    }
//}
