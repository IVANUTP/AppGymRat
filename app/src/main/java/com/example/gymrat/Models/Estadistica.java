package com.example.gymrat.Models;

public class Estadistica {

    private int icono;
    private String valor;
    private String titulo;

    public Estadistica(int icono, String valor, String titulo) {
        this.icono = icono;
        this.valor = valor;
        this.titulo = titulo;
    }

    public int getIcono() {
        return icono;
    }

    public String getValor() {
        return valor;
    }

    public String getTitulo() {
        return titulo;
    }
}