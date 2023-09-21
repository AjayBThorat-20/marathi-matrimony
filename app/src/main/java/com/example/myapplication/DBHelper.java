package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "MarathiM.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDb) {
        MyDb.execSQL("create Table Users(username Text,email Text UNIQUE ,mobile Text, password Text,gender Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDb, int oldVersion, int newVersion) {
        MyDb.execSQL("drop Table if exists Users");
    }

    public Boolean insertData(String username,String email, String mobile, String password, String gender){
        SQLiteDatabase MyDb =this.getReadableDatabase();
        ContentValues  contentValues =new ContentValues();
        contentValues.put("username",username);
        contentValues.put("email",email);
        contentValues.put("mobile",mobile);
        contentValues.put("password",password);
        contentValues.put("gender",gender);
        long result = MyDb.insert("Users",null,contentValues);


        if (result== -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean checkemail(String email){
        SQLiteDatabase MyDb =this.getReadableDatabase();
        Cursor cursor = MyDb.rawQuery("select * from Users where email = ?", new String[] {email});
        if (cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }


    public  Boolean checkemailPassword(String email, String password){
        SQLiteDatabase MyDb =this.getReadableDatabase();
        Cursor cursor = MyDb.rawQuery("select * from Users where email = ? and password =?", new String[] {email,password});
        if (cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
}
