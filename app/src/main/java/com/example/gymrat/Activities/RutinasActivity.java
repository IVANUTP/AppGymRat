package com.example.gymrat.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymrat.Adapters.RutinaAdapter;
import com.example.gymrat.R;
import com.example.gymrat.Utils.BottomNavHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RutinasActivity extends AppCompatActivity {

    private RecyclerView rvRutinas;
    private FloatingActionButton fabAgregar;
    private BottomNavigationView navigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutina);

        rvRutinas = findViewById(R.id.rvRutinas);
        fabAgregar = findViewById(R.id.fabAgregarRutina);
        navigation = findViewById(R.id.bottomNavigation);
        // Configurar RecyclerView
        rvRutinas.setLayoutManager(new LinearLayoutManager(this));

        // Datos estáticos
        ArrayList<String> rutinas = new ArrayList<>();
        rutinas.add("Push");
        rutinas.add("Pull");
        rutinas.add("Legs");

        // Crear adapter
        RutinaAdapter adapter = new RutinaAdapter(rutinas);

        // Mostrar rutinas
        rvRutinas.setAdapter(adapter);

        fabAgregar.setOnClickListener(v -> {
            // Abrir CrearRutinaActivity
        });


        BottomNavHelper.setupBottomNav(
                this,
                navigation,
                R.id.nav_rutinas
        );
    }
}