package co.edu.ean.poo.ventas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vendedor {
    private int numeroVendedor;
    private String nombre;
    private String apellido;
    private LocalDate fechaIngreso;
    private List<Venta> ventas = new ArrayList<>(100);

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

    /**
     * intenta registrar la venta para el vendedor actual
     * Si la venta tiene fecha anterior a la fecha de ingreso del vendedor entonces
     * no debe registrarse puesto que es una inconsistencia
     * 
     * @param v Venta a registrar
     * @return true si la venta fue registrada, en caso contrario false
     */
    public boolean registrarVenta(Venta v) {
        if ( v == null || v.fecha().isBefore( fechaIngreso ) ) return false;
        ventas.add(v);
        return true;
    }

    public void registrarVenta(LocalDate fechaVenta, int valor) {
        registrarVenta( new Venta(fechaVenta, valor) );
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    @Override
    public boolean equals( Object otro ) {
        return otro instanceof Vendedor ov && numeroVendedor == ov.numeroVendedor;
    }

    @Override
    public String toString() {
        return String.format("Vendedor[%02d:%s %s:%s]", numeroVendedor, nombre, apellido, fechaIngreso);
    }
}
