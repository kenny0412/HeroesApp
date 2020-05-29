package com.app.kenny.heroesapp.helpers;

public class Utils {

    public static int getRandomNumber(){
        int min = 1;
        int max = 731;
        return  (int)(Math.random() * (max - min + 1) + min);
    }
}
