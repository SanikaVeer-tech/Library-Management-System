package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main3Activity extends AppCompatActivity {
    Button btn_admin, btn_user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btn_admin = findViewById(R.id.btn_admin);
        btn_user = findViewById(R.id.btn_user);

        btn_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, Login.class);
                startActivity(intent);
            }
        });
        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, login_user.class);
                startActivity(intent);

            }
        });

    }
}
