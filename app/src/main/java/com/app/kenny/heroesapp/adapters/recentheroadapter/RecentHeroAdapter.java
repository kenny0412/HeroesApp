package com.app.kenny.heroesapp.adapters.recentheroadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.kenny.heroesapp.R;
import com.app.kenny.heroesapp.data.HeroEntity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

public class RecentHeroAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<HeroEntity> recentHeroArrayList = new ArrayList<>();



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_all_heroes,parent,false);

        return new RecentHeroHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HeroEntity hero = recentHeroArrayList.get(position);
        RecentHeroHolder heroHolder = (RecentHeroHolder) holder;


        Picasso.get().load(hero.getImgUrl()).into(heroHolder.img_hero);
        heroHolder.tv_hero_name.setText(hero.getHeroName());
        heroHolder.img_fav.setBackgroundResource(R.drawable.ic_star);

    }

    @Override
    public int getItemCount() {
        return recentHeroArrayList.size();
    }

    public void  setRecentHeroList(List<HeroEntity> favHeroArrayList) {
        this.recentHeroArrayList = new ArrayList<>(favHeroArrayList);
        notifyDataSetChanged();
    }

}
