package co.edu.ean.poo.ventas.datos;

import java.time.LocalDate;

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
    public static Vendedor[] parseDesdeArchivos(String rutaArchivoVendedores, String rutaArchivoVentas) {
        // TODO: Implementar la lectura de archivos
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
            if (v.getNumeroVendedor() == nv) {
                return v;
            }
        }
        return null;
    }
}
