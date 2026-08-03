package com.example.gymrat.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.gymrat.Helper.EncuestaData;
import com.example.gymrat.R;
import com.google.android.material.button.MaterialButton;

public class PreguntaMetaActivity extends BaseActivity {

    private TextView[] opciones;
    private String[] valores = {
            "Volverme más consistente",
            "Bajar de peso y estar en forma",
            "Solo obtener mis rangos",
            "Hacerme más fuerte",
            "Construir masa muscular"
    };
    private String seleccionActual = null;
    private MaterialButton btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_meta);

        btnSiguiente = findViewById(R.id.btnSiguiente);
        var btnVolver = findViewById(R.id.btnVolver);

        opciones = new TextView[]{
                findViewById(R.id.opcionConsistencia),
                findViewById(R.id.opcionBajarPeso),
                findViewById(R.id.opcionRangos),
                findViewById(R.id.opcionFuerza),
                findViewById(R.id.opcionMasaMuscular)
        };

        for (int i = 0; i < opciones.length; i++) {
            final int index = i;
            opciones[i].setOnClickListener(v -> seleccionar(index));
        }

        btnVolver.setOnClickListener(v -> finish());

        btnSiguiente.setOnClickListener(v -> {
            EncuestaData.getInstancia().setMeta(seleccionActual);


            Intent intent = new Intent(PreguntaMetaActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
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