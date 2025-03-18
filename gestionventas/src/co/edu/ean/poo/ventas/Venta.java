package co.edu.ean.poo.ventas;

public class Venta {
    private String fecha;
    private int valor;
    public Venta(String f, int v) {
        fecha = f;
        valor = v;
    }
    public String getFecha() {
        return fecha;
    }
    public int getValor() {
        return valor;
    }
    @Override
    public String toString() {
        return String.format("Venta[f=%s, v=%d]",fecha, valor);
    }
    
}
