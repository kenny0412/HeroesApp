package com.app.kenny.heroesapp.ui.allheroes;

import android.util.Log;

import com.app.kenny.heroesapp.api.RetrofitApiMethods;
import com.app.kenny.heroesapp.api.SuperHeroesClient;
import com.app.kenny.heroesapp.entities.ResHero;
import com.app.kenny.heroesapp.helpers.Utils;
import com.app.kenny.heroesapp.helpers.VariablesGlobales;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllHeroesViewModel extends ViewModel {

    private MutableLiveData<List<ResHero>> heroLiveData = new MutableLiveData<>();
    private RetrofitApiMethods provider;

    public AllHeroesViewModel() {
        this.provider = new RetrofitApiMethods();
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