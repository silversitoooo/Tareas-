import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        List<Localidad> localidades = new ArrayList<>();
        localidades.add(new Localidad("VIP", 150.0, 100));
        localidades.add(new Localidad("General", 50.0, 500));
        sistema.configurarConcierto("Gran Concierto", "2024-08-15", localidades);

        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 5) {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> agregarComprador(sistema, scanner);
                case 2 -> comprarBoletos(sistema, scanner);
                case 3 -> sistema.consultarDisponibilidad();
                case 4 -> sistema.generarReporteCaja();
                case 5 -> System.out.println("Saliendo del sistema");
                default -> System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }

    private static void agregarComprador(Sistema sistema, Scanner scanner) {
        System.out.print("Nombre del comprador: ");
        String nombre = scanner.nextLine();
        System.out.print("Email del comprador: ");
        String email = scanner.nextLine();
        System.out.print("Presupuesto del comprador: ");
        double presupuesto = scanner.nextDouble();
        scanner.nextLine();
        sistema.agregarComprador(nombre, email, presupuesto);
    }

    private static void comprarBoletos(Sistema sistema, Scanner scanner) {
        System.out.print("Nombre del comprador: ");
        String nombreComprador = scanner.nextLine();
        Comprador comprador = sistema.getCompradores().stream()
            .filter(c -> c.getNombre().equals(nombreComprador))
            .findFirst()
            .orElse(null);
        if (comprador != null) {
            System.out.print("Nombre de la localidad: ");
            String nombreLocalidad = scanner.nextLine();
            Localidad localidad = sistema.getConcierto().getLocalidades().stream()
                .filter(l -> l.getNombre().equals(nombreLocalidad))
                .findFirst()
                .orElse(null);
            if (localidad != null) {
                System.out.print("Cantidad de boletos: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine();
                if (sistema.comprarBoletos(comprador, localidad, cantidad)) {
                    System.out.println("Compra exitosa!");
                } else {
                    System.out.println("Error en la compra.");
                }
            } else {
                System.out.println("Localidad no encontrada.");
            }
        } else {
            System.out.println("Comprador no encontrado.");
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Agregar comprador");
        System.out.println("2. Comprar boletos");
        System.out.println("3. Consultar disponibilidad");
        System.out.println("4. Generar reporte de caja");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }
}