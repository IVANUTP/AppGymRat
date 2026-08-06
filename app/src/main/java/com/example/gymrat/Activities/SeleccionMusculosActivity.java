package com.example.gymrat.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.gymrat.R;
import com.google.android.material.button.MaterialButton;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SeleccionMusculosActivity extends BaseActivity {

    private final Set<String> seleccionadas = new HashSet<>();
    private Map<String, TextView> chips = new HashMap<>();
    private Map<String, View[]> overlaysPorZona = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_musculos);

        var btnVolver = findViewById(R.id.btnVolver);
        MaterialButton btnSiguiente = findViewById(R.id.btnSiguiente);

        btnVolver.setOnClickListener(v -> finish());

        chips.put("ESPALDA", findViewById(R.id.chipEspalda));
        chips.put("HOMBRO", findViewById(R.id.chipHombro));
        chips.put("BRAZO", findViewById(R.id.chipBrazo));
        chips.put("PECHO", findViewById(R.id.chipPecho));
        chips.put("ABDOMINALES", findViewById(R.id.chipAbdominales));
        chips.put("GLUTEOS", findViewById(R.id.chipGluteos));
        chips.put("PIERNAS", findViewById(R.id.chipPiernas));
        chips.put("TODO", findViewById(R.id.chipTodoCuerpo));

        overlaysPorZona.put("ESPALDA", new View[]{ findViewById(R.id.overlayEspalda) });
        overlaysPorZona.put("HOMBRO", new View[]{ findViewById(R.id.overlayHombroFrente), findViewById(R.id.overlayHombroEspalda) });
        overlaysPorZona.put("BRAZO", new View[]{ findViewById(R.id.overlayBrazoFrente), findViewById(R.id.overlayBrazoEspalda) });
        overlaysPorZona.put("PECHO", new View[]{ findViewById(R.id.overlayPecho) });
        overlaysPorZona.put("ABDOMINALES", new View[]{ findViewById(R.id.overlayAbdominales) });
        overlaysPorZona.put("GLUTEOS", new View[]{ findViewById(R.id.overlayGluteos) });
        overlaysPorZona.put("PIERNAS", new View[]{ findViewById(R.id.overlayPiernasFrente), findViewById(R.id.overlayPiernasEspalda) });


        seleccionadas.add("TODO");
        actualizarTodosLosOverlays();

        for (Map.Entry<String, TextView> entry : chips.entrySet()) {
            String zona = entry.getKey();
            TextView chip = entry.getValue();

            chip.setOnClickListener(v -> toggleZona(zona));
        }

        btnSiguiente.setOnClickListener(v -> {
            Intent intent = new Intent(SeleccionMusculosActivity.this,  PreguntaExperienciaActivity.class);
            startActivity(intent);
        });
    }

    private void toggleZona(String zona) {

        if (zona.equals("TODO")) {
            seleccionadas.clear();
            seleccionadas.add("TODO");
        } else {
            seleccionadas.remove("TODO");

            if (seleccionadas.contains(zona)) {
                seleccionadas.remove(zona);
            } else {
                seleccionadas.add(zona);
            }

            if (seleccionadas.isEmpty()) {
                seleccionadas.add("TODO");
            }
        }

        actualizarChips();
        actualizarTodosLosOverlays();
    }

    private void actualizarChips() {
        for (Map.Entry<String, TextView> entry : chips.entrySet()) {
            boolean activo = seleccionadas.contains(entry.getKey());
            TextView chip = entry.getValue();

            chip.setBackgroundResource(activo ? R.drawable.bg_chip_selected : R.drawable.bg_chip_unselected);
            chip.setTextColor(activo ? 0xFFFFFFFF : 0xFF1A1A1A);
        }
    }

    private void actualizarTodosLosOverlays() {

        boolean todoActivo = seleccionadas.contains("TODO");

        for (Map.Entry<String, View[]> entry : overlaysPorZona.entrySet()) {

            boolean visible = todoActivo || seleccionadas.contains(entry.getKey());

            for (View overlay : entry.getValue()) {
                overlay.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
            }
        }
    }
}