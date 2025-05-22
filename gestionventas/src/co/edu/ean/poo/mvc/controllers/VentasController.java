package co.edu.ean.poo.mvc.controllers;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import co.edu.ean.poo.comisiones.CalculadoraComisiones;
import co.edu.ean.poo.comisiones.Comision;
import co.edu.ean.poo.mvc.views.VentasView;
import co.edu.ean.poo.ventas.Vendedor;
import co.edu.ean.poo.ventas.Venta;

/**
 * Controlador de la vista de ventas
 */
public class VentasController implements Controller {
    // la lista de vendedores sobre la que se muestra la vista
    private List<Vendedor> vendedores = new LinkedList<>();
    // la vista que se encargará de mostrar el vendedor y sus ventas
    private VentasView vista;
    
    
    public VentasController(Collection<Vendedor> vs, VentasView vv) {
        // Si la colección de vendedores es una lista, se asigna directamente
        // a la propiedad vendedores de este objeto, de lo contrario
        // se agregan todos los vendedores a la lista actual
        if ( vs instanceof List<Vendedor> ls )
            vendedores = ls;
        else
            vendedores.addAll(vs);
        vista = vv;
        // asignar el controlador a la vista para que esta pueda invocar los metodos
        // requeridos para mostrar la información
        vista.setController(this);
    }

    /**
     * Calcula la comision de un vendedor para una venta
     * @param vendedor el vendedor
     * @param v la venta
     * @return la comision calculada
     */
    public Comision calcularComision(Vendedor vendedor, Venta v) {
        if ( vendedor == null || v == null ) return null;
        return CalculadoraComisiones.calcularComision(vendedor.getFechaIngreso(), v.fecha(), v.valor() );
    }

    /**
     * Crea una lista de vendedores que contienen el nombre parcial
     * ya sea en el nombre o en el apellido
     * @param nombreParcial nombre parcial a buscar en la lista total de vendedores
     */
    public void filtrarVendedores(String nombreParcial) {
        if ( nombreParcial == null || nombreParcial.isBlank() ) {
            vista.setListaVendedores(vendedores);
            return;
        }
        var nplc = nombreParcial.toLowerCase();
        var vs = new LinkedList<Vendedor>();
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getNombre().toLowerCase().contains(nplc) || vendedor.getApellido().toLowerCase().contains(nplc)) {
                vs.add( vendedor );
            }
        }
        vista.setListaVendedores(vs);
    }

    /**
     * Muestra los detalles del vendedor seleccionado
     * @param v
     */
    public void vendedorSeleccionado(Vendedor v) {
        // aquí el controlador podría determinar hacer otras acciones
        // antes de mostrar los detalles del vendedor
        vista.mostrarDetallesVendedor(v);
    }

    /**
     * Muestra la vista de ventas después de haber establecido la lista de
     * vendedores
     */
    public void mostrarVentas() {
        vista.setListaVendedores(vendedores);
        vista.mostrarVista();
    }
}
