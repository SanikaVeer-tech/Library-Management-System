package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity4 extends AppCompatActivity {
    Button btn_logout, btn_booklist, btn_add, btn_requested_book;
    FirebaseAuth auth;
    TextView textView;
    FirebaseUser user;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        auth = FirebaseAuth.getInstance();
        btn_logout = findViewById(R.id.logout);
        btn_booklist = findViewById(R.id.see_book_list);
        btn_add = findViewById(R.id.add_button);
        btn_requested_book = findViewById(R.id.requested_book_list);
        textView = findViewById(R.id.user_details);
        user = auth.getCurrentUser();
        if(user == null){
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();

            }
        });

        btn_booklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this, MainActivity.class);
                startActivity(intent);

            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this, AddActivity.class);
                startActivity(intent);

            }
        });
        btn_requested_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this, see_request_list.class);
                startActivity(intent);

            }
        });

    }
}