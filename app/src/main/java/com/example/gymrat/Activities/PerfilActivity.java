package com.example.gymrat.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gymrat.R;
import com.example.gymrat.Utils.BottomNavHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PerfilActivity extends AppCompatActivity {

    private BottomNavigationView navigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        navigation = findViewById(R.id.bottomNavigation);

        BottomNavHelper.setupBottomNav(
                this,
                navigation,
                R.id.nav_perfil
        );


    }

}