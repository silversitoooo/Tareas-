// Clase Jugador que representa a un jugador del juego
public class Jugador {
    private String nombre;
    private int puntosTotales;
    private int puntosRonda;

    // Constructor que inicializa al jugador con un nombre y puntos en cero
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntosTotales = 0;
        this.puntosRonda = 0;
    }

    // Método para lanzar dos dados y actualizar los puntos de la ronda
    public void lanzarDados(Dado dado1, Dado dado2) {
        dado1.lanzar();
        dado2.lanzar();
        int valor1 = dado1.getValorActual();
        int valor2 = dado2.getValorActual();

        // Si alguno de los dados saca un 1, el jugador pierde los puntos de la ronda
        if (valor1 == 1 || valor2 == 1) {
            perderPuntosRonda();
        } else {
            puntosRonda += valor1 + valor2;
        }
    }

    // Método para detenerse y agregar los puntos de la ronda a los puntos totales
    public void detenerse() {
        puntosTotales += puntosRonda;
        puntosRonda = 0;
    }

    // Método para perder los puntos de la ronda
    public void perderPuntosRonda() {
        puntosRonda = 0;
    }

    // Método para verificar si el jugador ha ganado el juego
    public boolean haGanado() {
        return puntosTotales >= 100;
    }

    // Métodos para obtener los puntos totales y de la ronda
    public int getPuntosTotales() {
        return puntosTotales;
    }

    public int getPuntosRonda() {
        return puntosRonda;
    }
}
