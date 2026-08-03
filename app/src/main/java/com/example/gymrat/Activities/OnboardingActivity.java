package com.example.gymrat.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.viewpager2.widget.ViewPager2;

import com.example.gymrat.Adapters.OnboardingAdapter;
import com.example.gymrat.Models.OnboardingSlide;
import com.example.gymrat.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class OnboardingActivity extends BaseActivity {

    private ViewPager2 vpOnboarding;
    private MaterialButton btnSiguiente;
    private View[] segmentos;
    private int totalSlides;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        vpOnboarding = findViewById(R.id.vpOnboarding);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        View txtSaltar = findViewById(R.id.txtSaltar);

        segmentos = new View[]{
                findViewById(R.id.segment1),
                findViewById(R.id.segment2),
                findViewById(R.id.segment3),
                findViewById(R.id.segment4)
        };

        List<OnboardingSlide> slides = new ArrayList<>();

        slides.add(new OnboardingSlide(
                "Alcanza tus metas de entrenamiento subiendo de rango",
                "Cada sesión te acerca a tu siguiente nivel."
        ));

        slides.add(new OnboardingSlide(
                "Analiza y descubre el potencial completo de tu cuerpo",
                "Visualiza tu progreso músculo por músculo."
        ));

        slides.add(new OnboardingSlide(
                "Registra tu progreso y mira tu evolución día a día",
                "Peso, medidas y rendimiento, todo en un solo lugar."
        ));

        slides.add(new OnboardingSlide(
                "Conviértete en la mejor versión de ti mismo",
                "La constancia de hoy es el resultado de mañana."
        ));

        totalSlides = slides.size();

        OnboardingAdapter adapter = new OnboardingAdapter(slides);
        vpOnboarding.setAdapter(adapter);

        actualizarSegmentos(0);

        vpOnboarding.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                actualizarSegmentos(position);

                boolean esUltimo = position == totalSlides - 1;
                btnSiguiente.setText(esUltimo ? "Empezar" : "Siguiente");
            }
        });

        btnSiguiente.setOnClickListener(v -> {
            int actual = vpOnboarding.getCurrentItem();

            if (actual < totalSlides - 1) {
                vpOnboarding.setCurrentItem(actual + 1, true);
            } else {
                irABienvenida();
            }
        });

        txtSaltar.setOnClickListener(v -> irABienvenida());
    }

    private void actualizarSegmentos(int posicionActual) {
        for (int i = 0; i < segmentos.length; i++) {
            int color = i <= posicionActual ? Color.parseColor("#FF6B00") : Color.parseColor("#E8E8E8");
            segmentos[i].setBackgroundTintList(android.content.res.ColorStateList.valueOf(color));
        }
    }

    private void irABienvenida() {
        Intent intent = new Intent(OnboardingActivity.this, PreguntaNombreActivity.class);
        startActivity(intent);
        finish();
    }
}