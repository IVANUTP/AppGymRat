package com.example.gymrat.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymrat.Adapters.EstadisticaAdapter;
import com.example.gymrat.Models.Estadistica;
import com.example.gymrat.R;
import com.example.gymrat.Utils.BottomNavHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ProgresoActivity extends AppCompatActivity {

    private RecyclerView rvEstadisticas;
    private BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        rvEstadisticas = findViewById(R.id.rvEstadisticas);
        navigation = findViewById(R.id.bottomNavigation);

        rvEstadisticas.setLayoutManager(new GridLayoutManager(this, 2));

        ArrayList<Estadistica> lista = new ArrayList<>();

        lista.add(new Estadistica(
                R.drawable.ic_fitness,
                "125",
                "Entrenamientos"
        ));

        lista.add(new Estadistica(
                R.drawable.ic_fire,
                "18",
                "Racha"
        ));

        lista.add(new Estadistica(
                R.drawable.ic_chart,
                "152 T",
                "Volumen"
        ));

        lista.add(new Estadistica(
                R.drawable.ic_time,
                "96 h",
                "Tiempo"
        ));

        EstadisticaAdapter adapter = new EstadisticaAdapter(lista);

        rvEstadisticas.setAdapter(adapter);

        BottomNavHelper.setupBottomNav(
                this,
                navigation,
                R.id.nav_progreso
        );
    }
}