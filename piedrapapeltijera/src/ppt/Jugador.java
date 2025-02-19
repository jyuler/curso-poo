package ppt;

public abstract class Jugador {
    private String nombre;

    protected Jugador( String nombre ) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public abstract Mvm siguienteMovimiento(); 
}