package com.mobileapps.week2_weekendproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.mobileapps.week2_weekendproject.ConstantInfo.DATABASE_NAME;
import static com.mobileapps.week2_weekendproject.ConstantInfo.FIRST_NAME;
import static com.mobileapps.week2_weekendproject.ConstantInfo.LAST_NAME;
import static com.mobileapps.week2_weekendproject.ConstantInfo.TABLE_NAME;
import static com.mobileapps.week2_weekendproject.ConstantInfo.USER_NAME_KEY;

public class MySQLHelper extends SQLiteOpenHelper {

    public MySQLHelper(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, DATABASE_NAME, factory, ConstantInfo.DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + "(" + FIRST_NAME + " TEXT PRIMARY KEY, "
                + LAST_NAME + " TEXT)";
        db.execSQL(createTableQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public boolean insertUser(String uFirstName, String uLastName, String uAddress, String uPhoneNumber, String uSkpyeID, String uEmail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantInfo.FIRST_NAME, uFirstName);
        contentValues.put(ConstantInfo.LAST_NAME, uLastName);
        contentValues.put(ConstantInfo.ADDRESS,uAddress);
        contentValues.put(ConstantInfo.PHONE_NUMBER,uPhoneNumber);
        contentValues.put(ConstantInfo.SKYPE_ID,uSkpyeID);
        contentValues.put(ConstantInfo.EMAIL_ADDRESS,uEmail);
        db.insert(TABLE_NAME, null, contentValues);
        return true;
    }

    //To get the information back
    //Cursor is an object that holds our data
    //The code below returns all our users

    public Cursor getAllUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    //The code below Returns only one user

    public Cursor getAllUsersNames() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select " + USER_NAME_KEY + " from " + TABLE_NAME, null);
        return res;
    }
}

