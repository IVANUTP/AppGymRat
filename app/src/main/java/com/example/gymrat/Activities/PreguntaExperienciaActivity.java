package com.example.gymrat.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.gymrat.Helper.EncuestaData;
import com.example.gymrat.R;
import com.google.android.material.button.MaterialButton;

public class PreguntaExperienciaActivity extends BaseActivity {

    private TextView[] opciones;
    private String[] valores = {
            "Nunca he entrenado",
            "Principiante",
            "Intermedio",
            "Avanzado"
    };
    private String seleccionActual = null;
    private MaterialButton btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_experiencia);

        btnSiguiente = findViewById(R.id.btnSiguiente);
        var btnVolver = findViewById(R.id.btnVolver);

        opciones = new TextView[]{
                findViewById(R.id.opcionNunca),
                findViewById(R.id.opcionPrincipiante),
                findViewById(R.id.opcionIntermedio),
                findViewById(R.id.opcionAvanzado)
        };

        for (int i = 0; i < opciones.length; i++) {
            final int index = i;
            opciones[i].setOnClickListener(v -> seleccionar(index));
        }

        btnVolver.setOnClickListener(v -> finish());

        btnSiguiente.setOnClickListener(v -> {
            EncuestaData.getInstancia().setExperiencia(seleccionActual);

            Intent intent = new Intent(PreguntaExperienciaActivity.this, PreguntaMetaActivity.class);
            startActivity(intent);
        });
    }

    private void seleccionar(int index) {
        seleccionActual = valores[index];

        for (int i = 0; i < opciones.length; i++) {
            opciones[i].setBackgroundResource(
                    i == index ? R.drawable.bg_option_selected : R.drawable.bg_option_unselected
            );
        }

        btnSiguiente.setEnabled(true);
    }
}