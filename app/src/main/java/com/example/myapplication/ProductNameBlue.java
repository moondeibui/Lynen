package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import android.os.Bundle;

public class ProductNameBlue extends AppCompatActivity {

    public Button checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_blue);

        checkout = findViewById(R.id.check_out);
    }

    @Override
    protected void onStart() {
        super.onStart();

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductNameBlue.this, PaymentBlue.class);
                startActivity(intent);
            }
        });

    }
}