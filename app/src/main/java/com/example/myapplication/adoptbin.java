package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageButton;

public class adoptbin extends AppCompatActivity {


    private ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoptbin);

        button = findViewById (R.id.imageButton7);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View theview) {
                openActivity2();



            }

        });

    }

    public void openActivity2() {


        Intent intent = new Intent(this, adoptbin2.class) ;

        startActivity(intent);

    }
}