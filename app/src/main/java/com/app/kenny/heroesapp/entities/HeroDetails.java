package com.app.kenny.heroesapp.entities;

import com.google.gson.annotations.SerializedName;

public class HeroDetails {
    private String response;
    private String id;
    private String name;
    @SerializedName("powerstats")
    private Powerstats estadisticasPoder;
    @SerializedName("biography")
    private Biography biografia;
    @SerializedName("work")
    private Work ocupacion;


    // Getter Methods

    public String getResponse() {
        return response;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Powerstats getPowerstats() {
        return estadisticasPoder;
    }

    public Biography getBiography() {
        return biografia;
    }

    public Work getWork() {
        return ocupacion;
    }

    // Setter Methods

    public void setResponse(String response) {
        this.response = response;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPowerstats(Powerstats estadisticasPoder) {
        this.estadisticasPoder = estadisticasPoder;
    }

    public void setBiography(Biography biografia) {
        this.biografia = biografia;
    }

    public void setWorkObject(Work ocupacion) {
        this.ocupacion = ocupacion;
    }
}
