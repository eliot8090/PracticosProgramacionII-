import java.util.ArrayList;
import java.util.List;

public class Carrito<T extends Producto<?>> {
    private List<T> productos;

    public Carrito() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(T producto) {
        this.productos.add(producto);
        System.out.println("Agregado al carrito: " + producto.getNombre());
    }

    public void eliminarProducto(T producto) {
        if (this.productos.remove(producto)) {
            System.out.println("Eliminado del carrito: " + producto.getNombre());
        } else {
            System.out.println("El producto " + producto.getNombre() + " no se encontró en el carrito.");
        }
    }

    public double obtenerTotal() {
        double total = 0;
        for (T producto : productos) {
            total += producto.getPrecio(); // Se asume que getPrecio() es suficiente para el total del producto
        }
        return total;
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }
        System.out.println("\n--- Contenido del Carrito ---");
        for (T producto : productos) {
            System.out.println(producto);
        }
    }
}
