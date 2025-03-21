package co.edu.ean.poo.ventas.datos;

import java.time.LocalDate;

import co.edu.ean.poo.ventas.Vendedor;
import co.edu.ean.poo.ventas.Venta;

public class ParseDatos {
    public static Vendedor[] parseDatos() {
        String todo = Datos.getDatosVendedores();
        String[] lineas = todo.split("\n");
        Vendedor[] arrVendedores = new Vendedor[ lineas.length ];
        int posv = 0;
        for ( String linea : lineas ) {
            String[] campos = linea.split(","); 
            int nv = Integer.parseInt( campos[0] );
            String nombre = campos[1];
            String apellido = campos[2];
            LocalDate fecha = LocalDate.parse( campos[3] );
            arrVendedores[ posv++ ] = new Vendedor(nv, nombre, apellido, fecha);
        }

        String todaslasventas = Datos.getDatosVentas();
        lineas = todaslasventas.split("\n");
        for ( String linea : lineas ) {
            String[] campos = linea.split(","); 
            int nv = Integer.parseInt( campos[0] );
            LocalDate fechaVenta = LocalDate.parse( campos[1] );
            int valor = Integer.parseInt( campos[2] );
            Venta venta = new Venta(fechaVenta, valor);
            for (int i = 0; i < arrVendedores.length; i++) {
                Vendedor vendedor = arrVendedores[i];
                if ( vendedor.getNumeroVendedor() == nv ) {
                    vendedor.agregarVenta(venta);
                    break;
                }
            }
        }

        return arrVendedores;
    }
}
