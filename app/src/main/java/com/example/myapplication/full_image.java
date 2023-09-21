package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Objects;

public class full_image extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        ImageView imageView = findViewById(R.id.image_full);
        int img_id = Objects.requireNonNull(getIntent().getExtras()).getInt("img_id");

        imageView.setImageResource(img_id);

    }
}
