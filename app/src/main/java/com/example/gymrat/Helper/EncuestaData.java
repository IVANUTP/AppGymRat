package com.example.gymrat.Helper;

public class EncuestaData {

    private static EncuestaData instancia;
    private String nombre;
    private String experiencia;
    private String meta;
    private String sexo;
    private Long idObjetivo;



    private EncuestaData() {}

    public static EncuestaData getInstancia() {
        if (instancia == null) {
            instancia = new EncuestaData();
        }
        return instancia;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getExperiencia() { return experiencia; }
    public void setExperiencia(String experiencia) { this.experiencia = experiencia; }

    public String getMeta() { return meta; }
    public void setMeta(String meta) { this.meta = meta; }
    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public Long getIdObjetivo() {
        return idObjetivo;
    }

    public void setIdObjetivo(Long idObjetivo) {
        this.idObjetivo = idObjetivo;
    }
}