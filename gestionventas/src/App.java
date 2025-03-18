import java.time.LocalDate;

import co.edu.ean.poo.ventas.ListaVentas;
import co.edu.ean.poo.ventas.Vendedor;
import co.edu.ean.poo.ventas.datos.Datos;
import co.edu.ean.poo.ventas.datos.ParseadorDatos;

public class App {
    public static void main(String[] args) throws Exception {
        String vendedores = Datos.getDatosVendedores();
        String ventas = Datos.getDatosVentas();
        Vendedor[] arrVendedores = ParseadorDatos.parse(vendedores, ventas);
        
        System.out.println(arrVendedores[0].getVentas().getVenta(0));
    }
}
