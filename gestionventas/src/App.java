import co.edu.ean.poo.ventas.Vendedor;
import co.edu.ean.poo.ventas.datos.Datos;

public class App {
    public static void main(String[] args) throws Exception {
        String todo = Datos.getDatosVendedores();
        String[] lineas = todo.split("\n");
        for ( String linea : lineas ) {
            String[] campos = linea.split(","); 
            int nv = Integer.parseInt( campos[0] );
            String nombre = campos[1];
            String apellido = campos[2];
            String fecha = campos[3];
            Vendedor v = new Vendedor(nv, nombre, apellido, fecha);
        }
    }
}
