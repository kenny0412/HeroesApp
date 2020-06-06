package com.app.kenny.heroesapp.adapters.favheroadapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.kenny.heroesapp.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FavHeroHolder extends RecyclerView.ViewHolder {

    ImageView img_hero;
    TextView tv_hero_name;
    ImageView img_fav;
    LinearLayout container_heroes;

    public FavHeroHolder(@NonNull View itemView) {
        super(itemView);
        container_heroes = itemView.findViewById(R.id.container_heroes);
        img_hero = itemView.findViewById(R.id.img_hero);
        tv_hero_name = itemView.findViewById(R.id.tv_hero_name);
        img_fav = itemView.findViewById(R.id.img_fav);

    }
}
