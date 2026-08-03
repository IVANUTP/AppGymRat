package com.example.gymrat.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.gymrat.Helper.EncuestaData;
import com.example.gymrat.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class PreguntaNombreActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_nombre);

        TextInputEditText edtNombre = findViewById(R.id.edtNombre);
        MaterialButton btnSiguiente = findViewById(R.id.btnSiguiente);
        var btnVolver = findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(v -> finish());

        edtNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btnSiguiente.setEnabled(s != null && s.toString().trim().length() > 0);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        btnSiguiente.setOnClickListener(v -> {
            String nombre = edtNombre.getText().toString().trim();
            EncuestaData.getInstancia().setNombre(nombre);

            Intent intent = new Intent(PreguntaNombreActivity.this, PreguntaExperienciaActivity.class);
            startActivity(intent);
        });
    }
}