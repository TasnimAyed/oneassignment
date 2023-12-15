package com.example.oneassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    private Button missesBtn;
    private Button teachbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        missesBtn = findViewById(R.id.missBtn);
        missesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,missActivity.class);
                startActivity(intent);
            }
        });
        teachbtn = findViewById(R.id.techBtn);
        teachbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,techActivity.class);
                startActivity(intent);
            }
        });
    }
}

