package com.example.familia.ejemplofragments;

import  android.app.ActionBar;
import android.content.ContentValues;
import android.database.Cursor;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="people.db";
    public static final String TABLE_NAME="people_table";
    public static final String COL1="ID";
    public static final String COL2="SALON";
    public static final String COL3="SEDE";
    public static final String COL4="EDIFICIO";

    public DataBaseHelper(Context context){
        super(context,DATABASE_NAME,null,2);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable =  "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " SALON TEXT, SEDE TEXT, EDIFICIO TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP  TABLE  " + TABLE_NAME);
        onCreate(db);
    }
    public boolean addData(String salon,String sede,String edificio){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL2,salon);
        contentValues.put(COL3,sede);
        contentValues.put(COL4,edificio);

        long result=db.insert(TABLE_NAME,null,contentValues);
        if (result==-1){
            return false;

        }else {
            return true;

        }


    }


    public Cursor showData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }
}


