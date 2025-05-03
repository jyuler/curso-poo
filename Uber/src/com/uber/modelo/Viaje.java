package com.uber.modelo;

/**
 * Clase que representa un viaje en el sistema.
 * Contiene información sobre la localidad, valor, hora y duración del viaje.
 */
public class Viaje {
    private String localidad;
    private double valor;
    private int hora;
    private double duracion;

    /**
     * Constructor de la clase Viaje. Realiza validaciones de los datos proporcionados.
     * 
     * @param localidad Nombre de la localidad donde se realizó el viaje.
     * @param valor Valor del viaje (en dinero).
     * @param hora Hora en la que se realizó el viaje (entre 0 y 23).
     * @param duracion Duración del viaje en horas (no puede ser negativa).
     * @throws IllegalArgumentException Si los valores no son válidos.
     */
    public Viaje(String localidad, double valor, int hora, double duracion) {
        if (valor < 0) {
            throw new IllegalArgumentException("El valor del viaje no puede ser negativo.");
        }
        if (hora < 0 || hora > 23) {
            throw new IllegalArgumentException("La hora debe estar entre 0 y 23.");
        }
        if (duracion < 0) {
            throw new IllegalArgumentException("La duración del viaje no puede ser negativa.");
        }

        this.localidad = localidad;
        this.valor = valor;
        this.hora = hora;
        this.duracion = duracion;
    }

    // Getters
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

    // Setters con validación
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setValor(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("El valor del viaje no puede ser negativo.");
        }
        this.valor = valor;
    }

    public void setHora(int hora) {
        if (hora < 0 || hora > 23) {
            throw new IllegalArgumentException("La hora debe estar entre 0 y 23.");
        }
        this.hora = hora;
    }

    public void setDuracion(double duracion) {
        if (duracion < 0) {
            throw new IllegalArgumentException("La duración del viaje no puede ser negativa.");
        }
        this.duracion = duracion;
    }
}

