package ppt.impl;

import java.io.Console;

import ppt.Jugador;
import ppt.Mvm;

public class JugadorHumano extends Jugador {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    private Console c = System.console();

    public JugadorHumano(String name ) {
        super(name);
    }
   

    @Override
    public Mvm siguienteMovimiento() {
        try {
            String rs = c.readLine("%sPied(r)a, (p)apel, (t)ijera: ", ANSI_YELLOW );
            if ( rs.equals("r") )
                return Mvm.Piedra;
            else if ( rs.equals("p") )
                return Mvm.Papel;
            return Mvm.Tijera;
        } finally {
            System.out.println(ANSI_RESET);
        }
    }
}
