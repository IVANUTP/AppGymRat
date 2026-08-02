package com.example.gymrat.Activities;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.gymrat.R;
import com.google.android.material.button.MaterialButton;

public class WelcomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        MaterialButton btnEmpezar = findViewById(R.id.btnEmpezar);
        MaterialButton btnYaTengoCuenta = findViewById(R.id.btnYaTengoCuenta);

        // Ir a registro
        btnEmpezar.setOnClickListener(v -> {
            Intent intent = new Intent(WelcomeActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        // Ir a login
        btnYaTengoCuenta.setOnClickListener(v -> {
            Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}