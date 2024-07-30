public class Localidad {
    private final String nombre;
    private final double precio;
    private int disponibilidad;
    private double recaudacion;

    public Localidad(String nombre, double precio, int disponibilidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        this.recaudacion = 0;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getDisponibilidad() { return disponibilidad; }
    public double getRecaudacion() { return recaudacion; }

    public boolean venderBoletos(int cantidad) {
        if (cantidad <= disponibilidad) {
            disponibilidad -= cantidad;
            recaudacion += cantidad * precio;
            return true;
        }
        return false;
    }
}