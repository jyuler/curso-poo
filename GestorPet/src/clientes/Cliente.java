package cliente; //paquete donde pertenece la clase

public class Cliente {
    private String nombre;
    private String direccion;
    private String celular;
    private String email;

    //  Constructor
    public Cliente (String nombre, String direccion, String celular, String email)
        this.nombre = nombre;
        this.direccion = direccion;
        this.celular = celular;
        this.email = email;

    //  Getters (obtener valores)
    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCelular() {
        return celular;
    }   

    public String getEmail() {
        return email;
    }

    //  Setters (establecer valores) son los valores que puedan cambiar

    public void  setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void getCelular(String celular) {
        this.celular = celular;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método para mostrar información del cliente

    public void mostrarInformacionCliente() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Dirección: " + direccion);
        System.out.println("Celular: " + celular);
        System.out.println("Email: " + email);
    }

}
