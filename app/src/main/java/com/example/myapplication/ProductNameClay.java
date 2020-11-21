package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ProductNameClay extends AppCompatActivity {

    public Button checkout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_clay);

        checkout2 = findViewById(R.id.check_out2);
    }

    @Override
    protected void onStart() {
        super.onStart();

        checkout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductNameClay.this, PaymentClay.class);
                startActivity(intent);
            }
        });

    }
}