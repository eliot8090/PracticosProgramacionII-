import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Inventario {
    private ArrayList<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        this.productos.add(p);
    }

    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }
        System.out.println("--- Lista de Productos en el Inventario ---");
        for (Producto producto : productos) {
            producto.mostrarInfo();
        }
    }

    public int obtenerTotalStock() {
        return productos.stream()
                .mapToInt(Producto::getCantidad)
                .sum();
    }

    public Optional<Producto> obtenerProductoConMayorStock() {
        if (productos.isEmpty()) {
            return Optional.empty();
        }
        return productos.stream()
                .max(Comparator.comparingInt(Producto::getCantidad));
    }

    public List<Producto> filtrarProductosPorPrecio(double min, double max) {
        return productos.stream()
                .filter(producto -> producto.getPrecio() >= min && producto.getPrecio() <= max)
                .collect(Collectors.toList());
    }

    public void mostrarCategoriasDisponibles() {
        System.out.println("--- Categorías de Productos Disponibles ---");
        for (CategoriaProducto categoria : CategoriaProducto.values()) {
            System.out.println(categoria + ": " + categoria.getDescripcion());
        }
        System.out.println("-----------------------------------------");
    }
}
