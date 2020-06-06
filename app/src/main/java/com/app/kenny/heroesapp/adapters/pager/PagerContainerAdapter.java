package com.app.kenny.heroesapp.adapters.pager;

import com.app.kenny.heroesapp.ui.allheroes.AllHeroesFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerContainerAdapter extends FragmentStateAdapter {

    private List<Fragment> fragmentList = new ArrayList<>();

    public PagerContainerAdapter(@NonNull Fragment fragment,List<Fragment> fragmentList) {
        super(fragment);
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }
}