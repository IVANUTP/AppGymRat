package com.example.gymrat.Models;

public class Historial {

    private String dia;
    private String mes;
    private String rutina;
    private String duracion;
    private String volumen;
    private String mejora;

    public Historial(String dia,
                     String mes,
                     String rutina,
                     String duracion,
                     String volumen,
                     String mejora) {

        this.dia = dia;
        this.mes = mes;
        this.rutina = rutina;
        this.duracion = duracion;
        this.volumen = volumen;
        this.mejora = mejora;
    }

    public String getDia() {
        return dia;
    }

    public String getMes() {
        return mes;
    }

    public String getRutina() {
        return rutina;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getVolumen() {
        return volumen;
    }

    public String getMejora() {
        return mejora;
    }
}