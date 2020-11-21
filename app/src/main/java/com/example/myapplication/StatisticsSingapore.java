package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StatisticsSingapore extends AppCompatActivity {
    Button back1, home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_singapore);

        back1 = findViewById(R.id.bt_back1);
        home = findViewById(R.id.bt_backtohome);

    }
    @Override
    protected void onStart() {
        super.onStart();

        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StatisticsSingapore.this, StatisticsMalaysia.class);
                startActivity(intent);
            }
        });


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StatisticsSingapore.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}