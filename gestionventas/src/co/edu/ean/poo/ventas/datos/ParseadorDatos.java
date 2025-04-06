package co.edu.ean.poo.ventas.datos;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import co.edu.ean.poo.ventas.Vendedor;

/**
 * La clase ParseadorDatos se encarga de parsear datos de vendedores y ventas
 * desde cadenas de texto.
 */
public class ParseadorDatos {

    /**
     * Parsea las cadenas de texto que contienen información de vendedores y ventas,
     * y crea un arreglo de objetos Vendedor con sus respectivas ventas registradas.
     * 
     * @param vendedores Una cadena de texto con información de vendedores, donde
     *                   cada línea representa un vendedor
     *                   y los campos están separados por comas. Los campos son:
     *                   número de vendedor, nombre, apellido y fecha de ingreso.
     * @param ventas     Una cadena de texto con información de ventas, donde cada
     *                   línea representa una venta
     *                   y los campos están separados por comas. Los campos son:
     *                   número de vendedor, fecha de la venta y valor de la venta.
     * @return Un arreglo de objetos Vendedor con las ventas registradas.
     */
    public static Vendedor[] parse(String vendedores, String ventas) {
        String[] lineas = vendedores.split("\n");
        Vendedor[] arrVendedores = new Vendedor[lineas.length];
        int posv = 0;
        for (String linea : lineas) {
            String[] campos = linea.split(",");
            if (campos.length < 4) {
                System.err.printf("Linea de vendedor no valida: '%s'\n", linea);
                continue;
            }
            int nv;
            try {
                nv = Integer.parseInt(campos[0]);
            } catch (NumberFormatException e) {
                System.err.printf("Numero de vendedor no valido: '%s'\n", campos[0]);
                continue;
            }
            String nombre = campos[1];
            String apellido = campos[2];
            LocalDate fecha;
            try {
                fecha = LocalDate.parse(campos[3]);
            } catch (DateTimeParseException e) {
                System.out.printf("Vendedor %d con fecha de ingreso incorrecta: '%s'\n", nv, campos[3]);
                continue;
            }
            arrVendedores[posv++] = new Vendedor(nv, nombre, apellido, fecha);
        }

        lineas = ventas.split("\n");
        for (String linea : lineas) {
            String[] campos = linea.split(",");
            if (campos.length < 3) {
                System.err.printf("Linea de ventas no valida: '%s'\n", linea);
                continue;
            }
            int nv;
            try {
                nv = Integer.parseInt(campos[0]);
            } catch (NumberFormatException e) {
                System.err.printf("Numero de vendedor no valido: '%s'\n", campos[0]);
                continue;
            }
            Vendedor v = buscaVendedor(nv, arrVendedores);
            if (v != null) {
                LocalDate fechaVenta;
                try {
                    fechaVenta = LocalDate.parse(campos[1]);
                } catch (DateTimeParseException e) {
                    System.out.printf("Vendedor %d con fecha de venta incorrecta: '%s'\n", nv, campos[1]);
                    continue;
                }
                int valor;
                try {
                    valor = Integer.parseInt(campos[2]);
                } catch (NumberFormatException e) {
                    System.err.printf("Vendedor %d con valor de venta no valido: '%s'\n", nv, campos[2]);
                    continue;
                }
                v.registrarVenta(fechaVenta, valor);
            }
        }

        return arrVendedores;
    }

    /**
     * Busca un vendedor en el arreglo de vendedores por su número de vendedor.
     * 
     * @param nv         El número de vendedor a buscar.
     * @param vendedores El arreglo de vendedores donde buscar.
     * @return El objeto Vendedor correspondiente al número de vendedor, o null si
     *         no se encuentra.
     */
    public static Vendedor buscaVendedor(int nv, Vendedor[] vendedores) {
        for (Vendedor v : vendedores) {
            if (v == null) continue;
            if (v.getNumeroVendedor() == nv) {
                return v;
            }
        }
        return null;
    }
}
