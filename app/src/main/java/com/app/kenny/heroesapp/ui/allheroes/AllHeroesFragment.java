package com.app.kenny.heroesapp.ui.allheroes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.NavHost;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.kenny.heroesapp.R;
import com.app.kenny.heroesapp.adapters.HeroAdapter;
import com.app.kenny.heroesapp.adapters.pager.PagerContainerFragmentDirections;
import com.app.kenny.heroesapp.entities.ResHero;
import com.app.kenny.heroesapp.helpers.Utils;

import java.util.List;
import java.util.Objects;

public class AllHeroesFragment extends Fragment implements LifecycleOwner {

    private AllHeroesViewModel allHeroesViewModel;
    private RecyclerView rcv_heros;
    private ProgressBar allHeroesProgress;
    private HeroAdapter heroAdapter = new HeroAdapter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        allHeroesViewModel = new ViewModelProvider(this).get(AllHeroesViewModel.class);
        allHeroesViewModel.getHeros(Utils.getRandomNumber());
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_heroes, container, false);
        rcv_heros = view.findViewById(R.id.rcv_heroes);
        rcv_heros.setVisibility(View.GONE);
        allHeroesProgress = view.findViewById(R.id.all_hero_progress);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        allHeroesViewModel.getHeroLiveData().observe(getViewLifecycleOwner(), heroList -> {
            rcv_heros.setVisibility(View.VISIBLE);
            allHeroesProgress.setVisibility(View.GONE);
            heroAdapter.setHeroList(heroList);
            LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(getActivity(),R.anim.layout_animation_fall_down);
            rcv_heros.setLayoutAnimation(layoutAnimationController);
            rcv_heros.setLayoutManager(new LinearLayoutManager(getActivity()));
            rcv_heros.setAdapter(heroAdapter);
        });

        heroAdapter.getOnItemClick().observe(getViewLifecycleOwner(), hero -> {
            NavDirections navDirections = PagerContainerFragmentDirections.actionPagerContainerFragmentToHeroDetails(hero);
            NavHostFragment.findNavController(this).navigate(navDirections);
        });

    }
    // continuar con la animacion a la hora de que se cambie algun item
    public void runAnimationRcv(RecyclerView rcv_heros){
        LayoutAnimationController anim = AnimationUtils.loadLayoutAnimation(getActivity(),R.anim.layout_animation_fall_down);
        rcv_heros.setLayoutAnimation(anim);
        rcv_heros.getAdapter().notifyDataSetChanged();
        rcv_heros.scheduleLayoutAnimation();
    }
}
