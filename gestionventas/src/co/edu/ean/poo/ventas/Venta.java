package co.edu.ean.poo.ventas;

import java.time.LocalDate;

public class Venta {
    private LocalDate fecha;
    private int valor;
    public Venta(LocalDate f, int v) {
        fecha = f;
        valor = v;
    }
    public LocalDate getFecha() {
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
