package com.example.mylibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class user_list extends AppCompatActivity {


    RecyclerView recyclerView;
    FloatingActionButton add_button;
    ImageView empty_imageview;
    MyDatabaseHelper myDB;
    ArrayList<String> book_id, book_title, book_author, book_pages;
    CustomAdapterr customAdapterr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set the admin layout by default

        recyclerView = findViewById(R.id.recyclerView);
        empty_imageview = findViewById(R.id.empty_imageView);
        add_button = findViewById(R.id.add_button);

        add_button.setVisibility(View.GONE);

        myDB = new MyDatabaseHelper(user_list.this);
        book_id = new ArrayList<>();
        book_title = new ArrayList<>();
        book_author = new ArrayList<>();
        book_pages = new ArrayList<>();

        storeDataInArrays();
        customAdapterr = new CustomAdapterr(user_list.this,this, book_id, book_title, book_author,
                book_pages);
        recyclerView.setAdapter(customAdapterr);
        recyclerView.setLayoutManager(new LinearLayoutManager(user_list.this));
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            empty_imageview.setVisibility(View.VISIBLE);
        } else {
            while (cursor.moveToNext()){
                book_id.add(cursor.getString(0));
                book_title.add(cursor.getString(1));
                book_author.add(cursor.getString(2));
                book_pages.add(cursor.getString(3));
            }
            empty_imageview.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

}