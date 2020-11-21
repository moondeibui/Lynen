package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class forum extends AppCompatActivity {

    DatabaseHelper myDb;

    ImageButton imageButton ;

    ImageButton forum ;

    ImageButton postcomment ;

    private static ExpandableListView expandableListView ;
    private static ExpandableListAdapter adapter ;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        myDb = new DatabaseHelper (this) ;

        forum = (ImageButton) findViewById (R.id.imageButton8) ;

        imageButton = (ImageButton) findViewById (R.id.imageButton12) ;

        expandableListView = (ExpandableListView) findViewById (R.id.expanded_menu) ;

        expandableListView.setGroupIndicator(null) ;

        postcomment = (ImageButton) findViewById (R.id.imageButton21) ;

        setItems() ;
        setListener() ;





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
                    buffer.append ("Thread" + res.getString (2) + "\n") ;
                }

                showMessage("Forum", buffer.toString()) ;
            }
        });










        imageButton.setOnClickListener(new View.OnClickListener () {




            @Override
            public void onClick (View theview ) {

                openActivity() ;

            }
        });

        postcomment.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick (View theview) {
                openActivity2() ;
            }





        });






    }

    void setItems() {
        ArrayList<String> header = new ArrayList<String> () ;

        header.add ("What items does Lynen collect ?") ;
        header.add ("What items does Lynen sell ?") ;
        header.add ("How to locate the collection bin ?") ;
        header.add ("How to purchase product using Lynen ?") ;
        header.add ("Where to post question in Lynen ?") ;
        header.add ("Where to make payment on the product that is purchased ?") ;




        List<String> child1 = new ArrayList <String>() ;
        child1.add ("Lynen collects recycle product that is available.") ;


        List<String> child2 = new ArrayList <String>() ;
        child2.add ("Lynen sells product that is made from recycle product.") ;

        List <String> child3 = new ArrayList <String> () ;
        child3.add ("The collection point can be located using the locate bin feature.") ;

        List <String> child4 = new ArrayList <String> () ;
        child4.add ("The product can be purchased at the product page.") ;

        List <String> child5 = new ArrayList <String> () ;
        child5.add ("The question can be posted at the forum page.") ;

        List <String> child6 = new ArrayList <String> () ;
        child6.add ("Payment of product can be made at the payment page. ") ;



        HashMap<String, List<String>> hashMap = new HashMap <String, List <String> > () ;


        hashMap.put (header.get(0), child1) ;
        hashMap.put (header.get(1), child2) ;
        hashMap.put (header.get(2), child3) ;
        hashMap.put (header.get(4), child4) ;
        hashMap.put (header.get(5), child5) ;

        adapter = new ExpandableListAdapter (forum.this, header, hashMap ) ;

        expandableListView.setAdapter (adapter) ;




    }
    void setListener () {


        expandableListView.setOnGroupExpandListener (new ExpandableListView.OnGroupExpandListener() {

            int previousGroup = -1 ;

            @Override

            public void onGroupExpand ( int groupPosition) {

                if (groupPosition != previousGroup)
                expandableListView.collapseGroup (previousGroup) ;
                previousGroup = groupPosition ;

            }


        });
    }

    public void openActivity () {

        Intent intent = new Intent ( this, postforum.class) ;

        startActivity(intent) ;

    }

    public void openActivity2() {

        Intent intent = new Intent ( this, backtocomment.class) ;

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