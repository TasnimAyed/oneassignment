package com.example.oneassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class noorActivity extends AppCompatActivity {
    private EditText editText1, editText2, editText3, doneText;
    private Button doneButton,load_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noor);
        editText1 = findViewById(R.id.Note1);
        editText2 = findViewById(R.id.Note2);
        editText3 = findViewById(R.id.Note3);
        doneText = findViewById(R.id.Result);
        doneButton = findViewById(R.id.doneBtn);

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

    }
}