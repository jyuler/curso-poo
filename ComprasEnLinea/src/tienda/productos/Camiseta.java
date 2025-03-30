package tienda.productos;

public class Camiseta extends Producto {
    public Camiseta() {
        super(1, "Camiseta", 100000, "Camiseta de algodón");
    }

    @Override
    public void mostrarInfo() {
        System.out.println("ID: 1, Nombre: Camiseta, Precio: 100000, Descripción: Camiseta de algodón");
    }
}
