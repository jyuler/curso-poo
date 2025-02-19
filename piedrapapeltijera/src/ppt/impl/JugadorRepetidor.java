package ppt.impl;

import ppt.Mvm;
import ppt.Jugador;

public class JugadorRepetidor extends Jugador {
    private Mvm movimiento;

    public JugadorRepetidor(Mvm movimientoInicial) {
        super("JRepetidor");
        this.movimiento = movimientoInicial;
    }

    @Override
    public Mvm siguienteMovimiento() {
        return this.movimiento; // Siempre repite el mismo movimiento
    }
}