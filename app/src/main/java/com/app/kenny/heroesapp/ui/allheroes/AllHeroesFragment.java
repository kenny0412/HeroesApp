package com.app.kenny.heroesapp.ui.allheroes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.app.kenny.heroesapp.R;
import com.app.kenny.heroesapp.adapters.heroadapter.HeroAdapter;
import com.app.kenny.heroesapp.adapters.pager.PagerContainerFragmentDirections;
import com.app.kenny.heroesapp.helpers.Utils;
import com.app.kenny.heroesapp.helpers.VariablesGlobales;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AllHeroesFragment extends Fragment implements LifecycleOwner {

    private AllHeroesViewModel allHeroesViewModel;
    private RecyclerView rcv_heros;
    private ProgressBar allHeroesProgress;
    private HeroAdapter heroAdapter = new HeroAdapter();
    private SwipeRefreshLayout refreshLayout;

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
        refreshLayout = view.findViewById(R.id.fav_refresh);
        refreshLayout.setOnRefreshListener(() -> {
            VariablesGlobales.getInstancia().setShowAllHeroes(null);
            allHeroesViewModel.getHeros(Utils.getRandomNumber());
            refreshLayout.setEnabled(false);
        });
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
            refreshLayout.setEnabled(true);
        });

        heroAdapter.getOnItemClick().observe(getViewLifecycleOwner(), hero -> {
            NavDirections navDirections = PagerContainerFragmentDirections.actionPagerContainerFragmentToHeroDetails(hero);
            NavHostFragment.findNavController(this).navigate(navDirections);
        });

        heroAdapter.getOnAddHeroFavClick().observe(getViewLifecycleOwner(),resHero -> {
            allHeroesViewModel.createHero(resHero.getId(),resHero.getHeroName(),resHero.getImg());
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
