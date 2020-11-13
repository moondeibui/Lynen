package com.example.myapplication;

import android.os.Bundle;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class forum extends AppCompatActivity {

    ExpandableListView expandableListView ;

    ArrayList<String> thelist = new ArrrayList < > ( ) ;
    HashMap<String,ArrayList <String>> thechild = new HashMap < > ( ) ;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById (R.id.expanded_menu) ;



    }



}
