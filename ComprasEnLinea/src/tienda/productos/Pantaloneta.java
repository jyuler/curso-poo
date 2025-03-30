package tienda.productos;

public class Pantaloneta extends Producto {
    public Pantaloneta() {
        super(3, "Short", 85000, "Short deportivo");
    }
    @Override
    public void mostrarInfo() {
        System.out.println("ID: 3, Nombre: Short, Precio: 85000, Descripción: Short deportivo");
    }
}