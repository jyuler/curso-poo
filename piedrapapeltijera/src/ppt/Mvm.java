package ppt;

public enum Mvm {
    Piedra, Papel, Tijera;

    public boolean leGanaA(Mvm otro ) {
        return this == Piedra && otro == Tijera || 
             this == Papel && otro == Piedra || 
             this == Tijera && otro == Papel;
    }

    public boolean esIgual( Mvm otro ) {
        return this == otro;
    }
}
