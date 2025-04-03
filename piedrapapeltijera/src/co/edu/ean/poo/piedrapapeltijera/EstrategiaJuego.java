package co.edu.ean.poo.piedrapapeltijera;

public interface EstrategiaJuego {
    /**
     * Devuelve la siguiente jugada que esta estrategia decida.
     * 
     * @param figuraAnterior La figura que el oponente generó en la jugada inmediatamente anterior
     * @return Siguiente jugada
     */
    Figura siguiente(Figura figuraAnterior);

    String name();
}
