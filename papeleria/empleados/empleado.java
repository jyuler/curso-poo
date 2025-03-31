package papeleria.empleados;
import papeleria.personas.Persona;

public class empleado extends Persona {
    
    private String puesto;
    public empleado(String nombre, String puesto) {
        super(nombre);
        this.puesto = puesto;
    }

    public String getPuesto() { return puesto; }

    @Override
    public void mostrarInfo() {
        System.out.println("Empleado: " + getNombre() + ", Puesto: " + puesto);
    }
}
