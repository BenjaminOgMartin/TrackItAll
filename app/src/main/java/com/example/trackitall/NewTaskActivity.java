package com.example.trackitall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class NewTaskActivity extends AppCompatActivity {

    private EditText editLabel;
    private Spinner colorPicker;
    private Button btnSave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        editLabel = findViewById(R.id.editLabel);
        colorPicker = findViewById(R.id.colorPicker);
        btnSave = findViewById(R.id.btnSave);



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(NewTaskActivity.this, MainActivity.class);
            startActivity(intent);
                    
            
            //TODO Change boolean taskCreated = true

            }
        });

    }
}