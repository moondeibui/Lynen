package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    Button signUp;
    EditText password, cpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        password = findViewById(R.id.new_password);
        cpassword= findViewById(R.id.new_cpassword);
        signUp = findViewById(R.id.bt_signUp_page);



     signUp.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (password.getText().toString().equals("admin") &&
                    cpassword.getText().toString().equals("admin")){
                AlertDialog.Builder builder = new AlertDialog.Builder(
                        SignUp.this, R.style.AlertDialogTheme
                );

                builder.setIcon(R.drawable.ic_check_circle);
                builder.setTitle("Sign Up Successfully!!!!");
                builder.setMessage("Welcome");

                builder.setNegativeButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(SignUp.this, MainActivity.class));
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            } else {
                Toast.makeText(getApplicationContext(), "Invalid Password and Confirm Password", Toast.LENGTH_SHORT).show();
            }
        }

    });
    }
}