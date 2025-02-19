package ppt;

public class JuegoPiedraPapelTijeras {
    public void jugar(Jugador jg1, Jugador jg2, int rondas) {
        int victoriasUno = 0;
        int victoriasDos = 0;

        for (int i = 0; i < rondas; i++) {
            Mvm mvm1 = jg1.siguienteMovimiento();
            Mvm mvm2 = jg2.siguienteMovimiento();
            
            Jugador ganador = null;
            if ( mvm1.leGanaA(mvm2) )  {
                victoriasUno++;
                ganador = jg1;
            } else if ( mvm2.leGanaA(mvm1) ) {
                victoriasDos++;
                ganador = jg2;
            }
            System.out.printf("Rnd: %3d\t%s: %s - %s: %s. %s\n", (i+1), 
                jg1.getNombre(), mvm1, jg2.getNombre(), mvm2, 
                (ganador == null ? "Empatados": "GANA " + ganador.getNombre() ) 
            );

        }

        System.out.println("\nResultado Final:");
        System.out.println(jg1.getNombre() + ": " + victoriasUno + " victorias");
        System.out.println(jg2.getNombre() + ": " + victoriasDos + " victorias");
        
        if (victoriasUno > victoriasDos) {
            System.out.println(jg1.getNombre() + " es el ganador!");
        } else if (victoriasDos > victoriasUno) {
            System.out.println(jg2.getNombre() + " es el ganador!");
        } else {
            System.out.println("El juego termina en empate!");
        }
    }
}
