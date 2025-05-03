package com.uber.servicio;

import com.uber.modelo.Viaje;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el servicio de registro de viajes.
 * Encapsula la lógica para agregar, consultar y analizar viajes.
 */
public class RegistroViajes {
    private final List<Viaje> viajes;

    public RegistroViajes() {
        this.viajes = new ArrayList<>();
    }

    /**
     * Agrega un nuevo viaje a la lista.
     *
     * @param viaje objeto Viaje a agregar
     */
    public void agregarViaje(Viaje viaje) {
        viajes.add(viaje);
    }

    /**
     * Devuelve la lista completa de viajes registrados.
     *
     * @return lista de viajes
     */
    public List<Viaje> obtenerViajes() {
        return viajes;
    }

    /**
     * Calcula el ingreso total sumando los valores de todos los viajes.
     *
     * @return ingreso total
     */
    public double calcularIngresoTotal() {
        return viajes.stream()
                     .mapToDouble(Viaje::getValor)
                     .sum();
    }

    /**
     * Calcula el promedio de ingresos por hora.
     *
     * @return promedio de ingresos por hora o 0 si la duración total es cero
     */
    public double calcularPromedioPorHora() {
        double totalHoras = viajes.stream()
                                  .mapToDouble(Viaje::getDuracion)
                                  .sum();

        if (totalHoras == 0) {
            return 0;
        }

        return calcularIngresoTotal() / totalHoras;
    }
}
