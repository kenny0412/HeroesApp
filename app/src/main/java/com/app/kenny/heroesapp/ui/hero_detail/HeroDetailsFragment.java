package com.app.kenny.heroesapp.ui.hero_detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;


import com.app.kenny.heroesapp.R;
import com.app.kenny.heroesapp.entities.HeroDetails;
import com.app.kenny.heroesapp.entities.ResHero;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

public class HeroDetailsFragment extends Fragment {

    private HeroDetailsViewModel heroDetailsViewModel;
    private NavController navController;
    private TextView txt_nom_pila,txt_nom_heroe,txt_tipo,txt_ocupacion,porc_inteligencia,porc_fuerza,porc_velocidad,porc_durabilidad,porc_porder,porc_combate;
    private SeekBar seek_inteligencia,seek_fuerza,seek_velocidad,seek_durabilidad,seek_poder,seek_combate;
    private ProgressBar progressBar;
    private CoordinatorLayout coordinatorLayout;
    private Toolbar toolbar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ResHero data = HeroDetailsFragmentArgs.fromBundle(getArguments()).getHeroInfo();
        heroDetailsViewModel = new ViewModelProvider(this).get(HeroDetailsViewModel.class);
        heroDetailsViewModel.getHero(Integer.parseInt(data.getId()));
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hero_details, container, false);
        toolbar = view.findViewById(R.id.toolbar);
        progressBar = view.findViewById(R.id.progressBar);
        coordinatorLayout = view.findViewById(R.id.container_detail);
        coordinatorLayout.setVisibility(View.GONE);
        txt_nom_pila = view.findViewById(R.id.txt_nom_pila);
        txt_nom_heroe = view.findViewById(R.id.txt_nom_heroe);
        txt_tipo = view.findViewById(R.id.txt_tipo);
        txt_ocupacion = view.findViewById(R.id.txt_ocupacion);
        porc_inteligencia = view.findViewById(R.id.porc_inteligencia);
        porc_fuerza = view.findViewById(R.id.porc_fuerza);
        porc_velocidad = view.findViewById(R.id.porc_velocidad);
        porc_durabilidad = view.findViewById(R.id.porc_durabilidad);
        porc_porder = view.findViewById(R.id.porc_poder);
        porc_combate = view.findViewById(R.id.porc_combate);
        seek_inteligencia = view.findViewById(R.id.seek_inteligencia);
        seek_fuerza = view.findViewById(R.id.seek_fuerza);
        seek_velocidad = view.findViewById(R.id.seek_velocidad);
        seek_durabilidad = view.findViewById(R.id.seek_durabilidad);
        seek_poder = view.findViewById(R.id.seek_poder);
        seek_combate = view.findViewById(R.id.seek_combate);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar.setTitle("Detalle Heroe");
        heroDetailsViewModel.getHeroDetailLiveData().observe(getViewLifecycleOwner(), heroDetails -> {
            progressBar.setVisibility(View.GONE);
            coordinatorLayout.setVisibility(View.VISIBLE);
            if (validarHeroe(heroDetails)){
                int inteligencia = Integer.parseInt(heroDetails.getPowerstats().getIntelligence());
                int fuerza = Integer.parseInt(heroDetails.getPowerstats().getStrength());
                int velocidad = Integer.parseInt(heroDetails.getPowerstats().getSpeed());
                int durabilidad = Integer.parseInt(heroDetails.getPowerstats().getDurability());
                int poder = Integer.parseInt(heroDetails.getPowerstats().getPower());
                int combate = Integer.parseInt(heroDetails.getPowerstats().getCombat());
                txt_nom_pila.setText(heroDetails.getBiography().getFull_name());
                txt_nom_heroe.setText(heroDetails.getName());
                txt_ocupacion.setText(heroDetails.getWork().getOccupation());
                txt_tipo.setText(heroDetails.getBiography().getAlignment());
                porc_inteligencia.setText(inteligencia+"%");
                porc_velocidad.setText(heroDetails.getPowerstats().getSpeed()+"%");
                porc_fuerza.setText(heroDetails.getPowerstats().getStrength()+"%");
                porc_durabilidad.setText(heroDetails.getPowerstats().getDurability()+"%");
                porc_porder.setText(heroDetails.getPowerstats().getPower()+"%");
                porc_combate.setText(heroDetails.getPowerstats().getCombat()+"%");
                seek_inteligencia.setProgress(inteligencia);
                seek_fuerza.setProgress(fuerza);
                seek_velocidad.setProgress(velocidad);
                seek_durabilidad.setProgress(durabilidad);
                seek_poder.setProgress(poder);
                seek_combate.setProgress(combate);
                seek_inteligencia.setEnabled(false);
                seek_fuerza.setEnabled(false);
                seek_velocidad.setEnabled(false);
                seek_durabilidad.setEnabled(false);
                seek_poder.setEnabled(false);
                seek_combate.setEnabled(false);
            }
        });
    }

    private boolean validarHeroe(HeroDetails heroDetails) {
        if (heroDetails.getPowerstats().getIntelligence() == null){
            heroDetails.getPowerstats().setIntelligence("0");
        }
        if (heroDetails.getPowerstats().getStrength() == null){
            heroDetails.getPowerstats().setStrength("0");
        }
        if (heroDetails.getPowerstats().getSpeed() == null){
            heroDetails.getPowerstats().setSpeed("0");
        }
        if (heroDetails.getPowerstats().getDurability() == null){
            heroDetails.getPowerstats().setDurability("0");
        }
        if (heroDetails.getPowerstats().getPower() == null){
            heroDetails.getPowerstats().setPower("0");
        }
        if (heroDetails.getPowerstats().getCombat() == null){
            heroDetails.getPowerstats().setCombat("0");
        }
        return true;
    }

}
