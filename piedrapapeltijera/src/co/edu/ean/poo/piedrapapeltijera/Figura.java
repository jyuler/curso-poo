package co.edu.ean.poo.piedrapapeltijera;

public enum Figura {
    PIEDRA,PAPEL,TIJERA;

    public boolean esMejorQue( Figura otra ) {
        return this == PAPEL && otra == PIEDRA || 
               this == PIEDRA && otra == TIJERA ||
               this == TIJERA && otra == PAPEL;
    }

    public boolean esIgualA( Figura otra ) {
        return this == otra;
    }

    /**
     * Compara esta figura con la otra recibida por parámetro.
     * @param otra la otra figura contra la que vamos a comprar esta figura
     * @return 0 si son iguales, 1 si esta firgura le gana a la otra, -1 si la otra le gana a esta
     */
    public int comparaCon( Figura otra ) {
        if ( this.esIgualA(otra) ) return 0;
        if ( this.esMejorQue(otra) ) return 1;
        return -1;
    }
}
