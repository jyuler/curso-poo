package co.edu.ean.poo.ventas.datos;

import co.edu.ean.poo.ventas.Vendedor;

public class ParseadorDatos {
    public static Vendedor[] parse(String vendedores, String ventas) {
        String[] lineas = vendedores.split("\n");
        Vendedor[] arrVendedores = new Vendedor[ lineas.length ];
        int posv = 0;
        for ( String linea : lineas ) {
            String[] campos = linea.split(","); 
            int nv = Integer.parseInt( campos[0] );
            String nombre = campos[1];
            String apellido = campos[2];
            String fecha = campos[3];
            arrVendedores[ posv++ ] = new Vendedor(nv, nombre, apellido, fecha);
        }

        lineas = ventas.split("\n");
        for ( String linea : lineas ) {
            String[] campos = linea.split(",");
            int nv = Integer.parseInt( campos[0] );
            Vendedor v = buscaVendedor(nv, arrVendedores);
            if ( v != null ) {
                String fechaVenta = campos[1];
                int valor = Integer.parseInt( campos[2] );
                v.registrarVenta(fechaVenta, valor);
            }
        }

        return arrVendedores;
    }

    private static Vendedor buscaVendedor( int nv, Vendedor[] vendedores ) {
        for ( Vendedor v : vendedores ) {
            if ( v.getNumeroVendedor() == nv ) {
                return v;
            }
        }
        return null;
    }
}
