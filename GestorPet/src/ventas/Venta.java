package venta; //paquete donde pertenece la clase

public class Venta{
    private Cliente cliente;
    private Producto producto;
    private int cantidad;

    //  Constructor
    public Venta (Cliente cliente, Producto producto, int cantidad){
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    //  Getters (obtener valores)
    public Cliente getCliente(){
        return cliente;
    }

    public Producto getProducto(){
        return producto;
    }

    public int getCantidad(){
        return cantidad;
    }

    public void mostraarInfoVenta(){
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Producto: " + producto.getNombre());
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Total:  $ " + (cantidad * producto.getPrecio()));
    
    }

}