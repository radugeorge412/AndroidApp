package com.example.radugym;
import android.app.Application;

import androidx.room.Room;

public class MyApplication extends Application {

    private static MyApplication mInstance;
    private static AppDatabase mAppDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        mAppDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();
    }

    public static MyApplication getInstance(){
        return mInstance;
    }

    public static AppDatabase getAppDatabase(){
        return mAppDatabase;
    }
}