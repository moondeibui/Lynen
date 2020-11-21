package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class postforum extends AppCompatActivity {

    DatabaseHelper myDb ;
    EditText Thread_title ;
    EditText Thread ;

    ImageButton imageButton ;











    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postforum);

        myDb = new DatabaseHelper (this) ;

        Thread_title = (EditText) findViewById(R.id.editTextTextPersonName5) ;

        Thread       = (EditText) findViewById (R.id.editTextTextPersonName2) ;

        imageButton  = (ImageButton) findViewById (R.id.imageButton) ;

        addData() ;







    }

    public void addData () {

        imageButton.setOnClickListener (

                new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted =  myDb.insertData(Thread_title.getText().toString() , Thread.getText().toString()) ;

                        openActivity2();


                        if ( isInserted = true )
                            Toast.makeText (postforum.this, "Thread posted", Toast.LENGTH_LONG).show() ;
                        else
                            Toast.makeText(postforum.this, "Thread not posted", Toast.LENGTH_LONG).show() ;



                    }
                }
        );
    }

    public void openActivity2 () {

        Intent intent = new Intent(this, backtocomment.class) ;

        startActivity(intent) ;
    }

}