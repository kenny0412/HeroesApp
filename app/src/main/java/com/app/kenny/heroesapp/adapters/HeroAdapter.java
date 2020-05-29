package com.app.kenny.heroesapp.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.kenny.heroesapp.R;
import com.app.kenny.heroesapp.entities.ResHero;
import com.app.kenny.heroesapp.ui.allheroes.AllHeroesFragment;
import com.app.kenny.heroesapp.ui.allheroes.AllHeroesFragmentDirections;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

public class HeroAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private AllHeroesFragment fragment;
    private List<ResHero> heroArrayList;

    public HeroAdapter(AllHeroesFragment fragment, List<ResHero> heroArrayList) {
        this.fragment = fragment;
        this.heroArrayList = heroArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(fragment.getContext()).inflate(R.layout.adapter_all_heroes,parent,false);

        return new HeroHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ResHero hero = heroArrayList.get(position);
        HeroHolder heroHolder = (HeroHolder) holder;


        Picasso.get().load(hero.getImg()).into(heroHolder.img_hero);
        heroHolder.tv_hero_name.setText(hero.getHeroName());
        heroHolder.img_fav.setBackgroundResource(R.drawable.ic_stroke_star);
        heroHolder.img_fav.setOnClickListener(view -> {
            heroHolder.img_fav.setBackgroundResource(R.drawable.ic_star);
        });
        heroHolder.container_heroes.setOnClickListener(view -> {
            NavDirections action = AllHeroesFragmentDirections.actionNavHeroesToHeroDetails(hero);
            NavHostFragment.findNavController(fragment).navigate(action);
        });
    }

    @Override
    public int getItemCount() {
        return heroArrayList.size();
    }

}
