package com.app.kenny.heroesapp.ui.hero_detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import com.app.kenny.heroesapp.R;
import com.app.kenny.heroesapp.adapters.HeroAdapter;
import com.app.kenny.heroesapp.entities.ResHero;
import com.app.kenny.heroesapp.ui.allheroes.AllHeroesFragmentDirections;

import java.util.List;
import java.util.Objects;
import java.util.Observable;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HeroDetailsFragment extends Fragment {

    private HeroDetailsViewModel heroDetailsViewModel;
    private NavController navController;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        heroDetailsViewModel = new ViewModelProvider(this).get(HeroDetailsViewModel.class);
//        heroDetailsViewModel.getHero();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hero_details, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        ResHero data = HeroDetailsFragmentArgs.fromBundle(getArguments()).getHeroInfo();
        heroDetailsViewModel.getHeroDetailLiveData().observe(getViewLifecycleOwner(), resHero -> {

        });
    }

}
