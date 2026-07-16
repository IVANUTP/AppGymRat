package com.example.gymrat.Models;

public class Rutina {

    private String nombre;
    private String dias;
    private String ejercicios;

    public Rutina(String nombre, String dias, String ejercicios) {
        this.nombre = nombre;
        this.dias = dias;
        this.ejercicios = ejercicios;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDias() {
        return dias;
    }

    public String getEjercicios() {
        return ejercicios;
    }
}