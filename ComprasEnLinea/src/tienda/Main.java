package tienda;

import tienda.productos.*;
import tienda.carrito.Carrito;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Carrito carrito = new Carrito();
        int opcion;

        do {
            System.out.println("\n--- Tienda Online ---");
            System.out.println("1. Comprar Camiseta ($100,000)");
            System.out.println("2. Comprar Hoddie ($200,000)");
            System.out.println("3. Comprar Short ($85,000)");
            System.out.println("4. Ver Carrito");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> carrito.agregarProducto(new Camiseta());
                case 2 -> carrito.agregarProducto(new Hoddie());
                case 3 -> carrito.agregarProducto(new Pantaloneta());
                case 4 -> carrito.mostrarCarrito();
                case 0 -> System.out.println("Gracias por su compra!");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
        scanner.close();
    }
}
