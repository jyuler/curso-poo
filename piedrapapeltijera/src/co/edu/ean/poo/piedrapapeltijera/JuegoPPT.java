package co.edu.ean.poo.piedrapapeltijera;

public class JuegoPPT implements Runnable {
    private EstrategiaJuego j1, j2;
    private int nrondas;

    public JuegoPPT( EstrategiaJuego jugador1, EstrategiaJuego jugador2, int numeroRondas) {
        j1 = jugador1;
        j2 = jugador2;
        nrondas = numeroRondas;
    }

    @Override
    public void run() {
        Figura jugadaAnterior1 = null, jugadaAngerior2 = null;
        int[] resultados = new int[nrondas];
        for (int i = 0; i < nrondas; i++) {
            Figura jugada1 = j1.siguiente(jugadaAngerior2);
            Figura jugada2 = j2.siguiente(jugadaAnterior1);
            resultados[i] = jugada1.comparaCon(jugada2);
            jugadaAnterior1 = jugada1;
            jugadaAngerior2 = jugada2;
        }
        int tgx1 = 0, tgx2 = 0, emp = 0, v = 0;
        for (int i = 0; i < resultados.length; i++) {
            v = resultados[i];
            if ( v == 0 ) emp++;
            else if ( v == 1 ) tgx1++;
            else tgx2++;
        }
        String msg = """
                Resultados:
                Empates                                 : %d
                Total Ganados por %-22s: %d
                Total Ganados por %-22s: %d
                """;
        System.out.printf(msg, emp, j1.name(), tgx1, j2.name(), tgx2 );
        if ( tgx1 > tgx2 )
            System.out.println("El Ganador es " + j1.name() );
        else if ( tgx2 > tgx1 )
            System.out.println("El Ganador es " + j2.name() );
        else
            System.out.println("Tenemos un empate rotundo");
    }


}
