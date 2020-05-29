package com.app.kenny.heroesapp.ui.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.kenny.heroesapp.R;
import com.app.kenny.heroesapp.helpers.Utils;
import com.app.kenny.heroesapp.models.GetHeroe;
import com.app.kenny.heroesapp.ui.ThemeUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

public class LoginFragment extends Fragment {

    private LoginViewModel loginViewModel;
    private Button btn_login;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_login, container, false);
        SharedPreferences prefs = getActivity().getSharedPreferences("HEROESAPPTHEME", Context.MODE_PRIVATE);
        int theme = prefs.getInt("THEME",0);
        if (theme != 0){
            ThemeUtils.onActivityCreateSetTheme(getActivity());
        }else {
            SharedPreferences.Editor editor = getActivity().getSharedPreferences("HEROESAPPTHEME", Context.MODE_PRIVATE).edit();
            editor.putInt("THEME", ThemeUtils.CAP);
            editor.apply();
        }
        btn_login = view.findViewById(R.id.btn_login);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_login.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_pagerContainerFragment);
        });
    }

}
