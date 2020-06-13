package com.app.kenny.heroesapp.ui.favorites;

import android.app.Application;

import com.app.kenny.heroesapp.data.HeroEntity;
import com.app.kenny.heroesapp.data.HeroRepository;
import com.app.kenny.heroesapp.entities.ResHero;
import com.app.kenny.heroesapp.helpers.SingleLiveEvent;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class FavoritesViewModel extends AndroidViewModel {

    private HeroRepository repository;
    private SingleLiveEvent<ResHero> onDeleteHeroFavClick = new SingleLiveEvent<>();

    public FavoritesViewModel(@NonNull Application application) {
        super(application);
        repository = new HeroRepository(application.getApplicationContext());
    }

    public void deleteHero(int heroId){
        repository.deleteHero(heroId);
    }

    public LiveData<ResHero> getOnDeleteHeroFavClick() {
        return onDeleteHeroFavClick;
    }

    public LiveData<List<HeroEntity>> getAllHeroes() {
        return repository.getAllHeroes();
    }
}