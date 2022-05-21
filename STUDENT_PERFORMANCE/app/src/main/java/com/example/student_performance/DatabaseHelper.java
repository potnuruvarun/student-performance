package com.example.student_performance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static  final String DATABASE_NAME="students.db";
    public static  final String TABLE_NAME="s1_table";
    public static  final String COL_1="ID";
    public static  final String COL_2="NAME";
    public static  final String COL_3="GENDER";
    public static  final String COL_4="EMAIL";
    public static  final String COL_6="PHONE";
    public static  final String COL_7="DOB";
    public static  final String COL_8="BLOOD_GROUP";
    public static  final String COL_9="Semester";
    public static  final String COL_10="DEPARTMENT";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,GENDER TEXT,EMAIL TEXT,PASSWORD TEXT,PHONE INTEGER,DOB INTEGER,BLOOD_GROUP TEXT,SEMESTER INTEGER,DEPARTMENT TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE if EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(String name,String gender,String email,String phone,String dob,String blood_group,String semester,String department)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, gender);
        contentValues.put(COL_4, email);
        contentValues.put(COL_6, phone);
        contentValues.put(COL_7, dob);
        contentValues.put(COL_8, blood_group);
        contentValues.put(COL_9,semester);
        contentValues.put(COL_10, department);
        long result=db.insert(TABLE_NAME,null ,contentValues);

        if(result==-1)
            return false;
        else
            return true;
    }
    public Cursor getData()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("Select * from " +TABLE_NAME,null);
        return res;
    }
    public boolean updateData(String id, String name, String surname, String marks)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, marks);
        db.update(TABLE_NAME,contentValues," id = ? ",new String[] {id});
        return true;
    }
    public int delData(String id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.delete(TABLE_NAME," id = ? ",new String[] {id});
    }
}