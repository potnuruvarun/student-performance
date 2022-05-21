package com.example.student_performance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(ID INTEGER PRIMARY KEY AUTOINCREMENT, subname TEXT , basket TEXT, credit TEXT, semester TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetails");
        onCreate(DB);
    }

    public Boolean insertuserdata(String subname, String basket, String credit, String semester)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("subname", subname);
        contentValues.put("basket", basket);
        contentValues.put("credit", credit);
        contentValues.put("semester", semester);
        long result=DB.insert("Userdetails", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }


    public Boolean updateuserdata(String subname, String basket, String credit, String semester) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("subname", subname);
        contentValues.put("basket", basket);
        contentValues.put("credit", credit);
        contentValues.put("semester", semester);
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{subname});
        if (cursor.getCount() > 0) {
            long result = DB.update("Userdetails", contentValues, "name=?", new String[]{subname});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }}


    public Boolean deletedata (String subname)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails where subname = ?", new String[]{subname});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Userdetails", "subname=?", new String[]{subname});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        return cursor;

    }
}




