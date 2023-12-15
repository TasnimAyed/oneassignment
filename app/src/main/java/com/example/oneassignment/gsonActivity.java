package com.example.oneassignment;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import com.google.gson.Gson;

public class gsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);

        TextView textViewNote1 = findViewById(R.id.textViewNote1);
        TextView textViewNote2 = findViewById(R.id.textViewNote2);
        TextView textViewNote3 = findViewById(R.id.textViewNote3);

        SharedPreferences sharedPreferences = getSharedPreferences("NotePreferences", MODE_PRIVATE);
        String savedData = sharedPreferences.getString("savedNotes", "");

        Gson gson = new Gson();
        Notes savedNoteData = gson.fromJson(savedData, Notes.class);

        // Display saved notes in TextViews
        if (savedNoteData != null) {
            textViewNote1.setText("Note 1: " + savedNoteData.getNote1());
            textViewNote2.setText("Note 2: " + savedNoteData.getNote2());
            textViewNote3.setText("Note 3: " + savedNoteData.getNote3());
        }

    }
}