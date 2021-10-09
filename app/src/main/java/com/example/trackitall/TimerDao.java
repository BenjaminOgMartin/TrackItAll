package com.example.trackitall;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface TimerDao {
    @Insert
    void insertTimer(Timer timer);

    @Update
    void updateTimer(Timer timer);

    @Delete
    void deleteTimer(Timer timer);

    @Query("SELECT * FROM timers")
    List<Timer> getTimers();

    @Query("SELECT * FROM timers")
    LiveData<List<Timer>> getLiveTimers();

//    @Query("SELECT label FROM timers")
//    LiveData<List<Timer>> getLabel();




}
