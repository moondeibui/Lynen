package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class adoptbin2 extends AppCompatActivity {

    private ImageButton yesButton;

    private ImageButton noButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoptbin2);

        yesButton = findViewById (R.id.imageButton3);

        noButton  = findViewById (R.id.imageButton6);

        yesButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View theview) {
                openActivity();
            }




        });
        noButton.setOnClickListener (new View.OnClickListener(){

            @Override
            public void onClick (View theView2) {
                openActivity2();
            }
        });

    }

    public void openActivity() {

        Intent intent = new Intent(this, MainActivity.class) ;

        startActivity(intent);


    }

    public void openActivity2() {

        Intent intent2 = new Intent (this, MainActivity.class) ;

        startActivity(intent2);
    }

    




}