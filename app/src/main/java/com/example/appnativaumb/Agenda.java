package com.example.appnativaumb;

public class Agenda {
    private int id_agenda;
    private String fecha;
    private String asunto;
    private String actividad;

    // Constructor vacío
    public Agenda() {
    }

    // Constructor con parámetros
    public Agenda(int id_agenda, String fecha, String asunto, String actividad) {
        this.id_agenda = id_agenda;
        this.fecha = fecha;
        this.asunto = asunto;
        this.actividad = actividad;
    }

    // Getters y Setters
    public int getId_agenda() {
        return id_agenda;
    }

    public void setId_agenda(int id_agenda) {
        this.id_agenda = id_agenda;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
}