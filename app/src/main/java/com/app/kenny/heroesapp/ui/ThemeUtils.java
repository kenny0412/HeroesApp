package com.app.kenny.heroesapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.app.kenny.heroesapp.R;

public class ThemeUtils {

    private static int cTheme;



    public final static int CAP = 1;
    public final static int HULK = 2;
    public final static int IRON_MAN = 3;
    public final static int THANOS = 4;


    public static void changeToTheme(Activity activity, int theme) {
        cTheme = theme;
        activity.startActivity(activity.getIntent());
        activity.finish();
        activity.overridePendingTransition(R.anim.fragment_fade_enter,R.anim.fragment_fade_exit);
    }

    public static void onActivityCreateSetTheme(Activity activity){
        SharedPreferences prefs = activity.getSharedPreferences("HEROESAPPTHEME", Context.MODE_PRIVATE);
        int theme = prefs.getInt("THEME",0);
        switch (theme)
        {
            case CAP:
                activity.setTheme(R.style.AppTheme);
                break;
            case HULK:
                activity.setTheme(R.style.hulkTheme);
                break;
            case  IRON_MAN:
                activity.setTheme(R.style.ironManTheme);
                break;
            case THANOS:
                activity.setTheme(R.style.thanosTheme);
                break;
        }
    }
}
