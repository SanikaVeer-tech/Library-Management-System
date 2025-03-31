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

public class UserDashboardActivity extends AppCompatActivity {
    Button btn_logout, btn_booklist, btn_request, btn_requested_list;
    FirebaseAuth auth;
    TextView textView;
    FirebaseUser user;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        auth = FirebaseAuth.getInstance();
        btn_logout = findViewById(R.id.btn_logout);
        btn_booklist = findViewById(R.id.see_book_list);
        btn_request = findViewById(R.id.request_button);
        btn_requested_list = findViewById(R.id.requested_book_list);
        textView = findViewById(R.id.user_details);
        user = auth.getCurrentUser();
        if(user == null){
            Intent intent = new Intent(getApplicationContext(), login_user.class);
            startActivity(intent);
            finish();
        }

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), login_user.class);
                startActivity(intent);
                finish();

            }
        });

        btn_booklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboardActivity.this, user_list.class);
                startActivity(intent);

            }
        });

        btn_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboardActivity.this, BookRequestActivity.class);
                startActivity(intent);

            }
        });

        btn_requested_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboardActivity.this, see_request_list.class);
                startActivity(intent);

            }
        });

    }
}