// Archivo: Carrito.java
package tienda.carrito;

import tienda.productos.Producto;
import java.util.ArrayList;

public class Carrito {
    private ArrayList<Producto> listaProductos;
    private double total;

    public Carrito() {
        listaProductos = new ArrayList<>();
        total = 0;
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
        total += producto.getPrecio();
    }

    public void mostrarCarrito() {
        System.out.println("\nCarrito de Compras:");
        for (Producto producto : listaProductos) {
            producto.mostrarInfo();
        }
        System.out.println("Total: $" + total);
    }

    public double calcularTotal() {
        return total;
    }
}