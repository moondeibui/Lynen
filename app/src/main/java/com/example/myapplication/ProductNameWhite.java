package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ProductNameWhite extends AppCompatActivity {

    public ImageButton checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_white);

        checkout = findViewById(R.id.check_out1);
    }

    @Override
    protected void onStart() {
        super.onStart();

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductNameWhite.this, PaymentWhite.class);
                startActivity(intent);
            }
        });

    }
}