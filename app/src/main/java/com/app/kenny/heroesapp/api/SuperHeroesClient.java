package com.app.kenny.heroesapp.api;

import com.app.kenny.heroesapp.entities.HeroDetails;
import com.app.kenny.heroesapp.entities.ResHero;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SuperHeroesClient {

   String HEROES_API= "https://superheroapi.com/api/3333227576705030/";

    @GET("{idhero}/image")
    Call<ResHero> getHeroesImage(@Path("idhero") int idHero);

    @GET("{idhero}")
    Call<HeroDetails> getHeroe(@Path("idhero") int idHero);
}
