package co.edu.ean.poo.ventas.datos;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
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
     * @return Un Set de objetos Vendedor con las ventas registradas.
     */
    public static Map<Integer,Vendedor> parseDesdeArchivos(String rutaArchivoVendedores, String rutaArchivoVentas) throws FileNotFoundException{
        File fvend = new File(rutaArchivoVendedores);
        File fvent = new File(rutaArchivoVentas);
        Map<Integer,Vendedor> vendedores = parseArchivoVendedores(fvend);
        parseArchivoVentas( fvent, vendedores);
        return vendedores;
    }

    private static  Map<Integer,Vendedor> parseArchivoVendedores(File fvend) throws FileNotFoundException  {
        Map<Integer,Vendedor> vendedores = new HashMap<>();

        try ( 
            Scanner scn = new Scanner( fvend );
        ) {
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
                var nuevoVendedor = new Vendedor(nv, nombre, apellido, fecha);
                var anterior = vendedores.put( nv,  nuevoVendedor );
                if ( anterior != null ) {
                    System.err.printf("Vendedor duplicado: '%d:%s %s' y '%d:%s %s'\n", 
                    anterior.getNumeroVendedor(), anterior.getNombre(), anterior.getApellido(), 
                    nv, nuevoVendedor.getNombre(), nuevoVendedor.getApellido());
                }
            }
        }
        return vendedores;
    }

    private static void parseArchivoVentas(File fvent, Map<Integer,Vendedor> vendedores) throws FileNotFoundException {

        try ( 
            Scanner scn = new Scanner( fvent );
        ) {
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
                Vendedor v = vendedores.get(nv);
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
        } 
    }
}
