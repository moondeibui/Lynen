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

public class loginPage extends AppCompatActivity {

    EditText etUsername,etPassword;
    Button btSubmit,btSignUp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        etUsername = findViewById(R.id.et_username);
        etPassword= findViewById(R.id.et_password);
        btSubmit =  findViewById(R.id.bt_submit);
        btSignUp =  findViewById(R.id.bt_signUp);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUsername.getText().toString().equals("admin") &&
                etPassword.getText().toString().equals("admin")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            loginPage.this, R.style.AlertDialogTheme
                    );

                    builder.setIcon(R.drawable.ic_check_circle);
                    builder.setTitle("Login Successfully!!!!");
                    builder.setMessage("Welcome");

                    builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(loginPage.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Username & Password", Toast.LENGTH_SHORT).show();
                }
            }

        });


        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginPage.this, SignUp.class);
                startActivity(intent);
            }
        });

    }
}