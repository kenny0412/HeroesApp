package com.app.kenny.heroesapp.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiMethods {

    SuperHeroesClient superHeroesClient;

    public RetrofitApiMethods(){
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SuperHeroesClient.HEROES_API)
                .client(new OkHttpClient.Builder()
                        .connectTimeout(1, TimeUnit.MINUTES)
                        .writeTimeout(1, TimeUnit.MINUTES)
                        .readTimeout(1, TimeUnit.MINUTES)
                        .build())
                .build();
        superHeroesClient = retrofit.create(SuperHeroesClient.class);
    }


    public SuperHeroesClient getSuperHeroesClient() {
        return superHeroesClient;
    }
}
