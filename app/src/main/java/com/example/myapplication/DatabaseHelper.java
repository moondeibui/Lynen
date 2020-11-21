package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
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


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (RECYCLE_CLOTHES_ID INTEGER PRIMARY KEY AUTOINCREMENT, RECYCLE_CLOTHES_TYPE TEXT, RECYCLE_CLOTHES_MATERIAL TEXT, RECYCLE_CLOTHES_BIN_LOCATION TEXT, RECYCLE_CLOTHES_GENDER TEXT, RECYCLE_CLOTHES_IMAGE BLOB)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String clothesType, String clothesMaterial, String clothesBinLocation, String clothesGender, byte[] clothesImage){
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
}
