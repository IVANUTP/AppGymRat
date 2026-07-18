package com.example.gymrat.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.gymrat.Adapters.EjercicioAdapter;
import com.example.gymrat.R;
import com.example.gymrat.Utils.BottomNavHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class EntrenamientoActivity extends AppCompatActivity {

    private RecyclerView rvEjercicios;
    private BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenamiento);

        rvEjercicios = findViewById(R.id.rvEjercicios);
        navigation = findViewById(R.id.bottomNavigation);

        rvEjercicios.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<String> ejercicios = new ArrayList<>();

        ejercicios.add("Press banca");
        ejercicios.add("Press inclinado");
        ejercicios.add("Fondos");
        ejercicios.add("Elevaciones laterales");
        ejercicios.add("Extensión de tríceps");

        EjercicioAdapter adapter = new EjercicioAdapter(ejercicios);

        rvEjercicios.setAdapter(adapter);

        BottomNavHelper.setupBottomNav(
                this,
                navigation,
                R.id.nav_entrenar
        );
    }
}