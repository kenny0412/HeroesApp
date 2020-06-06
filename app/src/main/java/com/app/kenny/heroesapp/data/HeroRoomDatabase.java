package com.app.kenny.heroesapp.data;

import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {HeroEntity.class},version = 1,exportSchema = false)
public abstract class HeroRoomDatabase extends RoomDatabase {

    public abstract HeroDao heroDao();

    private static volatile HeroRoomDatabase INSTANCE;
    static final ExecutorService appDatabaseWriteExecutor = Executors.newFixedThreadPool(4);

    static HeroRoomDatabase getDatabase(Context context){
        if (INSTANCE == null){
            synchronized (HeroRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context,HeroRoomDatabase.class,"heroes_database").build();
                }
            }
        }
        return INSTANCE;
    }



}
