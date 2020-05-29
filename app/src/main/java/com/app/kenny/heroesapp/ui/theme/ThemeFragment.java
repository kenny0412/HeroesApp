package com.app.kenny.heroesapp.ui.theme;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.kenny.heroesapp.R;
import com.app.kenny.heroesapp.ui.ThemeUtils;
import com.google.android.material.checkbox.MaterialCheckBox;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

public class ThemeFragment extends Fragment {

    private ThemeViewModel themeViewModel;
    private MaterialCheckBox ch_cap,ch_iron_man,ch_hulk,ch_thanos;
    private Context contextWrapper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        themeViewModel = new ViewModelProvider(this).get(ThemeViewModel.class);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SharedPreferences prefs = getActivity().getSharedPreferences("HEROESAPPTHEME", Context.MODE_PRIVATE);
        int theme = prefs.getInt("THEME",0);
        View root = inflater.inflate(R.layout.fragment_theme, container, false);
        ch_cap = root.findViewById(R.id.ch_cap);
        ch_hulk = root.findViewById(R.id.ch_hulk);
        ch_iron_man = root.findViewById(R.id.ch_iron_man);
        ch_thanos = root.findViewById(R.id.ch_thanos);
        SharedPreferences.Editor editor = requireActivity().getSharedPreferences("HEROESAPPTHEME", Context.MODE_PRIVATE).edit();

        switch (theme){
            case 1:
                ch_cap.setChecked(true);
                break;
            case 2:
                ch_hulk.setChecked(true);
                break;
            case 3:
                ch_iron_man.setChecked(true);
                break;
            case 4:
                ch_thanos.setChecked(true);
                break;
        }


        ch_cap.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked && ThemeUtils.CAP != theme){
                editor.putInt("THEME", ThemeUtils.CAP);
                editor.apply();
                ThemeUtils.changeToTheme(requireActivity(), ThemeUtils.CAP);
                ch_hulk.setChecked(false);
                ch_iron_man.setChecked(false);
                ch_thanos.setChecked(false);
            }
        });

        ch_hulk.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked && ThemeUtils.HULK != theme){
                editor.putInt("THEME", ThemeUtils.HULK);
                editor.apply();
                contextWrapper = new ContextThemeWrapper(getActivity(), R.style.hulkTheme);
                ThemeUtils.changeToTheme(requireActivity(), ThemeUtils.HULK);
                ch_cap.setChecked(false);
                ch_iron_man.setChecked(false);
                ch_thanos.setChecked(false);
            }
        });

        ch_iron_man.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked && ThemeUtils.IRON_MAN != theme){
                editor.putInt("THEME", ThemeUtils.IRON_MAN);
                editor.apply();
                ThemeUtils.changeToTheme(requireActivity(), ThemeUtils.IRON_MAN);
                ch_hulk.setChecked(false);
                ch_cap.setChecked(false);
                ch_thanos.setChecked(false);
            }
        });

        ch_thanos.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked && ThemeUtils.THANOS != theme){
                editor.putInt("THEME", ThemeUtils.THANOS);
                editor.apply();
                ThemeUtils.changeToTheme(requireActivity(), ThemeUtils.THANOS);
                ch_hulk.setChecked(false);
                ch_iron_man.setChecked(false);
                ch_cap.setChecked(false);
            }
        });
        return root;
    }
}
