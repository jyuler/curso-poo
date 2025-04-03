package co.edu.ean.poo.piedrapapeltijera.estrategia;

import co.edu.ean.poo.piedrapapeltijera.EstrategiaJuego;
import co.edu.ean.poo.piedrapapeltijera.Figura;

public class EstrategiaContrario implements EstrategiaJuego {
    private Figura jugada;

    public EstrategiaContrario(Figura f ) {
        this.jugada = f;
    }

    public Figura figuraVence(Figura figuraAnterior){
        if (figuraAnterior == Figura.PAPEL){
            jugada = Figura.TIJERA;
        }
        else if (figuraAnterior == Figura.TIJERA){
            jugada = Figura.PIEDRA;
        }
        else {
            jugada = Figura.PAPEL;
        }
        return jugada;
    }

    @Override
    public Figura siguiente(Figura figuraAnterior) {
        jugada = figuraVence(figuraAnterior);
        return jugada;
    }

    @Override
    public String name() {
        return "EstrategiaContraria";
    }

    
}