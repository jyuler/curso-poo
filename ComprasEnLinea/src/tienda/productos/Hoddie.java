package tienda.productos;

public class Hoddie extends Producto {
    public Hoddie() {
        super(2, "Hoddie", 200000, "Hoddie");
    }

    @Override
    public void mostrarInfo() {
        System.out.println("ID: 2, Nombre: Hoddie, Precio: 200000, Descripción: Hoddie");
    }
}
