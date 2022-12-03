package com.example.virtualphysicslab;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {

    static final private String DB_name = "VivaData";
    static final private String Table_name = "Student";
    static final private int version = 1;
    Context ct;
    SQLiteDatabase db;

    public MyDatabase(@Nullable Context context) {
        super(context, DB_name, null, version);
        ct = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create TABLE "+Table_name+"(Roll_no text primary key, Name text, Course text, Semester text, Marks integer);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String roll_no, String name, String sem, String course, int marks )
    {
        db = this.getWritableDatabase();
        db.execSQL("insert into "+Table_name+" values ( '"+roll_no+"','"+name+"','"+course+"','"+sem+"','"+marks+"');");
    }

    public String getStudentData()
    {
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+Table_name, null);
        StringBuilder sb = new StringBuilder();
        sb.append(cursor.getColumnName(0)+" "+cursor.getColumnName(1)+ " "+cursor.getColumnName(2)+" "+cursor.getColumnName(3)+"\n");

        while(cursor.moveToNext())
        {
            String s1 = cursor.getString(0);
            String s2 = cursor.getString(1);
            String s3 = cursor.getString(2);
            String s4 = cursor.getString(3);
            int s5 = cursor.getInt(4);
            sb.append(s1+" "+s2+ " "+s3+" "+s4+" "+s5+"\n");
        }
        return sb.toString();
    }

    public ArrayList<String> getRoll()
    {
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+Table_name,null);
        ArrayList<String> arr = new ArrayList<String>();
        while(cursor.moveToNext())
        {
            arr.add( cursor.getString(0));
        }
        return arr;
    }

    public ArrayList<String> getStudentName()
    {
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+Table_name,null);
        ArrayList<String> arr = new ArrayList<String>();
        while(cursor.moveToNext())
        {
            arr.add( cursor.getString(1));
        }
        return arr;
    }

    public ArrayList<String> getSem()
    {
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+Table_name,null);
        ArrayList<String> arr = new ArrayList<String>();
        while(cursor.moveToNext())
        {
            arr.add( cursor.getString(2));
        }
        return arr;
    }

    public ArrayList<String> getCourse()
    {
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+Table_name,null);
        ArrayList<String> arr = new ArrayList<String>();
        while(cursor.moveToNext())
        {
            arr.add( cursor.getString(3));
        }
        return arr;
    }

    public ArrayList<Integer> getMarks()
    {
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+Table_name,null);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(cursor.moveToNext())
        {
            arr.add( cursor.getInt(4));
        }
        return arr;
    }

}
