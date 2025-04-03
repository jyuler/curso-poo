package co.edu.ean.poo.piedrapapeltijera.estrategia;

import java.io.Console;

import co.edu.ean.poo.piedrapapeltijera.EstrategiaJuego;
import co.edu.ean.poo.piedrapapeltijera.Figura;

public class EstrategiaHumana implements EstrategiaJuego  {
    public Figura obtenerFigura() {
        Console con = System.console();

        String sel = con.readLine("Digite, p(i)edra,(p)apel,(t)ijera: ");
        if (sel.equals("i"))
            return Figura.PIEDRA;

        if (sel.equals("p"))
            return Figura.PAPEL;

        if (sel.equals("T"))
            return Figura.TIJERA;
        return Figura.TIJERA;
    }


    @Override
    public Figura siguiente(Figura figuraAnterior) {
        return obtenerFigura();
    }

    @Override
    public String name() {
        return "Est.Humana";
    }

}