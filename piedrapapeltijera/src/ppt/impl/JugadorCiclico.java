package ppt.impl;

import ppt.Mvm;
import ppt.Jugador;

public class JugadorCiclico extends Jugador {
    private Mvm[] movimientos = {Mvm.Piedra, Mvm.Papel, Mvm.Tijera};
    private int indiceActual = 0;

    public JugadorCiclico() {
        super("JCiclico");
    }

    @Override
    public Mvm siguienteMovimiento() {
        Mvm movimiento = movimientos[indiceActual];
        indiceActual = (indiceActual + 1) % movimientos.length; // Cicla entre opciones
        return movimiento;
    }
}
