package com.uber.app;

import com.uber.modelo.Viaje;
import com.uber.servicio.RegistroViajes;
import com.uber.excepciones.DatoInvalidoException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppConsola {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegistroViajes registro = new RegistroViajes();

        while (true) {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Registrar un viaje");
            System.out.println("2. Ver viajes registrados");
            System.out.println("3. Calcular ingreso total");
            System.out.println("4. Calcular promedio de ingresos por hora");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarViaje(scanner, registro);
                    break;
                case 2:
                    mostrarViajes(registro);
                    break;
                case 3:
                    System.out.println("Ingreso total: $" + registro.calcularIngresoTotal());
                    break;
                case 4:
                    System.out.println("Promedio de ingresos por hora: $" + registro.calcularPromedioPorHora());
                    break;
                case 5:
                    System.out.println("Saliendo de la aplicación...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }

    private static void registrarViaje(Scanner scanner, RegistroViajes registro) {
        try {
            String localidad = obtenerLocalidad(scanner);
            double valor = obtenerValorViaje(scanner);
            int hora = obtenerHoraViaje(scanner);
            double duracion = obtenerDuracionViaje(scanner);
            registro.agregarViaje(new Viaje(localidad, valor, hora, duracion));
            System.out.println("Viaje registrado exitosamente.");
        } catch (DatoInvalidoException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarViajes(RegistroViajes registro) {
        System.out.println("\nLista de viajes registrados:");
        for (Viaje v : registro.obtenerViajes()) {
            System.out.println("Localidad: " + v.getLocalidad() + ", Valor: $" + v.getValor() + ", Hora: " + v.getHora() + ", Duración: " + v.getDuracion() + "h");
        }
    }

    private static String obtenerLocalidad(Scanner scanner) {
        System.out.print("Ingrese la localidad: ");
        return scanner.nextLine();
    }

    private static double obtenerValorViaje(Scanner scanner) throws DatoInvalidoException {
        double valor = -1;
        while (valor < 0) {
            System.out.print("Ingrese el valor del viaje: ");
            try {
                valor = scanner.nextDouble();
                if (valor < 0) {
                    throw new DatoInvalidoException("El valor no puede ser negativo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Debe ingresar un número.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }
        scanner.nextLine(); // Limpiar el buffer
        return valor;
    }

    private static int obtenerHoraViaje(Scanner scanner) throws DatoInvalidoException {
        int hora = -1;
        while (hora < 0 || hora > 23) {
            System.out.print("Ingrese la hora del viaje (0-23): ");
            try {
                hora = scanner.nextInt();
                if (hora < 0 || hora > 23) {
                    throw new DatoInvalidoException("La hora debe estar entre 0 y 23.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Debe ingresar un número entre 0 y 23.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }
        scanner.nextLine(); // Limpiar el buffer
        return hora;
    }

    private static double obtenerDuracionViaje(Scanner scanner) throws DatoInvalidoException {
        double duracion = -1;
        while (duracion < 0) {
            System.out.print("Ingrese la duración del viaje (en horas): ");
            try {
                duracion = scanner.nextDouble();
                if (duracion < 0) {
                    throw new DatoInvalidoException("La duración no puede ser negativa.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Debe ingresar un número.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }
        scanner.nextLine(); // Limpiar el buffer
        return duracion;
    }
}
