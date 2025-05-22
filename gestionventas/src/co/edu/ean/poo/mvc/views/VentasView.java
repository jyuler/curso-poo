package co.edu.ean.poo.mvc.views;

import java.util.List;

import co.edu.ean.poo.ventas.Vendedor;

/**
 * Interfaz que define los métodos de la vista de ventas.
 */
public interface VentasView extends View {
    /**
     * establece la lista de vendedores a mostrar en la vista.
     * @param vendedores
     */
    void setListaVendedores(List<Vendedor> vendedores);

    /**
     * indica a la vista que muestre los detalles de un vendedor.
     * @param v
     */
    void mostrarDetallesVendedor( Vendedor v );
}
