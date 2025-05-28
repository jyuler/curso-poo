package papeleria.clientes;
import papeleria.personas.Persona;

public class cliente extends Persona{
    private String telefono;
    public cliente(String nombre, String telefono) {
        super(nombre);
        this.telefono = telefono;
    }

    public String getTelefono() { return telefono; }

    @Override
    public void mostrarInfo() {
        System.out.println("Cliente: " + getNombre() + ", Telefono: " + telefono);
    }
}