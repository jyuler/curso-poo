package co.edu.ean.poo.ventas;

import java.time.LocalDate;

public class Vendedor {
    private int numeroVendedor;
    private String nombre;
    private String apellido;
    private LocalDate fechaIngreso;
    private Venta[] ventas = new Venta[ 50 ];

    public Vendedor(int nv, String nm, String ap, LocalDate f ) {
        numeroVendedor = nv;
        nombre = nm;
        apellido = ap;
        fechaIngreso = f;
    }

    public int getNumeroVendedor() {
        return numeroVendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public Venta getVenta(int i) {
        return ventas[i];
    }

    public void borrarVenta(int i) {
        ventas[i] = null;
    }

    public void agregarVenta(Venta v) {
        if ( v.getFechaVenta().isBefore( fechaIngreso ) ) return;
        for (int i = 0; i < ventas.length; i++) {
            if ( ventas[i] == null ) {
                ventas[i] = v;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Vendedor[%02d:%s %s:%s]", numeroVendedor, nombre, apellido, fechaIngreso);
    }
}
