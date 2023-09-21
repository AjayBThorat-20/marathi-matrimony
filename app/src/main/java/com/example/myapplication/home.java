package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class home extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass> userList;
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.homenav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homenav:
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
                        startActivity(new Intent(getApplicationContext(),settings.class));
                        overridePendingTransition(0,0);
                        return true;



                }
                return false;
            }
        });


        initData();
        initRecycleView();

    }

    private void initData() {
        userList = new ArrayList<>();
        userList.add(new ModelClass(R.drawable.f1,"Maya","18-02-1999","M.Com","In Finance","Exchanger","Goa"));
        userList.add(new ModelClass(R.drawable.f2,"Vidya","8-02-1995","MSC","Devloper","Exchanger","Bangluru"));
        userList.add(new ModelClass(R.drawable.f3,"Janvi","18-02-1998","MBA","Buisiness Accountant","GROW MORE","Lakhnaw"));
        userList.add(new ModelClass(R.drawable.f4,"Gayatri","8-02-1997","DMLT","Technician","Life Care Hospital","Chennai"));
        userList.add(new ModelClass(R.drawable.f5,"Pallavi","18-02-1996","Architectural engineering ","Architecture","Lodha","Mumbai"));






    }

    private void initRecycleView() {

        recyclerView=findViewById(R.id.showusers);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(userList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
