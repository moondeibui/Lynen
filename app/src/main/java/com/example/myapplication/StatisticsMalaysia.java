package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StatisticsMalaysia extends AppCompatActivity {
    Button back, next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_malaysia);

        back = findViewById(R.id.bt_back);
        next = findViewById(R.id.bt_next);

    }
    @Override
    protected void onStart() {
        super.onStart();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StatisticsMalaysia.this, MainActivity.class);
                startActivity(intent);
            }
        });


            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(StatisticsMalaysia.this, StatisticsSingapore.class);
                    startActivity(intent);
                }
            });
        }
    }
