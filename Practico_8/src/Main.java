import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Producto<?>> listaProductos = new ArrayList<>();

        Producto<String> producto1 = new Producto<>("SKU001", "Teclado Mecánico", 75.50);
        Producto<String> producto2 = new Producto<>("SKU002", "Monitor Curvo 27\"", 300.00);

        Producto<Integer> producto3 = new Producto<>(101, "Mouse Inalámbrico", 30.00);
        Producto<Integer> producto4 = new Producto<>(102, "Webcam HD", 50.00);

        listaProductos.add(producto1);
        listaProductos.add(producto2);
        listaProductos.add(producto3);
        listaProductos.add(producto4);

        System.out.println("--- Lista de Productos (Kata 1) ---");
        for (Producto<?> producto : listaProductos) {
            System.out.println(producto);
        }
        Producto<String> laptop = new Producto<>("LAPTOP001", "Laptop HP", 850.00);
        Producto<Integer> teclado = new Producto<>(2001, "Teclado Gaming", 95.00);
        Producto<String> monitor = new Producto<>("MONITOR003", "Monitor Dell", 250.00);


        Carrito<Producto<?>> miCarrito = new Carrito<>();

        miCarrito.agregarProducto(laptop);
        miCarrito.agregarProducto(teclado);
        miCarrito.agregarProducto(monitor);


        miCarrito.mostrarProductos();

        System.out.println("\nTotal del carrito: $" + String.format("%.2f", miCarrito.obtenerTotal()));

        miCarrito.eliminarProducto(teclado);

        miCarrito.mostrarProductos();
        System.out.println("\nTotal del carrito después de eliminar: $" + String.format("%.2f", miCarrito.obtenerTotal()));

        Producto<String> prodA = new Producto<>("A1", "Libro Java", 30.00);
        Producto<String> prodB = new Producto<>("B2", "Auriculares", 50.00);
        Producto<String> prodC = new Producto<>("C3", "Cargador USB", 15.00);
        Producto<String> prodD = new Producto<>("D4", "Mochila", 45.00);

        List<Pedido> pedidos = new ArrayList<>();

        Pedido pedido1 = new Pedido(1, LocalDate.of(2023, 1, 15));
        pedido1.agregarProducto(prodA);
        pedido1.agregarProducto(prodC);
        pedidos.add(pedido1);

        Pedido pedido2 = new Pedido(2, LocalDate.of(2023, 1, 10));
        pedido2.agregarProducto(prodB);
        pedidos.add(pedido2);

        Pedido pedido3 = new Pedido(3, LocalDate.of(2023, 1, 20));
        pedido3.agregarProducto(prodA);
        pedido3.agregarProducto(prodB);
        pedido3.agregarProducto(prodD);
        pedidos.add(pedido3);

        Pedido pedido4 = new Pedido(4, LocalDate.of(2023, 1, 12));
        pedido4.agregarProducto(prodC);
        pedidos.add(pedido4);

        System.out.println("--- Pedidos Originales (Kata 3) ---");
        for (Pedido p : pedidos) {
            System.out.println(p);
        }

        Collections.sort(pedidos);
        System.out.println("\n--- Pedidos Ordenados por Total (Ascendente) ---");
        for (Pedido p : pedidos) {
            System.out.println(p);
        }

        Collections.sort(pedidos, new ComparadorPedidosPorFecha());
        System.out.println("\n--- Pedidos Ordenados por Fecha (Ascendente) ---");
        for (Pedido p : pedidos) {
            System.out.println(p);
        }

        Producto<String> prodX = new Producto<>("X1", "Cámara DSLR", 800.00);
        Producto<Integer> prodY = new Producto<>(500, "Trípode", 70.00);

        List<Pedido> listaPedidos = new ArrayList<>();

        Pedido p1 = new Pedido(101, LocalDate.of(2024, 5, 1));
        p1.agregarProducto(prodX);
        listaPedidos.add(p1);

        Pedido p2 = new Pedido(102, LocalDate.of(2024, 5, 5));
        p2.agregarProducto(prodY);
        listaPedidos.add(p2);

        Pedido p3 = new Pedido(103, LocalDate.of(2024, 5, 10));
        p3.agregarProducto(prodX);
        p3.agregarProducto(prodY);
        listaPedidos.add(p3);

        System.out.println("--- Lista de Pedidos para Búsqueda (Kata 4) ---");
        for (Pedido p : listaPedidos) {
            System.out.println(p);
        }

        Buscador<Pedido, Integer> buscadorPedidos = new Buscador<>();

        Integer idBuscado1 = 102;
        Pedido pedidoEncontrado1 = buscadorPedidos.buscar(listaPedidos, idBuscado1);
        if (pedidoEncontrado1 != null) {
            System.out.println("\nPedido encontrado con ID " + idBuscado1 + ": " + pedidoEncontrado1);
        } else {
            System.out.println("\nPedido con ID " + idBuscado1 + " no encontrado.");
        }

        Integer idBuscado2 = 999;
        Pedido pedidoEncontrado2 = buscadorPedidos.buscar(listaPedidos, idBuscado2);
        if (pedidoEncontrado2 != null) {
            System.out.println("Pedido encontrado con ID " + idBuscado2 + ": " + pedidoEncontrado2);
        } else {
            System.out.println("Pedido con ID " + idBuscado2 + " no encontrado.");
        }
    }
}