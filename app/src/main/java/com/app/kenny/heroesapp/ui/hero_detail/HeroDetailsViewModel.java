package com.app.kenny.heroesapp.ui.hero_detail;

import com.app.kenny.heroesapp.api.RetrofitApiMethods;
import com.app.kenny.heroesapp.entities.ResHero;
import com.app.kenny.heroesapp.helpers.VariablesGlobales;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroDetailsViewModel extends ViewModel {

    private MutableLiveData<ResHero> heroDetailLiveData;
    private RetrofitApiMethods provider;

    public HeroDetailsViewModel() {
        this.provider = new RetrofitApiMethods();
    }

    public void getHero(int heroId){
        provider.getSuperHeroesClient().getHeroe(heroId).enqueue(new Callback<ResHero>() {
            @Override
            public void onResponse(Call<ResHero> call, Response<ResHero> response) {
                if (response.isSuccessful()){
                    heroDetailLiveData.postValue(response.body());
                }else {
                    heroDetailLiveData.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<ResHero> call, Throwable t) {
                heroDetailLiveData.postValue(null);
            }
        });
    }

    public LiveData<ResHero> getHeroDetailLiveData() {
        return heroDetailLiveData;
    }
}