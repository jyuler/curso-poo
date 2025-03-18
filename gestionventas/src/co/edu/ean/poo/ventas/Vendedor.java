package co.edu.ean.poo.ventas;

import java.time.LocalDate;
import java.time.Period;

import co.edu.ean.poo.festivos.FestivosColombia;

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

    public int totalVentas( LocalDate fechaInicio, LocalDate fechaFin ) {
        int totalVentas = 0;
        for (int i = 0; i < ventas.cantidadVentas(); i++) {
            Venta venta = ventas.getVenta(i);
            if (venta.getFecha().compareTo(fechaInicio) >= 0 && venta.getFecha().compareTo(fechaFin) <= 0) 
                totalVentas += venta.getValor();
        }
        return totalVentas;
    }

    public int calcularComision( LocalDate fechaInicio, LocalDate fechaFin ) {
        FestivosColombia fc = new FestivosColombia();
        float comision = 0;
        for (int i = 0; i < ventas.cantidadVentas(); i++) {
            Venta venta = ventas.getVenta(i);
            if ( venta.getFecha().isBefore(fechaInicio) || venta.getFecha().isAfter(fechaFin) ) continue;
            Period p = fechaIngreso.until(venta.getFecha());
            if ( p.getYears() > 0 )
                comision += venta.getValor() * 0.03;
            else if ( p.getMonths() >= 6 )
                comision += venta.getValor() * 0.025;
            else
                comision += venta.getValor() * 0.02;
            if ( venta.getFecha().getDayOfWeek().getValue() == 7 || fc.esFestivo(venta.getFecha()) )
                comision += venta.getValor() * 0.005;
        }
        return Math.round(comision);
    }

    @Override
    public String toString() {
        return String.format("Vendedor[%02d:%s %s:%s]", numeroVendedor, nombre, apellido, fechaIngreso);
    }
}
