package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BookRequestActivity extends AppCompatActivity {
    EditText username_input, book_name_input, days_input, status_input;
    Button request_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_request);

        username_input = findViewById(R.id.username_input);
        book_name_input = findViewById(R.id.book_name_input);
        days_input = findViewById(R.id.days_input);
        status_input = findViewById(R.id.status_input);
        request_button = findViewById(R.id.request_button);
        request_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper2 myDB = new MyDatabaseHelper2(BookRequestActivity.this);
                myDB.requestBook(username_input.getText().toString().trim(),
                        book_name_input.getText().toString().trim(),
                        status_input.getText().toString().trim(),
                        Integer.valueOf(days_input.getText().toString().trim()));
            }
        });
    }
}