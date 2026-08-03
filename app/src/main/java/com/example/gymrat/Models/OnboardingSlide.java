package com.example.gymrat.Models;

public class OnboardingSlide {

    private final String titulo;
    private final String descripcion;

    public OnboardingSlide(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}