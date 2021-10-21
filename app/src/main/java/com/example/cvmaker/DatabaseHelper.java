package com.example.cvmaker;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.IOException;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "cvDatabas8";
    public static final String CONTACTS_TABLE_NAME = "cvTable6";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(
                    "create table " + CONTACTS_TABLE_NAME + "(id INTEGER PRIMARY KEY, name text, jobTitle text,email  text,birthday text, phone text,nationality text, school text, college text , versity text, skills text , experience text/*, image Blob*/)"
            );
        } catch (
                SQLiteException e) {
            try {
                throw new IOException(e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CONTACTS_TABLE_NAME);
        onCreate(db);
    }

    public boolean insert(String s, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11/*, byte[] img */) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", s);
        contentValues.put("jobTitle",s2 );
        contentValues.put("email",s3 );
        contentValues.put("birthday",s4 );
        contentValues.put("phone",s5 );
        contentValues.put("nationality", s6);
        contentValues.put("school", s7);
        contentValues.put("college", s8);
        contentValues.put("versity", s9);
        contentValues.put("skills", s10);
        contentValues.put("experience", s11);
        //contentValues.put("image",img);
        db.replace(CONTACTS_TABLE_NAME, null, contentValues);
        return true;
    }


    public String getContacts() {
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle") Cursor res = db.rawQuery("select * from " +CONTACTS_TABLE_NAME, null);
        res.moveToLast();
        String s= "";
        while (res.isAfterLast() == false) {
            s = res.getString(res.getColumnIndex("name" )) +
                    ";" + res.getString(res.getColumnIndex("jobTitle" )) +
                    ";" + res.getString(res.getColumnIndex("email" )) +
                    ";" + res.getString(res.getColumnIndex("phone" )) +
                    ";" + res.getString(res.getColumnIndex("birthday" )) +
                    ";" + res.getString(res.getColumnIndex("nationality" )) +
                    ";" + res.getString(res.getColumnIndex("school" )) +
                    ";" + res.getString(res.getColumnIndex("college" )) +
                    ";" + res.getString(res.getColumnIndex("versity" )) +
                    ";" + res.getString(res.getColumnIndex("skills" )) +
                    ";"+res.getString(res.getColumnIndex("experience" ));

            res.moveToNext();
        }
        return s;
    }

    public boolean getcheck() {

        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle") Cursor res = db.rawQuery("select * from " +CONTACTS_TABLE_NAME, null);
        res.moveToLast();
        while (res.isAfterLast() == false) {
            return true;
        }return false;
        }
    }

    
    /*
    public boolean update(String s, String s1){
    SQLiteDatabase db = this.getReadableDatabase();
    db.execSQL("UPDATE "+ CONTACTS_TABLE_NAME + " SET name = " + "'"+s+"' "+ "WHERE salary = "+"'"+s1+"'");
    return true;

    }*/

