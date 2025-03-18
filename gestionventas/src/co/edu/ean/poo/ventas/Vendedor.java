package co.edu.ean.poo.ventas;

public class Vendedor {
    private int numeroVendedor;
    private String nombre;
    private String apellido;
    private String fechaIngreso;
    private Venta[] ventas = new Venta[50];
    private int posVenta = 0;

    public Vendedor(int nv, String nm, String ap, String f ) {
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

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void registrarVenta(Venta venta) {
        ventas[ posVenta++ ] = venta;
    }

    public void registrarVenta(String fechaVenta, int valor) {
        registrarVenta( new Venta(fechaVenta, valor) );
    }

    public Venta[] getVentas() {
        return ventas;
    }
    
    @Override
    public String toString() {
        return String.format("Vendedor[%02d:%s %s:%s]", numeroVendedor, nombre, apellido, fechaIngreso);
    }
}
