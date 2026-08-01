package com.example.gymrat.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gymrat.R;
import com.example.gymrat.Utils.BottomNavHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;

public class PerfilActivity extends AppCompatActivity {

    private BottomNavigationView navigation;
    private MaterialButton btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        navigation = findViewById(R.id.bottomNavigation);
        btnLogout = findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(v -> {

            Intent intent = new Intent(
                    PerfilActivity.this,
                    LoginActivity.class
            );

            startActivity(intent);
            finish();

        });

        BottomNavHelper.setupBottomNav(
                this,
                navigation,
                R.id.nav_perfil
        );
    }
}