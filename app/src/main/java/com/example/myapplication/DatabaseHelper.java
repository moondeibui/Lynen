package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "recycle_clothes.db";
    public static final String TABLE_NAME = "recycle_clothes_table";
    public static final String COL_1 = "RECYCLE_CLOTHES_ID";
    public static final String COL_2 = "RECYCLE_CLOTHES_TYPE";
    public static final String COL_3 = "RECYCLE_CLOTHES_MATERIAL";
    public static final String COL_4 = "RECYCLE_CLOTHES_BIN_LOCATION";
    public static final String COL_5 = "RECYCLE_CLOTHES_GENDER";
    public static final String COL_6 = "RECYCLE_CLOTHES_IMAGE";

    public static final String DATABASE_NAME_2 = "forum.db" ;
    public static final String TABLE_NAME_2    = "Thread_table" ;
    public static final String COL_FORUM_1         = "ID" ;
    public static final String COL_FORUM_2         = "Thread_title" ;
    public static final String COL_FORUM_3         = "Thread" ;


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (RECYCLE_CLOTHES_ID INTEGER PRIMARY KEY AUTOINCREMENT, RECYCLE_CLOTHES_TYPE TEXT, RECYCLE_CLOTHES_MATERIAL TEXT, RECYCLE_CLOTHES_BIN_LOCATION TEXT, RECYCLE_CLOTHES_GENDER TEXT, RECYCLE_CLOTHES_IMAGE BLOB)");
        db.execSQL ("CREATE TABLE Thread_table (ID INTEGER PRIMARY KEY AUTOINCREMENT, THREAD_TITLE TEXT, THREAD TEXT)") ;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL (" DROP TABLE IF EXISTS " + TABLE_NAME_2) ;
        onCreate(db);
    }

    public boolean insertDataClothes(String clothesType, String clothesMaterial, String clothesBinLocation, String clothesGender, byte[] clothesImage){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, clothesType);
        contentValues.put(COL_3, clothesMaterial);
        contentValues.put(COL_4, clothesBinLocation);
        contentValues.put(COL_5, clothesGender);
        contentValues.put(COL_6, clothesImage);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1){
            return false;
        } else {
            return true;
        }
    }



    public boolean insertData (String Thread_title, String Thread) {

        SQLiteDatabase db = this.getWritableDatabase () ;
        ContentValues contentValues = new ContentValues () ;
        contentValues.put (COL_FORUM_2, Thread_title) ;
        contentValues.put (COL_FORUM_3, Thread) ;
        long result = db.insert (TABLE_NAME_2, null , contentValues) ;
        if (result == -1 )
            return false ;
        else
            return true;
    }

    public Cursor getAllData () {

        SQLiteDatabase db = this.getWritableDatabase() ;
        Cursor res = db.rawQuery ("select * from " + TABLE_NAME_2, null) ;
        return res;
    }

}
