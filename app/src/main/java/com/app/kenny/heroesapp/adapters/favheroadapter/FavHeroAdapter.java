package com.app.kenny.heroesapp.adapters.favheroadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.kenny.heroesapp.R;
import com.app.kenny.heroesapp.data.HeroEntity;
import com.app.kenny.heroesapp.entities.ResHero;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

public class FavHeroAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<HeroEntity> favHeroArrayList = new ArrayList<>();
    private MutableLiveData<HeroEntity> onItemClick = new MutableLiveData();
    private MutableLiveData<HeroEntity> onDeleteHeroFavClick = new MutableLiveData();



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_all_heroes,parent,false);

        return new FavHeroHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HeroEntity hero = favHeroArrayList.get(position);
        FavHeroHolder heroHolder = (FavHeroHolder) holder;


        Picasso.get().load(hero.getImgUrl()).into(heroHolder.img_hero);
        heroHolder.tv_hero_name.setText(hero.getHeroName());
        heroHolder.img_fav.setBackgroundResource(R.drawable.ic_stroke_star);
        heroHolder.img_fav.setOnClickListener(view -> {
            heroHolder.img_fav.setBackgroundResource(R.drawable.ic_star);
        });
        heroHolder.container_heroes.setOnClickListener(view -> {
            onItemClick.postValue(hero);
        });

        heroHolder.img_fav.setOnClickListener(view -> {
            onDeleteHeroFavClick.postValue(hero);
        });
    }

    public LiveData<HeroEntity> getOnItemClick() {
        return onItemClick;
    }

    public LiveData<HeroEntity> getonDeleteHeroFavClick() {
        return onDeleteHeroFavClick;
    }

    @Override
    public int getItemCount() {
        return favHeroArrayList.size();
    }

    public void  setFavHeroList(List<HeroEntity> favHeroArrayList) {
        this.favHeroArrayList = new ArrayList<>(favHeroArrayList);
        notifyDataSetChanged();
    }

}
