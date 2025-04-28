import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Inventario inventario = new Inventario();

        Producto producto1 = new Producto("A001", "Arroz", 120, 250, CategoriaProducto.ALIMENTOS);
        Producto producto2 = new Producto("E025", "Auriculares Bluetooth", 12000.50, 30, CategoriaProducto.ELECTRONICA);
        Producto producto3 = new Producto("R042", "Chaqueta Invierno", 7500.99, 15, CategoriaProducto.ROPA);
        Producto producto4 = new Producto("H010", "Juego de Sábanas", 4500.00, 40, CategoriaProducto.HOGAR);
        Producto producto5 = new Producto("A005", "Leche", 1000.90, 150, CategoriaProducto.ALIMENTOS);

        inventario.agregarProducto(producto1);
        inventario.agregarProducto(producto2);
        inventario.agregarProducto(producto3);
        inventario.agregarProducto(producto4);
        inventario.agregarProducto(producto5);

        System.out.println("--- Inventario Inicial ---");
        inventario.listarProductos();
        System.out.println();

        int totalStock = inventario.obtenerTotalStock();
        System.out.println("Total de stock disponible: " + totalStock + " unidades.");
        System.out.println();

        Optional<Producto> productoMayorStock = inventario.obtenerProductoConMayorStock();
        System.out.println("--- Producto con Mayor Stock ---");
        if (productoMayorStock.isPresent()) {
            productoMayorStock.get().mostrarInfo();
        } else {
            System.out.println("El inventario está vacío.");
        }
        System.out.println();

        double precioMin = 1000.00;
        double precioMax = 3000.00;
        List<Producto> productosEnRangoPrecio = inventario.filtrarProductosPorPrecio(precioMin, precioMax);
        System.out.println("--- Productos con Precio entre $" + String.format("%.2f", precioMin) + " y $" + String.format("%.2f", precioMax) + " ---");
        if (!productosEnRangoPrecio.isEmpty()) {
            for (Producto producto : productosEnRangoPrecio) {
                producto.mostrarInfo();
            }
        } else {
            System.out.println("No hay productos en ese rango de precios.");
        }
        System.out.println();

        inventario.mostrarCategoriasDisponibles();
    }
}