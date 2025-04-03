import co.edu.ean.poo.piedrapapeltijera.EstrategiaJuego;
import co.edu.ean.poo.piedrapapeltijera.Figura;
import co.edu.ean.poo.piedrapapeltijera.JuegoPPT;
import co.edu.ean.poo.piedrapapeltijera.estrategia.EstrategiaContrario;
import co.edu.ean.poo.piedrapapeltijera.estrategia.EstrategiaHumana;

public class App {
    public static void main(String[] args) throws Exception {
        EstrategiaJuego j1 = new EstrategiaContrario(Figura.PIEDRA);
        EstrategiaJuego j2 = new EstrategiaHumana();        
        var juego = new JuegoPPT(j1, j2, 10);
        juego.run();
    }
}
