package com.example.trackitall;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Timer.class}, version = 1)
public abstract class TimerDatabase extends RoomDatabase {
    private static TimerDatabase instance;
    public abstract  TimerDao timerDao();

    // Singleton pattern


    public static synchronized TimerDatabase getInstance(Context context) {
        if (null == instance) {
            instance = Room.databaseBuilder(context, TimerDatabase.class, "timer_db")
                    .fallbackToDestructiveMigration()
                    .addCallback(initialCallback)
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }

    private static RoomDatabase.Callback initialCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            new PopulateInitialData(instance).execute();
        }
    };

    private static class PopulateInitialData extends AsyncTask<Void, Void, Void> {
        private TimerDao timerDao;

        public PopulateInitialData(TimerDatabase db) {this.timerDao = db.timerDao(); }


        @Override
        protected Void doInBackground(Void... voids) {
            timerDao.insertTimer(new Timer("Nejmain ", R.drawable.blue,0,0));
            timerDao.insertTimer(new Timer("Benbjamin ", R.drawable.green,0,0));
            timerDao.insertTimer(new Timer("Benjamin ", R.drawable.red,0,0));
            timerDao.insertTimer(new Timer(" martin", R.drawable.yellow,0,0));

            return null;
        }
    }


}
