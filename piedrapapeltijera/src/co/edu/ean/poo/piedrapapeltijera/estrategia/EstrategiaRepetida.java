package co.edu.ean.poo.piedrapapeltijera.estrategia;

import co.edu.ean.poo.piedrapapeltijera.EstrategiaJuego;
import co.edu.ean.poo.piedrapapeltijera.Figura;

public class EstrategiaRepetida implements EstrategiaJuego {
    private Figura jugada;

    public EstrategiaRepetida(Figura f ) {
        this.jugada = f;
    }

    @Override
    public Figura siguiente(Figura figuraAnterior) {
        return jugada;
    }

    @Override
    public String name() {
        return "EstrategiaRepetida";
    }
}
