package papeleria.productos;
import papeleria.interfaces.Mostrable;

public class producto implements Mostrable {
    private int id;
    private String nombre;
    private double precio;

    public producto(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    @Override
    public void mostrarInfo() {
        System.out.println("ID: " + id + ", Nombre: " + nombre + ", Precio: " + precio);
    }
}