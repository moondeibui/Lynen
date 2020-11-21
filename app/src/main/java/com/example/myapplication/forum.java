package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class forum extends AppCompatActivity {

    DatabaseHelper myDb;

    private ImageButton imageButton ;

    ImageButton forum ;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        myDb = new DatabaseHelper (this) ;

        forum = (ImageButton) findViewById (R.id.imageButton8) ;

        imageButton = (ImageButton) findViewById (R.id.imageButton12) ;



        forum.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick (View v) {
                Cursor res = myDb.getAllData();
                if (res.getCount() == 0) {

                    showMessage ("Error", "Nothing Found") ;
                    return ;
                }
                StringBuffer buffer = new StringBuffer () ;
                while ( res.moveToNext()) {
                    buffer.append ("ID " + res.getString(0) +"\n") ;
                    buffer.append ("Thread_title " + res.getString (1) +"\n") ;
                    buffer.append ("Thread" + res.getString (3) + "\n") ;
                }

                showMessage("Forum", buffer.toString()) ;
            }
        });










        imageButton.setOnClickListener(new View.OnClickListener () {




            @Override
            public void onClick (View theview ) {

                openActivity2() ;

            }
        });






    }

    public void openActivity2 () {

        Intent intent = new Intent ( this, postforum.class) ;

        startActivity(intent) ;

    }

    public void  showMessage (String title , String Message ) {

        AlertDialog.Builder builder = new AlertDialog.Builder (this) ;

        builder.setCancelable (true) ;
        builder.setTitle (title) ;
        builder.setMessage (Message) ;
        builder.show () ;




    }
}