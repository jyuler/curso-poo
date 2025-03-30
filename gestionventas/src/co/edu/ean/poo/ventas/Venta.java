package co.edu.ean.poo.ventas;

import java.time.LocalDate;

public class Venta {
    private LocalDate fechaVenta;
    private int valorVenta;
    
    public Venta(LocalDate fechaVenta, int valorVenta) {
        this.fechaVenta = fechaVenta;
        this.valorVenta = valorVenta;
    }

    public LocalDate fecha() {
        return fechaVenta;
    }

    public int valor() {
        return valorVenta;
    }

    @Override
    public String toString() {
        return String.format("Venta[F:%s, V:%,d]", fechaVenta, valorVenta);
    }
}