import co.edu.ean.poo.ventas.Vendedor;
import co.edu.ean.poo.ventas.Venta;
import co.edu.ean.poo.ventas.datos.Datos;
import co.edu.ean.poo.ventas.datos.ParseDatos;

public class App {
    public static void main(String[] args) throws Exception {
        Vendedor[] vendedores = ParseDatos.parseDatos();
        Vendedor vd = vendedores[2];
        for ( int i = 0; i < 50 ; i++ ) {
            System.out.println( vd.getVenta(i) );
        }
    }
}
