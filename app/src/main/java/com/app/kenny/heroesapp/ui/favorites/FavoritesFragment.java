package com.app.kenny.heroesapp.ui.favorites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.kenny.heroesapp.R;
import com.app.kenny.heroesapp.adapters.favheroadapter.FavHeroAdapter;

public class FavoritesFragment extends Fragment {

    private FavoritesViewModel favoritesViewModel;
    private RecyclerView rcv_heroes_fav;
    private FavHeroAdapter favHeroAdapter = new FavHeroAdapter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        favoritesViewModel = new ViewModelProvider(this).get(FavoritesViewModel.class);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fav, container, false);
        rcv_heroes_fav = view.findViewById(R.id.rcv_heroes_fav);
        rcv_heroes_fav.setVisibility(View.GONE);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        favoritesViewModel.getAllHeroes().observe(getViewLifecycleOwner(),heroEntities -> {
            rcv_heroes_fav.setVisibility(View.VISIBLE);
            favHeroAdapter.setFavHeroList(heroEntities);
            LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(getActivity(),R.anim.layout_animation_fall_down);
            rcv_heroes_fav.setLayoutAnimation(layoutAnimationController);
            rcv_heroes_fav.setLayoutManager(new LinearLayoutManager(getActivity()));
            rcv_heroes_fav.setAdapter(favHeroAdapter);
        });
    }
}
