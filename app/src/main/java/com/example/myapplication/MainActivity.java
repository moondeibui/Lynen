package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    public ImageButton recycleClothes, locateBin, product, statistics,login;;
    public ImageButton forum;
    public ImageButton adoptbin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleClothes = findViewById(R.id.main_page_recycle_btn);
        locateBin = findViewById(R.id.main_page_locate_btn);
        product = findViewById(R.id.main_page_product_btn);
        forum = findViewById(R.id.main_page_community_faqs_btn);
        adoptbin = findViewById (R.id.main_page_adopt_bin_btn);
        statistics = findViewById(R.id.main_page_statistics_btn);
        login = findViewById(R.id.main_page_login_signup_btn);

//        @Override
//        protected void onStart(){
//            super.onStart();

            recycleClothes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, RecycleClothes.class);
                    startActivity(intent);
                }
            });

            locateBin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, LocateLynenBin.class);
                    startActivity(intent);
                }
            });

            product.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, MainProduct.class);
                    startActivity(intent);
                }
            });

            forum.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View view){
                    Intent intent = new Intent (MainActivity.this, forum.class);
                    startActivity(intent);
                }
            });
            adoptbin.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent (MainActivity.this, adoptbin.class);
                    startActivity(intent);
                }
            });

        statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StatisticsMalaysia.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, loginPage.class);
                startActivity(intent);
            }
        });
        }
}



