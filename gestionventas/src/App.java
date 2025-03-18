import co.edu.ean.poo.ventas.Vendedor;
import co.edu.ean.poo.ventas.datos.Datos;

public class App {
    public static void main(String[] args) throws Exception {
        String todo = Datos.getDatosVendedores();
        String[] lineas = todo.split("\n");
        Vendedor[] arrVendedores = new Vendedor[ lineas.length ];
        int posv = 0;
        for ( String linea : lineas ) {
            String[] campos = linea.split(","); 
            int nv = Integer.parseInt( campos[0] );
            String nombre = campos[1];
            String apellido = campos[2];
            String fecha = campos[3];
            arrVendedores[ posv++ ] = new Vendedor(nv, nombre, apellido, fecha);
        }
        System.out.println( arrVendedores[0].getFechaIngreso() );
    }
}
