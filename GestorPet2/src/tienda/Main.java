package tienda; // Ajusta el paquete según tu estructura

import productos.Producto;
import clientes.Cliente;
import ventas.Venta;

public class Main {
    public static void main(String[] args) {
        // Crear un producto
        Producto alimentoGato = new Producto("Croquetas para Gato", 25.50, 
            "Alimento balanceado para gatos adultos", "Gato");

        // Crear un cliente
        Cliente juan = new Cliente("Juan Pérez", "Calle 123", "3151234567", "juan@example.com");

        // Registrar una venta
        Venta venta1 = new Venta(juan, alimentoGato, 2);

        // Mostrar la información de la venta
        venta1.mostrarInfoVenta();
    }
}
