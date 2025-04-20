import java.time.LocalDate;
import java.time.Month;
import java.util.Map;

import co.edu.ean.poo.comisiones.CalculadoraComisiones;
import co.edu.ean.poo.gui.Controller;
import co.edu.ean.poo.gui.VentasGUI;
import co.edu.ean.poo.ventas.CalculadoraVentas;
import co.edu.ean.poo.ventas.Vendedor;
import co.edu.ean.poo.ventas.datos.ParseadorDatos;

public class App {

    public static void main(String[] args) throws Exception {
        String rutaArchivoVendedores = "data/vendedores.csv";
        String rutaArchivoVentas = "data/ventas.csv";
        Map<Integer,Vendedor> vendedores = ParseadorDatos.parseDesdeArchivos(rutaArchivoVendedores, rutaArchivoVentas);

        Controller c = new Controller( vendedores.values());
        VentasGUI vgui = new VentasGUI(c);
        vgui.mostrarVentana();

        // 1. valor total de ventas que el vendedor 26 tuvo en el mes de noviembre 2024
        System.out.println( CalculadoraVentas.totalVentasVendedor(
            vendedores.get( 26), 
            LocalDate.of(2024, Month.NOVEMBER, 1), 
            LocalDate.of(2024, Month.NOVEMBER, 30) 
        ));

        // 2. total de ventas que el vendedor 11 tuvo en el mes de septiembre de 2024
        try {
            System.out.println( CalculadoraVentas.totalVentasVendedor(
                vendedores.get( 11), 
                LocalDate.of(2024, Month.SEPTEMBER, 1), 
                LocalDate.of(2024, Month.SEPTEMBER, 30) 
            ));
        } catch (IllegalArgumentException e) {
            System.out.println("El vendedor 11 no existe");
        }

        // 3. total de ventas de todos los vendedores en 2024 fue de
        System.out.println( CalculadoraVentas.totalVentasVendedores(
            vendedores.values(),
            LocalDate.of(2024, Month.JANUARY, 1), 
            LocalDate.of(2024, Month.DECEMBER, 31) 
        ));

        // 4. vendedor con el mayor total en ventas en 2025
        System.out.println( CalculadoraVentas.topNVendedores(
            vendedores.values(), 1, 
            LocalDate.of(2025, Month.JANUARY, 1), 
            LocalDate.of(2025, Month.MAY, 31) 
        )[0].getNumeroVendedor());

        // 5. vendedor con el mayor total de ventas en diciembre
        Vendedor v = CalculadoraVentas.topNVendedores(
            vendedores.values(), 1, 
            LocalDate.of(2024, Month.DECEMBER, 1), 
            LocalDate.of(2024, Month.DECEMBER, 31) 
        )[0];
        System.out.println( CalculadoraVentas.totalVentasVendedor(
            v, 
            LocalDate.of(2024, Month.DECEMBER, 1), 
            LocalDate.of(2024, Month.DECEMBER, 31) 
        ));

        // 6. valor de las comisiones recibidas por el vendedor número 5 por las ventas realizadas durante el mes de octubre de 2024
        try {
            System.out.println( CalculadoraComisiones.calcularComisionVentas(
                vendedores.get( 5),
                LocalDate.of(2024, Month.OCTOBER, 1), 
                LocalDate.of(2024, Month.OCTOBER, 31) 
            ));
        } catch (IllegalArgumentException e) {
            System.out.println("El vendedor 5 no existe");
        }

        // 7. valor de las comisiones recibidas por el vendedor número 46 por las ventas realizadas durante el mes de enero de 2024 
        System.out.println( CalculadoraComisiones.calcularComisionVentas(
            vendedores.get( 46),
            LocalDate.of(2024, Month.JANUARY, 1), 
            LocalDate.of(2024, Month.JANUARY, 31) 
        ));
    }
}
