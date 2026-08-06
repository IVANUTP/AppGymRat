package com.example.gymrat.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gymrat.Helper.EncuestaData;
import com.example.gymrat.Models.Objetivo;
import com.example.gymrat.R;
import com.example.gymrat.Repository.ObjetivoRepository;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PreguntaMetaActivity extends BaseActivity {
    private TextView[] opciones;
    private List<Objetivo> objetivos = new ArrayList<>();
    private Objetivo objetivoSeleccionado;
    private MaterialButton btnSiguiente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_meta);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        ImageView btnVolver = findViewById(R.id.btnVolver);

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
        btnSiguiente.setEnabled(false);
        btnSiguiente.setOnClickListener(v -> {

            if(objetivoSeleccionado != null){
                EncuestaData.getInstancia()
                        .setIdObjetivo(objetivoSeleccionado.getIdObjetivo());

                Intent intent = new Intent(
                        PreguntaMetaActivity.this,
                        LoginActivity.class
                );

                startActivity(intent);

                finish();
            }

        });

        cargarObjetivos();

    }
    private void cargarObjetivos(){
        ObjetivoRepository repository = new ObjetivoRepository();
        repository.obtenerObjetivos()
                .enqueue(new Callback<List<Objetivo>>() {
                    @Override
                    public void onResponse(
                            Call<List<Objetivo>> call,
                            Response<List<Objetivo>> response) {
                        if(response.isSuccessful()
                                && response.body() != null){

                            objetivos = response.body();
                            for(int i = 0; i < opciones.length; i++){

                                if(i < objetivos.size()){
                                    opciones[i].setText(
                                            objetivos.get(i).getNombre()
                                    );


                                }

                            }


                        }

                    }

                    @Override
                    public void onFailure(
                            Call<List<Objetivo>> call,
                            Throwable t) {

                    }

                });

    }


    private void seleccionar(int index){


        if(index >= objetivos.size()){
            return;
        }
        objetivoSeleccionado = objetivos.get(index);

        for(int i = 0; i < opciones.length; i++){
            opciones[i].setBackgroundResource(
                    i == index
                            ? R.drawable.bg_option_selected
                            : R.drawable.bg_option_unselected
            );

        }

        btnSiguiente.setEnabled(true);

    }

}