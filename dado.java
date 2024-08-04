import java.util.Random;

// Clase Dado que representa un dado con un número de caras
public class Dado {
    private int maxCaras;
    private int valorActual;
    private Random rand;

    // Constructor que inicializa el dado con el número de caras especificado
    public Dado(int maxCaras) {
        this.maxCaras = maxCaras;
        this.rand = new Random();
    }

    // Método para lanzar el dado y obtener un valor aleatorio
    public void lanzar() {
        this.valorActual = rand.nextInt(maxCaras) + 1;
    }

    // Método para obtener el valor actual del dado
    public int getValorActual() {
        return valorActual;
    }
}
