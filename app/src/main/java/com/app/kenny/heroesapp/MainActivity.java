package com.app.kenny.heroesapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.app.kenny.heroesapp.ui.ThemeUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences prefs = this.getSharedPreferences("HEROESAPPTHEME", MODE_PRIVATE);
        int theme = prefs.getInt("THEME",0);
        if (theme != 0){
            ThemeUtils.onActivityCreateSetTheme(this);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
