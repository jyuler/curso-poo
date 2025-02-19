package ppt.impl;

import java.util.Random;

import ppt.Mvm;
import ppt.Jugador;

public class JugadorAleatorio extends Jugador {
    private Random random = new Random();

    public JugadorAleatorio() {
        super("JAleatorio");
    }

    @Override
    public Mvm siguienteMovimiento() {
        int choice = random.nextInt(3);
        return choice == 0 ? Mvm.Piedra : choice == 1 ? Mvm.Papel : Mvm.Tijera;
    }
}
