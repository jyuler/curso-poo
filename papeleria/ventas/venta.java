package papeleria.ventas;

import papeleria.clientes.cliente;
import papeleria.productos.producto;

public class venta {
    private cliente cliente;
    private producto producto;
    private int cantidad;

    public venta(cliente cliente, producto producto, int cantidad) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public void mostrarVenta() {
        System.out.println("Cliente: " + cliente.getNombre() + ", Producto: " + producto.getNombre() + ", Cantidad: " + cantidad);
    }
}
