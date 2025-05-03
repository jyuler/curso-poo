package com.uber.modelo;

public abstract class Transporte {
    protected String localidad;
    protected double valor;
    protected int hora;
    protected double duracion;

    public Transporte(String localidad, double valor, int hora, double duracion) {
        this.localidad = localidad;
        this.valor = valor;
        this.hora = hora;
        this.duracion = duracion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public double getValor() {
        return valor;
    }

    public int getHora() {
        return hora;
    }

    public double getDuracion() {
        return duracion;
    }

    public abstract String toCSV();

    @Override
    public String toString() {
        return "Localidad: " + localidad + ", Valor: $" + valor + ", Hora: " + hora + ", Duración: " + duracion + "h";
    }
}
