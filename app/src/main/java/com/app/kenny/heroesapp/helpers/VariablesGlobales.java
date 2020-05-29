package com.app.kenny.heroesapp.helpers;

import android.app.Application;
import com.app.kenny.heroesapp.entities.ResHero;
import java.util.List;

public class VariablesGlobales extends Application {


    private static VariablesGlobales instancia;

    @Override
    public void onCreate() {
        super.onCreate();
        instancia = this;
    }

    public static VariablesGlobales getInstancia() {
        return instancia;
    }

    private List<ResHero> showAllHeroes;

    private int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ResHero> getShowAllHeroes() {
        return showAllHeroes;
    }

    public void setShowAllHeroes(List<ResHero> showAllHeroes) {
        this.showAllHeroes = showAllHeroes;
    }
}
