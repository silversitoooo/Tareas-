import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private Concierto concierto;
    private final List<Comprador> compradores = new ArrayList<>();
    private final List<Boleto> boletos = new ArrayList<>();

    public void configurarConcierto(String nombre, String fecha, List<Localidad> localidades) {
        this.concierto = new Concierto(nombre, fecha, localidades);
    }

    public void agregarComprador(String nombre, String email, double presupuesto) {
        compradores.add(new Comprador(nombre, email, presupuesto));
    }

    public boolean comprarBoletos(Comprador comprador, Localidad localidad, int cantidad) {
        if (localidad.venderBoletos(cantidad) && comprador.getPresupuesto() >= localidad.getPrecio() * cantidad) {
            comprador.restarPresupuesto(localidad.getPrecio() * cantidad);
            for (int i = 0; i < cantidad; i++) {
                String numeroBoleto = "B" + (boletos.size() + 1);
                boletos.add(new Boleto(numeroBoleto, localidad, comprador));
            }
            return true;
        }
        return false;
    }

    public void consultarDisponibilidad() {
        concierto.consultarDisponibilidadTotal();
    }

    public void generarReporteCaja() {
        concierto.generarReporteCaja();
    }

    public Concierto getConcierto() { return concierto; }
    public List<Comprador> getCompradores() { return compradores; }
}