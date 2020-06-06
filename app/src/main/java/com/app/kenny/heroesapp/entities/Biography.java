package com.app.kenny.heroesapp.entities;

import com.google.gson.annotations.SerializedName;

public class Biography {
    @SerializedName("full-name")
    private String full_name;
    @SerializedName("alter-egos")
    private String alter_egos;
    private String publisher;
    private String alignment;


    // Getter Methods

    public String getFull_name() {
        return full_name;
    }

    public String getAlter_egos() {
        return alter_egos;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAlignment() {
        return alignment;
    }

    // Setter Methods

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setAlter_egos(String alter_egos) {
        this.alter_egos = alter_egos;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }
}
