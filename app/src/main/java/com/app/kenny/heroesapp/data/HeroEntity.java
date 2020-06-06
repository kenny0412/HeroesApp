package com.app.kenny.heroesapp.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "heroes")
public class HeroEntity {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "hero_id")
    private String heroId;
    @ColumnInfo(name = "hero_name")
    private String heroName;
    @ColumnInfo(name = "img_url")
    private String imgUrl;

    public HeroEntity(@NonNull String heroId, String heroName, String imgUrl) {
        this.heroId = heroId;
        this.heroName = heroName;
        this.imgUrl = imgUrl;
    }

    public String getHeroId() {
        return heroId;
    }

    public void setHeroId(String heroId) {
        this.heroId = heroId;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
