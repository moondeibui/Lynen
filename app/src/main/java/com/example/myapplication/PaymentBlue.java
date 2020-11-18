package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PaymentBlue extends AppCompatActivity {

    public ImageButton payment,paypal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_blue);


        payment = findViewById(R.id.card_PayNow_button);
        paypal = findViewById(R.id.paypal_Direct_Button);


    }

    @Override
    protected void onStart() {
        super.onStart();

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentBlue.this, PaymentSuccess.class);
                startActivity(intent);
            }
        });


        paypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentBlue.this, PaymentSuccess.class);
                startActivity(intent);
            }
        });
    }
}