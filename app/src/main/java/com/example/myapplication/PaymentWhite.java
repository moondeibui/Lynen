package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PaymentWhite extends AppCompatActivity {

    public ImageButton payment1,paypal1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_white);


        payment1 = findViewById(R.id.card_PayNow_button);
        paypal1 = findViewById(R.id.paypal_Direct_Button);


    }

    @Override
    protected void onStart() {
        super.onStart();

        payment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentWhite.this, PaymentSuccess.class);
                startActivity(intent);
            }
        });


        paypal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentWhite.this, PaymentSuccess.class);
                startActivity(intent);
            }
        });
    }
}