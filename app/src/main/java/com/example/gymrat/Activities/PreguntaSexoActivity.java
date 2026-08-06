package com.example.gymrat.Activities;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.gymrat.Helper.EncuestaData;
import com.example.gymrat.R;
import com.google.android.material.button.MaterialButton;

public class PreguntaSexoActivity extends BaseActivity {

    private LinearLayout opcionHombre, opcionMujer;
    private ImageView iconoHombre, iconoMujer;
    private MaterialButton btnSiguiente;
    private String seleccionActual = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_sexo);

        opcionHombre = findViewById(R.id.opcionHombre);
        opcionMujer = findViewById(R.id.opcionMujer);
        iconoHombre = findViewById(R.id.iconoHombre);
        iconoMujer = findViewById(R.id.iconoMujer);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        var btnVolver = findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(v -> finish());

        opcionHombre.setOnClickListener(v -> seleccionar("HOMBRE"));
        opcionMujer.setOnClickListener(v -> seleccionar("MUJER"));

        btnSiguiente.setOnClickListener(v -> {
            EncuestaData.getInstancia().setSexo(seleccionActual);

            Intent intent = new Intent(PreguntaSexoActivity.this,  SeleccionMusculosActivity.class);
            startActivity(intent);
        });
    }

    private void seleccionar(String sexo) {
        seleccionActual = sexo;

        boolean esHombre = sexo.equals("HOMBRE");

        opcionHombre.setBackgroundResource(esHombre ? R.drawable.bg_option_selected : R.drawable.bg_option_unselected);
        opcionMujer.setBackgroundResource(!esHombre ? R.drawable.bg_option_selected : R.drawable.bg_option_unselected);

        int colorHombre = esHombre ? 0xFFFF6B00 : 0xFF1A1A1A;
        int colorMujer = !esHombre ? 0xFFFF6B00 : 0xFF1A1A1A;

        iconoHombre.setImageTintList(ColorStateList.valueOf(colorHombre));
        iconoMujer.setImageTintList(ColorStateList.valueOf(colorMujer));

        btnSiguiente.setEnabled(true);
    }
}