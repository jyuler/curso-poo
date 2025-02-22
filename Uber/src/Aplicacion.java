import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Viaje {
    String localidad;
    double valor;
    int hora;
    double duracion;

    public Viaje(String localidad, double valor, int hora, double duracion) {
        this.localidad = localidad;
        this.valor = valor;
        this.hora = hora;
        this.duracion = duracion;
    }
}

class RegistroViajes {
    private final List<Viaje> viajes = new ArrayList<>();

    public void agregarViaje(Viaje viaje) {
        viajes.add(viaje);
    }

    public List<Viaje> obtenerViajes() {
        return viajes;
    }

    public double calcularIngresoTotal() {
        return viajes.stream().mapToDouble(v -> v.valor).sum();
    }

    public double calcularPromedioPorHora() {
        double totalIngresos = calcularIngresoTotal();
        double totalHoras = viajes.stream().mapToDouble(v -> v.duracion).sum();
        return totalHoras > 0 ? totalIngresos / totalHoras : 0;
    }
}

public class Aplicacion {
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
                    System.out.print("Ingrese la localidad: ");
                    String localidad = scanner.nextLine();
                    System.out.print("Ingrese el valor del viaje: ");
                    double valor = scanner.nextDouble();
                    System.out.print("Ingrese la hora del viaje: ");
                    int hora = scanner.nextInt();
                    System.out.print("Ingrese la duración en horas: ");
                    double duracion = scanner.nextDouble();
                    scanner.nextLine();
                    registro.agregarViaje(new Viaje(localidad, valor, hora, duracion));
                    System.out.println("Viaje registrado exitosamente.");
                    break;
                case 2:
                    System.out.println("\nLista de viajes registrados:");
                    for (Viaje v : registro.obtenerViajes()) {
                        System.out.println("Localidad: " + v.localidad + ", Valor: $" + v.valor + ", Hora: " + v.hora + ", Duración: " + v.duracion + "h");
                    }
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
}
