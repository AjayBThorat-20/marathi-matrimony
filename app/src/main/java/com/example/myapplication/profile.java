package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;

public class profile extends AppCompatActivity {
    ArrayList<Integer>mImageIds = new ArrayList<>(Arrays.asList(
                        R.drawable.p1,R.drawable.p2,R.drawable.p3,
            R.drawable.p4, R.drawable.p5,R.drawable.p6
    ));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.profilenav);

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
                        return true;
                    case R.id.settingsnav:
                        startActivity(new Intent(getApplicationContext(),settings.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });





// for image view
        GridView gridView = findViewById(R.id.mygrid);
        gridView.setAdapter(new ImageAdapter(mImageIds,profile.this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int item_pos = mImageIds.get(position);
                ShowDialogBox(item_pos);
            }
        });

    }

    public void ShowDialogBox (final int item_pos){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);

        //getting custom dialog views
        ImageButton Image_btn = dialog.findViewById(R.id.btn_close);
        TextView Image_name = dialog.findViewById(R.id.textView_ImageName);
        ImageView Image= dialog.findViewById(R.id.imageView4);


        String title = getResources().getResourceName(item_pos);

        int index = title.indexOf("/");
        String name = title.substring(index+1,title.length());
        Image_name.setText(name);

        Image.setImageResource(item_pos);


        Image_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile.this,full_image.class);
                intent.putExtra("img_id",item_pos);
                startActivity(intent);
            }
        });

        dialog.show();





    }


}
