package com.app.kenny.heroesapp.entities;

import android.media.Image;

public class Hero {

    private Image imgHero;
    private String name;
    private Image img_fav;

    public Image getImgHero() {
        return imgHero;
    }

    public void setImgHero(Image imgHero) {
        this.imgHero = imgHero;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImg_fav() {
        return img_fav;
    }

    public void setImg_fav(Image img_fav) {
        this.img_fav = img_fav;
    }
}
