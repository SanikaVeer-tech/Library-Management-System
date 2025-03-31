package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.util.Log;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class see_request_list extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton request_button;

    ImageView empty_imageview;

    MyDatabaseHelper2 myDB;
    ArrayList<String> book_id, username, book_name, days, status;
    CustomAdapterr2 customAdapterr2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_request_list);

        recyclerView = findViewById(R.id.recyclerview2);
        request_button = findViewById(R.id.request_button);

        empty_imageview = findViewById(R.id.empty_imageView2);
        request_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(see_request_list.this, BookRequestActivity.class);
                startActivity(intent);
            }

        });

        myDB = new MyDatabaseHelper2(see_request_list.this);
        book_id = new ArrayList<>();
        username = new ArrayList<>();
        book_name = new ArrayList<>();
        days = new ArrayList<>();
        status = new ArrayList<>();
        storeDataInArrays();
        customAdapterr2 = new CustomAdapterr2(see_request_list.this,this, book_id, username, book_name, days, status);
        recyclerView.setAdapter(customAdapterr2);
        recyclerView.setLayoutManager(new LinearLayoutManager(see_request_list.this));
    }

    void storeDataInArrays() {
        Cursor cursor = myDB.requestAllData();
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    do {
                        for (int i = 0; i < cursor.getColumnCount(); i++) {
                            Log.d("CursorData", "Column " + i + ": " + cursor.getString(i));
                        }

                        book_id.add(cursor.getString(0));
                        username.add(cursor.getString(1));
                        book_name.add(cursor.getString(2));
                        days.add(cursor.getString(3));
                        status.add(cursor.getString(4));
                    } while (cursor.moveToNext());
                }
            } catch (Exception e) {
                Log.e("CursorError", "Error reading data from cursor", e);
            } finally {
                cursor.close();
            }
        } else {
            Log.e("CursorError", "Cursor is null");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


}
