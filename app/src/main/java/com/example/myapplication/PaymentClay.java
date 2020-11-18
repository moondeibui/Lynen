package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PaymentClay extends AppCompatActivity {

    public ImageButton payment2,paypal2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_clay);


        payment2 = findViewById(R.id.card_PayNow_button);
        paypal2 = findViewById(R.id.paypal_Direct_Button);


    }

    @Override
    protected void onStart() {
        super.onStart();

        payment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentClay.this, PaymentSuccess.class);
                startActivity(intent);
            }
        });


        paypal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentClay.this, PaymentSuccess.class);
                startActivity(intent);
            }
        });
    }
}