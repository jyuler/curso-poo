package co.edu.ean.poo.ventas;

/**
 * La clase ListaVentas representa una lista de ventas que puede crecer dinámicamente.
 * Permite agregar ventas, obtener una venta específica y conocer la cantidad de ventas en la lista.
 */
public class ListaVentas {
    private Venta[] ventas;
    private int indNuevaVenta = 0;

    /**
     * Inicializa la lista de ventas con una capacidad inicial.
     * 
     * @param capacidadInicial La capacidad inicial de la lista de ventas.
     */
    public ListaVentas(int capacidadInicial) {
        ventas = new Venta[capacidadInicial];
    }

    /**
     * Agrega una nueva venta a la lista. Si la lista está llena, duplica su capacidad.
     * 
     * @param venta La venta a agregar.
     */
    public void agregarVenta(Venta venta) {
        if (indNuevaVenta >= ventas.length) {
            Venta[] temp = new Venta[ventas.length * 2];
            for (int i = 0; i < ventas.length; i++) {
                temp[i] = ventas[i];
            }
            ventas = temp;
        }
        ventas[indNuevaVenta++] = venta;
    }

    /**
     * Obtiene la venta en la posición especificada.
     * 
     * @param i El índice de la venta a obtener.
     * @return La venta en la posición especificada, o null si el índice es inválido.
     */
    public Venta getVenta(int i) {
        if (i >= 0 && i < indNuevaVenta)
            return ventas[i];
        return null;
    }

    /**
     * Obtiene la cantidad de ventas en la lista.
     * 
     * @return La cantidad de ventas.
     */
    public int cantidadVentas() {
        return indNuevaVenta;
    }

    /**
     * Devuelve una representación en cadena de la lista de ventas.
     * 
     * @return Una cadena que representa la lista de ventas.
     */
    @Override
    public String toString() {
        return String.format("LV[%d ventas]", indNuevaVenta);
    }
}
