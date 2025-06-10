import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Comparable<Pedido>, Identificable<Integer> {
    private int id;
    private List<Producto<?>> productos;
    private LocalDate fecha;

    public Pedido(int id, LocalDate fecha) {
        this.id = id;
        this.fecha = fecha;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto<?> producto) {
        this.productos.add(producto);
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto<?> p : productos) {
            total += p.getPrecio();
        }
        return total;
    }

    @Override
    public int compareTo(Pedido otro) {
        return Double.compare(this.calcularTotal(), otro.calcularTotal());
    }

    @Override
    public String toString() {
        return "Pedido [ID=" + id + ", Fecha=" + fecha + ", Total=$" + String.format("%.2f", calcularTotal()) + "]";
    }

    @Override
    public Integer getID() {
        return id;
    }

    @Override
    public boolean tieneMismoID(Integer idBuscado) {
        return this.id == idBuscado;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}