package com.example.trackitall;

import android.widget.EditText;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity (tableName = "timers")


public class Timer {
    @PrimaryKey (autoGenerate = true)
    private int id;
    private String label;
    private int color;
    private int totalTime;
    private int timer;

    // Class Constructor
    @Ignore
    public Timer(int id, String label, int color, int totalTime, int timer) {
        this.id = id;
        this.label = label;
        this.color = color;
        this.totalTime = totalTime;
        this.timer = timer;
    }

    // Database constructor
    public Timer(String label, int color, int totalTime, int timer) {
        this.label = label;
        this.color = color;
        this.totalTime = totalTime;
        this.timer = timer;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    @Override
    public String toString() {
        return "Timer{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", color='" + color + '\'' +
                ", totalTime=" + totalTime +
                ", timer=" + timer +
                '}';
    }

}
