package com.app.kenny.heroesapp.ui.allheroes;

import android.app.Application;
import android.util.Log;

import com.app.kenny.heroesapp.api.RetrofitApiMethods;
import com.app.kenny.heroesapp.data.HeroEntity;
import com.app.kenny.heroesapp.data.HeroRepository;
import com.app.kenny.heroesapp.entities.ResHero;
import com.app.kenny.heroesapp.helpers.Utils;
import com.app.kenny.heroesapp.helpers.VariablesGlobales;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllHeroesViewModel extends AndroidViewModel {

    private MutableLiveData<List<ResHero>> heroLiveData = new MutableLiveData<>();
    private RetrofitApiMethods provider;
    private HeroRepository repository;

    public AllHeroesViewModel(Application aplication) {
        super(aplication);
        this.provider = new RetrofitApiMethods();
        this.repository = new HeroRepository(aplication.getApplicationContext());
    }

    public void createHero(String heroId, String heroName,String imgUrl){
        repository.insertHero(new HeroEntity(heroId,heroName,imgUrl));
    }

    public void getHeros(int idHero){
        provider.getSuperHeroesClient().getHeroesImage(idHero).enqueue(new Callback<ResHero>() {
            @Override
            public void onResponse(Call<ResHero> call, Response<ResHero> response) {
                if (response.isSuccessful()){
                    List<ResHero> lsthero =  new ArrayList<>();
                    if (VariablesGlobales.getInstancia().getShowAllHeroes() == null){
                        lsthero.add(response.body());
                    }else {
                        lsthero =  VariablesGlobales.getInstancia().getShowAllHeroes();
                        lsthero.add(response.body());

                    }
                    VariablesGlobales.getInstancia().setShowAllHeroes(lsthero);
                    if (lsthero.size() <= 9){
                        getHeros(Utils.getRandomNumber());
                    }else {
                        heroLiveData.postValue(VariablesGlobales.getInstancia().getShowAllHeroes());
                    }
                }else {
                    heroLiveData.postValue(null);
                }

            }

            @Override
            public void onFailure(Call<ResHero> call, Throwable t) {
                heroLiveData.postValue(null);
                Log.e("getHero", Objects.requireNonNull(t.getMessage()));
            }

        });
    }

    public LiveData<List<ResHero>> getHeroLiveData() {
        return heroLiveData;
    }
}