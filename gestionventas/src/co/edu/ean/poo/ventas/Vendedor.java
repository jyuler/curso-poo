package co.edu.ean.poo.ventas;

import java.time.LocalDate;

public class Vendedor {
    private int numeroVendedor;
    private String nombre;
    private String apellido;
    private LocalDate fechaIngreso;
    private ListaVentas ventas = new ListaVentas(10);

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

    public boolean registrarVenta(Venta venta) {
        if ( ! venta.getFecha().isBefore(fechaIngreso)) {
            ventas.agregarVenta(venta);
            return true;
        }
        return false;
    }

    public void registrarVenta(LocalDate fechaVenta, int valor) {
        registrarVenta( new Venta(fechaVenta, valor) );
    }

    public ListaVentas getVentas() {
        return ventas;
    }
    
    @Override
    public String toString() {
        return String.format("Vendedor[%02d:%s %s:%s]", numeroVendedor, nombre, apellido, fechaIngreso);
    }
}
