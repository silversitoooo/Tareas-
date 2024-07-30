public class Comprador {
    private final String nombre;
    private final String email;
    private double presupuesto;

    public Comprador(String nombre, String email, double presupuesto) {
        this.nombre = nombre;
        this.email = email;
        this.presupuesto = presupuesto;
    }

    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public double getPresupuesto() { return presupuesto; }
    public void restarPresupuesto(double cantidad) { this.presupuesto -= cantidad; }
}