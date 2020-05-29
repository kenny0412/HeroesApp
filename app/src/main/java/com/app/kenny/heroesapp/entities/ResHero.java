package com.app.kenny.heroesapp.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ResHero implements Parcelable {

    @SerializedName("response")
    private String status;
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String heroName;
    @SerializedName("url")
    private String img;
    @SerializedName("fav")
    private boolean fav;

    protected ResHero(Parcel in) {
        status = in.readString();
        id = in.readString();
        heroName = in.readString();
        img = in.readString();
        fav = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(id);
        dest.writeString(heroName);
        dest.writeString(img);
        dest.writeByte((byte) (fav ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ResHero> CREATOR = new Creator<ResHero>() {
        @Override
        public ResHero createFromParcel(Parcel in) {
            return new ResHero(in);
        }

        @Override
        public ResHero[] newArray(int size) {
            return new ResHero[size];
        }
    };

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }
}
