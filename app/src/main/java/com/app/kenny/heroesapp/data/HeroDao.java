package com.app.kenny.heroesapp.data;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface HeroDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(HeroEntity heroEntity);

    @Query("DELETE FROM heroes WHERE hero_id = :hero_id")
    void delete(int hero_id);

    @Query("SELECT * FROM heroes")
    LiveData<List<HeroEntity>> getAllProducts();

}
