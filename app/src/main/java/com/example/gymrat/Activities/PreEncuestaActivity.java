package com.example.gymrat.Activities;

import android.content.Intent;
import android.os.Bundle;

import com.example.gymrat.R;
import com.google.android.material.button.MaterialButton;

public class PreEncuestaActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_encuesta);

        MaterialButton btnSuenaBien = findViewById(R.id.btnSuenaBien);
        var btnVolver = findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(v -> finish());

        btnSuenaBien.setOnClickListener(v -> {
            // TODO: cambiar por la Activity real de tu cuestionario
            Intent intent = new Intent(PreEncuestaActivity.this, PreguntaNombreActivity.class);
            startActivity(intent);
        });
    }
}