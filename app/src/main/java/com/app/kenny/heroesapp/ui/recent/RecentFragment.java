package com.app.kenny.heroesapp.ui.recent;

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
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.kenny.heroesapp.R;
import com.app.kenny.heroesapp.adapters.favheroadapter.FavHeroAdapter;
import com.app.kenny.heroesapp.adapters.pager.PagerContainerFragmentDirections;
import com.app.kenny.heroesapp.adapters.recentheroadapter.RecentHeroAdapter;
import com.app.kenny.heroesapp.entities.ResHero;
import com.app.kenny.heroesapp.ui.favorites.FavoritesViewModel;

public class RecentFragment extends Fragment {

    private RecentViewModel recentViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recentViewModel = new ViewModelProvider(this).get(RecentViewModel.class);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recent, container, false);
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
