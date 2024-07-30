import java.util.List;

public class Concierto {
    private final String nombre;
    private final String fecha;
    private final List<Localidad> localidades;

    public Concierto(String nombre, String fecha, List<Localidad> localidades) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.localidades = localidades;
    }

    public List<Localidad> getLocalidades() { return localidades; }

    public void consultarDisponibilidadTotal() {
        System.out.println("Disponibilidad total:");
        for (Localidad localidad : localidades) {
            System.out.println(localidad.getNombre() + ": " + localidad.getDisponibilidad());
        }
    }

    public void generarReporteCaja() {
        double total = 0;
        for (Localidad localidad : localidades) {
            total += localidad.getRecaudacion();
        }
        System.out.println("Recaudación total: " + total);
    }
}