package productos; //paquete donde pertenece la clase

public class Producto {
    private String nombre;
    private double precio;
    private String descripcion;
    private String tipoAnimal;

    //  Constructor
    public Producto (String nombre, double precio, String descripcion, String tipoAnimal) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.tipoAnimal = tipoAnimal;
    }

    //  Getters (obtener valores)
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }   

    //  Setters (establecer valores) son los valores que puedan cambiar

    public void setPrecio(double precio){
        this.precio = precio;
    
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //  Método para mostrar información del producto

    public void mostrarInformacionDeProducto() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Tipo de animal: " + tipoAnimal);
    }

}