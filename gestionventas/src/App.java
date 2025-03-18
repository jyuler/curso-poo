import java.time.LocalDate;
import java.util.Arrays;

import co.edu.ean.poo.ventas.Vendedor;
import co.edu.ean.poo.ventas.datos.Datos;
import co.edu.ean.poo.ventas.datos.ParseadorDatos;

public class App {
    public static void main(String[] args) throws Exception {
        String vendedores = Datos.getDatosVendedores();
        String ventas = Datos.getDatosVentas();
        Vendedor[] arrVendedores = ParseadorDatos.parse(vendedores, ventas);
        
        LocalDate fechaInicio = LocalDate.of(2024, 10, 1);
        LocalDate fechaFin = LocalDate.of(2024, 12, 31);
        
        System.out.println("Total ventas: " + totalVentasVendedores(fechaInicio, fechaFin, arrVendedores));
        System.out.println("Total comisiones: " + totalComisionesVendedores(fechaInicio, fechaFin, arrVendedores));
    }

    public static long totalVentasVendedores( LocalDate fechaInicio, LocalDate fechaFin, Vendedor[] vendedores ) {
        long totalVentas = 0;
        for (Vendedor v : vendedores) {
            totalVentas += v.totalVentas(fechaInicio, fechaFin);
        }
        return totalVentas;
    }

    public static int totalComisionesVendedores( LocalDate fechaInicio, LocalDate fechaFin, Vendedor[] vendedores ) {
        int totalComisiones = 0;
        for (Vendedor v : vendedores) {
            totalComisiones += v.calcularComision(fechaInicio, fechaFin);
        }
        return totalComisiones;
    }

    // devuelve el top N de vendedores con mayor valor en ventas en el rango de fechas
    public static Vendedor[] topNVendedores( int top, LocalDate fechaInicio, LocalDate fechaFin, Vendedor[] vendedores ) {
        Vendedor[] topN = new Vendedor[top];
        int[] topNVentas = new int[top];
        for( Vendedor v : vendedores ) {
            int tvv = v.totalVentas(fechaInicio, fechaFin);
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
