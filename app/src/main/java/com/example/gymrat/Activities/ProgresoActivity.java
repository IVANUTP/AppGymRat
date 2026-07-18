package com.example.gymrat.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymrat.Adapters.EstadisticaAdapter;
import com.example.gymrat.Adapters.HistorialAdapter;
import com.example.gymrat.Models.Estadistica;
import com.example.gymrat.Models.Historial;
import com.example.gymrat.R;
import com.example.gymrat.Utils.BottomNavHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ProgresoActivity extends AppCompatActivity {

    private RecyclerView rvEstadisticas;
    private RecyclerView rvHistorial;
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
        rvHistorial = findViewById(R.id.rvHistorial);

        rvHistorial.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Historial> historial = new ArrayList<>();

        historial.add(new Historial(
                "18",
                "JUL",
                "Push",
                "1h 18 min",
                "7250 kg",
                "+8%"
        ));

        historial.add(new Historial(
                "16",
                "JUL",
                "Pierna",
                "1h 42 min",
                "11200 kg",
                "+15%"
        ));

        historial.add(new Historial(
                "14",
                "JUL",
                "Espalda",
                "1h 12 min",
                "6900 kg",
                "+6%"
        ));

        HistorialAdapter historialAdapter = new HistorialAdapter(historial);

        rvHistorial.setAdapter(historialAdapter);

        BottomNavHelper.setupBottomNav(
                this,
                navigation,
                R.id.nav_progreso
        );
    }
}