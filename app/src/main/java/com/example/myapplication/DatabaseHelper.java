package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "forum.db" ;
    public static final String TABLE_NAME    = "Thread_table" ;
    public static final String COL_1         = "ID" ;
    public static final String COL_2         = "Thread_title" ;
    public static final String COL_3         = "Thread" ;




    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

        SQLiteDatabase db = this.getWritableDatabase () ;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL ("CREATE TABLE Thread_table (ID INTEGER PRIMARY KEY AUTOINCREMENT, THREAD_TITLE TEXT, THREAD TEXT)") ;


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL (" DROP TABLE IF EXISTS " + TABLE_NAME) ;
        onCreate(db);


    }
    public boolean insertData (String Thread_title, String Thread) {


        SQLiteDatabase db = this.getWritableDatabase () ;
        ContentValues contentValues = new ContentValues () ;
        contentValues.put (COL_2, Thread_title) ;
        contentValues.put (COL_3, Thread) ;

        long result = db.insert (TABLE_NAME, null , contentValues) ;

        if (result == -1 )
            return false ;

        else
            return true;



    }

    public Cursor getAllData () {

        SQLiteDatabase db = this.getWritableDatabase() ;
        Cursor res = db.rawQuery ("select * from " + TABLE_NAME, null) ;
        return res;
    }


}
