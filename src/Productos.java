package productos;

public class Producto {
    private String nombre;
    private double precio;
    private String descripcion;
    private String tipoAnimal;

    public Producto(String nombre, double precio, String descripcion, String tipoAnimal) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.tipoAnimal = tipoAnimal;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void mostrarInfoProducto() {
        System.out.println("Producto: " + nombre + "\nPrecio: $" + precio + "\nDescripción: " + descripcion + "\nPara: " + tipoAnimal);
    }
}