package co.edu.ean.poo.ventas.datos;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import co.edu.ean.poo.ventas.Vendedor;

/**
 * La clase ParseadorDatos se encarga de parsear datos de vendedores y ventas desde cadenas de texto.
 */
public class ParseadorDatos {

    /**
     * Parsea las cadenas de texto que contienen información de vendedores y ventas,
     * y crea un arreglo de objetos Vendedor con sus respectivas ventas registradas.
     * 
     * @param rutaArchivoVendedores La ubicación del archivo que contiene la información
     *                   de los vendedores. Cada línea representa un vendedor y los campos
     *                   están separados por comas. Los campos son: número de vendedor, nombre,
     *                   apellido y fecha de ingreso.
     * @param rutaArchivoVentas     La ubicación del archivo que contiene la información
     *                   de las ventas. Cada línea representa una venta y los campos están
     *                   separados por comas. Los campos son: número de vendedor, fecha de venta
     *                   y valor de la venta.
     * @return Un arreglo de objetos Vendedor con las ventas registradas.
     */
    public static Vendedor[] parseDesdeArchivos(String rutaArchivoVendedores, String rutaArchivoVentas) throws FileNotFoundException{
        File fvend = new File(rutaArchivoVendedores);
        File fvent = new File(rutaArchivoVentas);

        Vendedor[] arrVendedores = new Vendedor[50];
        int posv = 0;

        Scanner scn = null;
        try { 
            scn = new Scanner( fvend );
            while (scn.hasNextLine()) {
                String linea = scn.nextLine();
                String[] campos = linea.split(",");
                if (campos.length < 4) {
                    System.err.printf("Linea de vendedor no valida: '%s'\n", linea);
                    continue;
                }
                int nv;
                try {
                    nv = Integer.parseInt(campos[0].trim() );
                } catch (NumberFormatException e) {
                    System.err.printf("Numero de vendedor no valido: '%s'\n", campos[0]);
                    continue;
                }
                String nombre = campos[1].trim();
                String apellido = campos[2].trim();
                LocalDate fecha;
                try {
                    fecha = LocalDate.parse(campos[3].trim());
                } catch (DateTimeParseException e) {
                    System.out.printf("Vendedor %d con fecha de ingreso incorrecta: '%s'\n", nv, campos[3]);
                    continue;
                }
                arrVendedores[posv++] = new Vendedor(nv, nombre, apellido, fecha);
            }
        } finally {
            if (scn != null) {
                scn.close();
            }
        }

        try { 
            scn = new Scanner( fvent );
            while (scn.hasNextLine()) {
                String linea = scn.nextLine();
                String[] campos = linea.split(",");
                if (campos.length < 3) {
                    System.err.printf("Linea de ventas no valida: '%s'\n", linea);
                    continue;
                }
                int nv;
                try {
                    nv = Integer.parseInt(campos[0].trim());
                } catch (NumberFormatException e) {
                    System.err.printf("Numero de vendedor no valido: '%s'\n", campos[0]);
                    continue;
                }
                Vendedor v = buscaVendedor(nv, arrVendedores);
                if (v != null) {
                    LocalDate fechaVenta;
                    try {
                        fechaVenta = LocalDate.parse(campos[1].trim());
                    } catch (DateTimeParseException e) {
                        System.out.printf("Vendedor %d con fecha de venta incorrecta: '%s'\n", nv, campos[1]);
                        continue;
                    }
                    int valor;
                    try {
                        valor = Integer.parseInt(campos[2].trim());
                    } catch (NumberFormatException e) {
                        System.err.printf("Vendedor %d con valor de venta no valido: '%s'\n", nv, campos[2]);
                        continue;
                    }
                    v.registrarVenta(fechaVenta, valor);
                }
            }
        } finally {
            if (scn != null) {
                scn.close();
            }
        }


        return arrVendedores;
    }

    /**
     * Parsea las cadenas de texto que contienen información de vendedores y ventas,
     * y crea un arreglo de objetos Vendedor con sus respectivas ventas registradas.
     * 
     * @param vendedores La cadena de texto que contiene la información de los vendedores.
     *                   Cada línea representa un vendedor y los campos están separados por comas.
     *                   Los campos son: número de vendedor, nombre, apellido y fecha de ingreso.
     * @param ventas     La cadena de texto que contiene la información de las ventas.
     *                   Cada línea representa una venta y los campos están separados por comas.
     *                   Los campos son: número de vendedor, fecha de venta y valor de la venta.
     * @return Un arreglo de objetos Vendedor con las ventas registradas.
     */
    public static Vendedor[] parse(String vendedores, String ventas) {
        String[] lineas = vendedores.split("\n");
        Vendedor[] arrVendedores = new Vendedor[lineas.length];
        int posv = 0;
        for (String linea : lineas) {
            String[] campos = linea.split(",");
            int nv = Integer.parseInt(campos[0]);
            String nombre = campos[1];
            String apellido = campos[2];
            LocalDate fecha = LocalDate.parse(campos[3]);
            arrVendedores[posv++] = new Vendedor(nv, nombre, apellido, fecha);
        }

        lineas = ventas.split("\n");
        for (String linea : lineas) {
            String[] campos = linea.split(",");
            int nv = Integer.parseInt(campos[0]);
            Vendedor v = buscaVendedor(nv, arrVendedores);
            LocalDate fechaVenta = LocalDate.parse(campos[1]);
            int valor = Integer.parseInt(campos[2]);
            v.registrarVenta(fechaVenta, valor);
        }

        return arrVendedores;
    }

    /**
     * Busca un vendedor en el arreglo de vendedores por su número de vendedor.
     * 
     * @param nv El número de vendedor a buscar.
     * @param vendedores El arreglo de vendedores donde buscar.
     * @return El objeto Vendedor correspondiente al número de vendedor, o null si no se encuentra.
     */
    public static Vendedor buscaVendedor(int nv, Vendedor[] vendedores) {
        for (Vendedor v : vendedores) {
            if (v != null && v.getNumeroVendedor() == nv) {
                return v;
            }
        }
        return null;
    }
}
