import ppt.*;
import ppt.impl.*;

public class App {
    public static void main(String[] args) throws Exception {
        JuegoPiedraPapelTijeras jppt = new JuegoPiedraPapelTijeras();
        Jugador j1 = new JugadorAleatorio();
        Jugador j2 = new JugadorRepetidor(Mvm.Piedra);
        jppt.jugar(j1, j2, 1000);
    }
}
