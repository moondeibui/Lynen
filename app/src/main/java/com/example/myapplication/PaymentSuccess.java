package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class PaymentSuccess extends AppCompatActivity {

    public Button homePage1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success);


        homePage1 = findViewById(R.id.payment_home);

    }
    @Override
    protected void onStart() {
        super.onStart();

        homePage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentSuccess.this, MainProduct.class);
                startActivity(intent);
            }
        });

    }

}