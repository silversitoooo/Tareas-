import java.util.Scanner;

public class Juego {
    private Jugador jugador1;
    private Jugador jugador2;
    private Dado dado1;
    private Dado dado2;
    private Scanner scanner;

    // Constructor que inicializa el juego con dos jugadores y dos dados
    public Juego() {
        this.jugador1 = new Jugador("Jugador 1");
        this.jugador2 = new Jugador("Computadora");
        this.dado1 = new Dado(6);
        this.dado2 = new Dado(6);
        this.scanner = new Scanner(System.in);
    }

    // Método para iniciar el juego
    public void iniciar() {
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    jugar();
                    break;
                case 2:
                    mostrarInstrucciones();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("¡Gracias por jugar!");
                    break;
                default:
                    System.out.println("Opción no válida, intenta nuevamente.");
            }
        }
    }

    // Método para mostrar el menú principal
    private void mostrarMenu() {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Jugar");
        System.out.println("2. Instrucciones");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opción: ");
    }

    // Método para jugar el juego
    private void jugar() {
        while (!jugador1.haGanado() && !jugador2.haGanado()) {
            turnoJugador(jugador1);
            if (jugador1.haGanado()) break;
            turnoJugadorComputadora(jugador2);
        }
        anunciarGanador();
        reiniciarJuego();
    }

    // Método para el turno del jugador
    private void turnoJugador(Jugador jugador) {
        boolean sigue = true;
        // Bucle del turno del jugador que continúa hasta que el jugador decida detenerse
        while (sigue) {
            jugador.lanzarDados(dado1, dado2);
            System.out.println("Puntos de la ronda: " + jugador.getPuntosRonda());
            System.out.println("Puntos totales: " + jugador.getPuntosTotales());
            // Si el jugador pierde los puntos de la ronda, el turno termina
            if (jugador.getPuntosRonda() == 0) {
                System.out.println("¡Perdiste los puntos de esta ronda!");
                break;
            }
            System.out.print("¿Deseas seguir lanzando? (1 para continuar, 0 para detenerse): ");
            sigue = scanner.nextLine().equals("1");
            if (!sigue) {
                jugador.detenerse();
            }
        }
    }

    // Método para el turno de la computadora
    private void turnoJugadorComputadora(Jugador jugador) {
        // La computadora sigue lanzando mientras los puntos de la ronda sean menores a 20 y no haya ganado
        while (jugador.getPuntosRonda() < 20 && jugador.getPuntosTotales() < 100) {
            jugador.lanzarDados(dado1, dado2);
            if (jugador.getPuntosRonda() == 0) {
                break;
            }
        }
        jugador.detenerse();
        System.out.println("Computadora terminó su turno.");
        System.out.println("Puntos de la computadora: " + jugador.getPuntosTotales());
    }

    // Método para anunciar al ganador del juego
    private void anunciarGanador() {
        if (jugador1.haGanado()) {
            System.out.println("¡Jugador 1 ha ganado el juego!");
        } else {
            System.out.println("¡La computadora ha ganado el juego!");
        }
    }

    // Método para mostrar las instrucciones del juego
    private void mostrarInstrucciones() {
        System.out.println("\n--- Instrucciones ---");
        System.out.println("El objetivo del juego es ser el primero en alcanzar 100 puntos.");
        System.out.println("En cada turno, puedes lanzar dos dados.");
        System.out.println("Si obtienes un 1 en cualquiera de los dados, pierdes los puntos de la ronda.");
        System.out.println("Puedes decidir detenerte en cualquier momento para sumar los puntos de la ronda a tus puntos totales.");
        System.out.println("La computadora sigue lanzando hasta que sus puntos de la ronda son al menos 20.");
        System.out.println("¡Buena suerte!\n");
    }

    // Método para reiniciar el juego después de anunciar al ganador
    private void reiniciarJuego() {
        jugador1 = new Jugador("Jugador 1");
        jugador2 = new Jugador("Computadora");
    }

    // Método main para iniciar el juego
    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.iniciar();
    }
}
