package com.example.assignmentfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = findViewById(R.id.add_book);
        Button b2 = findViewById(R.id.show_book);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n1 = new Intent(getApplicationContext(),LoginAdmin.class);
                startActivity(n1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n2 = new Intent(getApplicationContext(),ShowAllBooks.class);
                startActivity(n2);
            }
        });

    }
}
