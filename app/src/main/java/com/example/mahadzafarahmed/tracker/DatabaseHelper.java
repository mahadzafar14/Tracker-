package com.example.mahadzafarahmed.tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String Database_name = "calaoriesdatabase";
    public static final String TABLE_NAME = "datatable";
    public static final String TABLE_NAME1 = "registertable";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_ID1 = "ID";
    public static final String COLUMN_Breakfast = "Breakfast";
    //public static final String COLUMN_Lunch = "Lunch";
    //public static final String COLUMN_Dinner = "Dinner";
    //public static final String COLUMN_Snacks = "Snacks";
    public static final String COLUMN_TIMESTAMP = "Time";
    public static final String username = "username";
    public static final String password = "password";
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_Breakfast + " INTEGER,"
                 //   + COLUMN_Lunch + " INTEGER,"
                 //   + COLUMN_Dinner + " INTEGER,"
                 //   + COLUMN_Snacks + " INTEGER,"
                    + COLUMN_TIMESTAMP + " text "
                    + ")";
    public static final String CREATE_TABLE1 =
            "CREATE TABLE " + TABLE_NAME1 + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + username + " text,"
                    + password + " text"
                    + ")";



    public DatabaseHelper(Context context) {

        super(context, Database_name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {


            db.execSQL(CREATE_TABLE1);
            db.execSQL(CREATE_TABLE);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    public long insertBreakfast(int n) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(COLUMN_Breakfast, n);
        values.put(COLUMN_TIMESTAMP,getDateTime());

        // insert row
        long id = db.insert(TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    /*public long insertLunch(int n) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(COLUMN_Lunch, n);

        // insert row
        long id = db.insert(TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public long insertDinner(int n) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(COLUMN_Dinner, n);

        // insert row
        long id = db.insert(TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public long insertSnacks(int n) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(COLUMN_Snacks, n);

        // insert row
        long id = db.insert(TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }*/

    public Cursor viewData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        return cursor;

    }

    public long insertUser(String username1, String password1) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(username,username1);
        values.put(password,password1);
        long todo_id = db.insert(TABLE_NAME1,null,values);
        db.close();
        return todo_id;

    }



    public Cursor viewAvg() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT AVG("+COLUMN_Breakfast +") FROM "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        return cursor;

    }

    public String getSinlgeEntry(String userName)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.query("registertable", null, " username=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("password"));
        cursor.close();
        return password;
    }









}
