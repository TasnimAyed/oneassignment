package com.example.oneassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class missActivity extends AppCompatActivity {

    private EditText editText1, editText2, editText3, doneText;
    private Button doneButton,load_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miss);

        editText1 = findViewById(R.id.Note1);
        editText2 = findViewById(R.id.Note2);
        editText3 = findViewById(R.id.Note3);
        doneText = findViewById(R.id.Result);
        doneButton = findViewById(R.id.doneBtn);
        load_btn = findViewById(R.id.loadBtn);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note1 = editText1.getText().toString().trim();
                String note2 = editText2.getText().toString().trim();
                String note3 = editText3.getText().toString().trim();

                if (!note1.isEmpty() && !note2.isEmpty() && !note3.isEmpty()) {
                    doneText.setText(".........................     Done     ...........................");
                } else {
                    doneText.setText("Due --> require to complete ALL the notes * ");
                }


            }
        });

        load_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note1 = editText1.getText().toString().trim();
                String note2 = editText2.getText().toString().trim();
                String note3 = editText3.getText().toString().trim();


                Notes noteData = new Notes();
                noteData.setNote1(note1);
                noteData.setNote2(note2);
                noteData.setNote3(note3);

                Gson gson = new Gson();
                String serializedData = gson.toJson(noteData);
                SharedPreferences sharedPreferences = getSharedPreferences("NotePreferences", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("savedNotes", serializedData);
                editor.apply();

                if (!note1.isEmpty() && !note2.isEmpty() && !note3.isEmpty()) {
                    Intent intent = new Intent(missActivity.this, gsonActivity.class);
                    startActivity(intent);
                } else {
                    doneText.setText("Due --> notes is Null! write it All");
                }


            }
        });



        }
    }
