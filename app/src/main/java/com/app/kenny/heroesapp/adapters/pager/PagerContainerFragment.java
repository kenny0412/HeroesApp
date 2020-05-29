package com.app.kenny.heroesapp.adapters.pager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.kenny.heroesapp.R;
import com.app.kenny.heroesapp.ui.allheroes.AllHeroesFragment;
import com.app.kenny.heroesapp.ui.favorites.FavoritesFragment;
import com.app.kenny.heroesapp.ui.recent.RecentFragment;
import com.app.kenny.heroesapp.ui.theme.ThemeFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

public class PagerContainerFragment extends Fragment {

   private ViewPager2 viewPager;
   private PagerContainerAdapter adapter;
   private TabLayout tabLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new PagerContainerAdapter(this,getFragmentList());

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.app_bar_main, container, false);
        tabLayout = view.findViewById(R.id.tableLayout);
        viewPager = view.findViewById(R.id.pager);
        viewPager.setAdapter(adapter);
        List<String> names = getFragmentName();
        new TabLayoutMediator(tabLayout,viewPager,(tab,position)->tab.setText(names.get(position))).attach();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public List<String> getFragmentName(){
        List<String> names = new ArrayList<>();
        names.add("Favoritos");
        names.add("Heroes");
        names.add("Recientes");
        names.add("Temas");
        return names;
    }
    public List<Fragment> getFragmentList(){
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new FavoritesFragment());
        fragments.add(new AllHeroesFragment());
        fragments.add(new RecentFragment());
        fragments.add(new ThemeFragment());
        return fragments;
    }

}
