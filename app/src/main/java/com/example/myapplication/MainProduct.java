package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainProduct extends AppCompatActivity {

    public ImageButton blue, white, clay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_btn);

        blue = findViewById(R.id.product_image_blue);
        white =  findViewById(R.id.product_image_white);
        clay = findViewById(R.id.product_image_clay);
    }

    @Override
    protected void onStart() {
        super.onStart();

        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainProduct.this, ProductNameBlue.class);
                startActivity(intent);
            }
        });

        white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainProduct.this, ProductNameWhite.class);
                startActivity(intent);
            }
        });

        clay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainProduct.this, ProductNameClay.class);
                startActivity(intent);
            }
        });
    }
}