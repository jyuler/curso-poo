package co.edu.ean.poo.gui;

import co.edu.ean.poo.ventas.Vendedor;
import co.edu.ean.poo.ventas.Venta;

public class VendedorGUI extends Vendedor {
    public VendedorGUI( Vendedor v ) {
        super(v.getNumeroVendedor(), v.getNombre(), v.getApellido(), v.getFechaIngreso() );
        for ( Venta vt : v.getVentas() ) 
            if ( vt != null ) registrarVenta(vt);
    }

    @Override
    public String toString() {
        return getNombre() + " " + getApellido();
    }
}
