package co.edu.ean.poo.ventas.datos;

public class Vendedor {
    private int numeroVendedor;
    private String nombre;
    private String apellido;
    private String fechaIngreso;

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

    
}
