package co.edu.ean.poo.piedrapapeltijera.estrategia;

import co.edu.ean.poo.piedrapapeltijera.EstrategiaJuego;
import co.edu.ean.poo.piedrapapeltijera.Figura;

public class EstrategiaAleatoria implements EstrategiaJuego{
    public Figura obtenerFigura(){
        Figura figura = null; 
        int numero = (int)(Math.random()*3);
        switch(numero){
            case 0:
                figura = Figura.PIEDRA;
                break;
            case 1:
                figura = Figura.PAPEL;
                break;
            case 2:
                figura = Figura.TIJERA;
                break;
        }
        return figura;
    }   

    @Override
    public Figura siguiente(Figura figuraAnterior) {
        return obtenerFigura();
    }

    @Override
    public String name() {
        return "EstrategiaAleatoria";
    }
} 