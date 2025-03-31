package papeleria.inventario;
import java.util.ArrayList;
import papeleria.productos.producto;

public class inventario {
    private ArrayList<producto> productos;

    public inventario() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(producto producto) {
        productos.add(producto);
    }

    public void mostrarInventario() {
        for (producto p : productos) {
            p.mostrarInfo();
        }
    }
}