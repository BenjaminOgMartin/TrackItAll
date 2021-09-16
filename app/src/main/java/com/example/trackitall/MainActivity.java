package com.example.trackitall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView timerView; // Initialise the RecyclerView as timerView

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerView = findViewById(R.id.timerView); // Connect timerView to the timerView ID

        // Each entry in the ArrayList represents a timer button
        ArrayList<Timer> timer = new ArrayList<>();
        timer.add(new Timer(1, "Reading", R.drawable.blue, 0, 0));
        timer.add(new Timer(2, "Cooking", R.drawable.green, 0, 0));
        timer.add(new Timer(3, "Gym", R.drawable.red, 0, 0));
        timer.add(new Timer(4, "Boner", R.drawable.yellow, 0, 0));


        // Creates the RecyclerView adapter
        TimerRecViewAdapter adapter = new TimerRecViewAdapter(this);
        adapter.setTimer(timer);

        timerView.setAdapter(adapter); // Connects the adapter to the timerView
        timerView.setLayoutManager(new GridLayoutManager(this, 2)); // Sets a grid layout
    }
}