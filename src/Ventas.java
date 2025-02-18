package ventas;
import productos.Producto;
import clientes.Cliente;

public class Venta {
    private Cliente cliente;
    private Producto producto;
    private int cantidad;

    public Venta(Cliente cliente, Producto producto, int cantidad) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public void mostrarInfoVenta() {
        System.out.println("Venta Realizada:\nCliente: " + cliente.getNombre() + "\nProducto: " + producto.getNombre() + "\nCantidad: " + cantidad + "\nTotal: $" + (producto.getPrecio() * cantidad));
    }
}
