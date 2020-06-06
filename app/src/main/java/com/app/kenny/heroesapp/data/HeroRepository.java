package com.app.kenny.heroesapp.data;

import android.content.Context;

import java.util.List;

import androidx.lifecycle.LiveData;

public class HeroRepository {

    private HeroDao heroDao;

    public HeroRepository(Context context) {
        HeroRoomDatabase db = HeroRoomDatabase.getDatabase(context);
        heroDao = db.heroDao();
    }

    public void insertHero(HeroEntity heroEntity){
        HeroRoomDatabase.appDatabaseWriteExecutor.execute(() -> {
            heroDao.insert(heroEntity);
        });
    }

    public LiveData<List<HeroEntity>> getAllHeroes(){
        return heroDao.getAllProducts();
    }
}
