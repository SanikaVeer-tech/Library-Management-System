package com.example.mylibrary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDatabaseHelper2 extends SQLiteOpenHelper {
    private Context context;

    private static final String DATABASE_NAME1 = "MyLibrary2.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_REQUEST = "requet_library";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_BOOKNAME = "book_name";
    private static final String COLUMN_DAYS = "no_of_days";
    private static final String COLUMN_STATUS = "status";

    MyDatabaseHelper2(@Nullable Context context) {
        super(context, DATABASE_NAME1, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query1 =
                "CREATE TABLE " + TABLE_REQUEST +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_USERNAME + " TEXT, " +
                        COLUMN_BOOKNAME + " TEXT, " +
                        COLUMN_STATUS + " TEXT, " +
                        COLUMN_DAYS + " INTEGER); ";
        db.execSQL(query1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REQUEST);
        onCreate(db);
    }

    void requestBook(String username, String bookname, String status, int days) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_USERNAME, username);
        cv.put(COLUMN_BOOKNAME, bookname);
        cv.put(COLUMN_STATUS, status);
        cv.put(COLUMN_DAYS, days);
        long result = db.insert(TABLE_REQUEST, null, cv);
        Log.d("RequestBook", "000result= " + result);
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Requested Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor requestAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery("SELECT * FROM " + TABLE_REQUEST, null);
            if (cursor != null && cursor.moveToFirst()) {
               int statusColumnIndex = cursor.getColumnIndex(COLUMN_STATUS);
                String status = null;
                if (statusColumnIndex != -1) {
                    status = cursor.getString(statusColumnIndex);
                }
            }
        }
        return cursor;
    }

}
