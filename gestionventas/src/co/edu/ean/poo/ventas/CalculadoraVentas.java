package co.edu.ean.poo.ventas;

import java.time.LocalDate;

/**
 * La clase CalculadoraVentas contiene métodos para calcular el total de ventas de un vendedor, 
 * el total de ventas de un grupo de vendedores y el top N de vendedores con mayor valor en ventas.
 */
public class CalculadoraVentas {
    public static int totalVentasVendedor( Vendedor vendedor,  LocalDate fechaInicio, LocalDate fechaFin ) {
        Venta[] ventas = vendedor.getVentas();
        int totalVentas = 0;
        for (int i = 0; i < ventas.length; i++) {
            Venta venta = ventas[i];
            if ( venta == null ) continue;
            if (venta.fecha().compareTo(fechaInicio) >= 0 && venta.fecha().compareTo(fechaFin) <= 0) 
                totalVentas += venta.valor();
        }
        return totalVentas;
    }

    /**
     * Calcula el total de ventas de un grupo de vendedores en un rango de fechas.
     * @param vendedores Arreglo de vendedores sobre los cuales se calculará el total de ventas.
     * @param fechaInicio Fecha de inicio del rango de fechas.
     * @param fechaFin Fecha de fin del rango de fechas.
     * @return Total de ventas de los vendedores en el rango de fechas.
     */
    public static long totalVentasVendedores( Vendedor[] vendedores, LocalDate fechaInicio, LocalDate fechaFin ) {
        long totalVentas = 0;
        for (Vendedor v : vendedores) {
            totalVentas += totalVentasVendedor(v, fechaInicio, fechaFin);
        }
        return totalVentas;
    }

    /**
     * Calcula el top N de vendedores con mayor valor en ventas en un rango de fechas.
     * @param vendedores Arreglo de vendedores sobre los cuales se calculará el top N.
     * @param top Número de vendedores a incluir en el top.
     * @param fechaInicio Fecha de inicio del rango de fechas.
     * @param fechaFin Fecha de fin del rango de fechas.
     * @return Arreglo de vendedores de tamaño top con mayor valor en ventas en el rango de fechas.
     */
    public static Vendedor[] topNVendedores( Vendedor[] vendedores, int top, LocalDate fechaInicio, LocalDate fechaFin ) {
        Vendedor[] topN = new Vendedor[top];
        int[] topNVentas = new int[top];
        for( Vendedor v : vendedores ) {
            int tvv = totalVentasVendedor(v, fechaInicio, fechaFin);
            for (int i = 0; i < top; i++) {
                if (tvv > topNVentas[i]) {
                    for (int j = top-1; j > i; j--) {
                        topNVentas[j] = topNVentas[j-1];
                        topN[j] = topN[j-1];
                    }
                    topNVentas[i] = tvv;
                    topN[i] = v;
                    break;
                }
            }
        }
        return topN;
    }
}
