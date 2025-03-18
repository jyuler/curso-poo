package co.edu.ean.poo.ventas;

public class ListaVentas {
    private Venta[] ventas;
    private int indNuevaVenta = 0;

    public ListaVentas(int capacidadInicial ) {
        ventas = new Venta[capacidadInicial];
    }

    public void agregarVenta(Venta venta) {
        if ( indNuevaVenta >= ventas.length ) {
            Venta[] temp = new Venta[ventas.length * 2];
            for ( int i = 0; i < ventas.length; i++ ) {
                temp[i] = ventas[i];
            }
            ventas = temp;
        }
        ventas[ indNuevaVenta++ ] = venta;
    }

    public Venta getVenta(int i) {
        if ( i >= 0 && i < indNuevaVenta )
            return ventas[i];
        return null;
    }

    public int cantidadVentas() {
        return indNuevaVenta;
    }

    public boolean borrarVenta(int i) {
        if ( i >= 0 && i < indNuevaVenta ) {
            for ( int j = i; j < indNuevaVenta - 1; j++ ) {
                ventas[j] = ventas[j+1];
            }
            indNuevaVenta--;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return String.format("LV[%d ventas]", indNuevaVenta);
    }
}
