import java.time.LocalDate;

import co.edu.ean.poo.ventas.Vendedor;
import co.edu.ean.poo.ventas.datos.Datos;
import co.edu.ean.poo.ventas.datos.ParseadorDatos;

public class App {
    public static void main(String[] args) throws Exception {
        String vendedores = Datos.getDatosVendedores();
        String ventas = Datos.getDatosVentas();
        Vendedor[] arrVendedores = ParseadorDatos.parse(vendedores, ventas);
        
        LocalDate fechaInicio = LocalDate.of(2024, 7, 1);
        LocalDate fechaFin = LocalDate.of(2024, 7, 31);
        
        System.out.printf("Total ventas todos los vendedores: %,d\n\n", totalVentasVendedores(fechaInicio, fechaFin, arrVendedores));

        for (Vendedor v : topNVendedores(3, fechaInicio, fechaFin, arrVendedores))
            System.out.printf("%02d %s %s: %,d\n", v.getNumeroVendedor(), v.getNombre(), v.getApellido(), v.totalVentas(fechaInicio, fechaFin));
    }

    public static int totalVentasVendedores( LocalDate fechaInicio, LocalDate fechaFin, Vendedor[] vendedores ) {
        int totalVentas = 0;
        for (Vendedor v : vendedores) {
            totalVentas += v.totalVentas(fechaInicio, fechaFin);
        }
        return totalVentas;
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
