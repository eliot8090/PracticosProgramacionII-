import model.*;
import service.*;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        CategoriaServiceImpl categoriaService = new CategoriaServiceImpl();
        ProductoServiceImpl productoService = new ProductoServiceImpl();
        PedidoServiceImpl pedidoService = new PedidoServiceImpl();
        try {
// Crear categorías de prueba
            Categoria electronica = new Categoria("Electrónica", "Productos electrónicos");
            Categoria ropa = new Categoria("Ropa", "Prendas de vestir");
            categoriaService.crear(electronica);
            categoriaService.crear(ropa);
// Crear productos de prueba
            Producto laptop = new Producto("Laptop", "Laptop de última generación", 1200.99,
                    50, electronica);
            Producto smartphone = new Producto("Smartphone", "Teléfono inteligente", 599.99,
                    100, electronica);
            Producto camisa = new Producto("Camisa", "Camisa de algodón", 29.99, 200, ropa);
            productoService.crear(laptop);
            productoService.crear(smartphone);
            productoService.crear(camisa);
// Crear un pedido con múltiples ítems
            System.out.println("\n🛒 CREANDO UN NUEVO PEDIDO");
            Pedido pedido = new Pedido();
// Agregar items al pedido
            pedido.agregarItem(new ItemPedido(laptop, 2));
            pedido.agregarItem(new ItemPedido(camisa, 5));
// Intentar crear el pedido
            pedidoService.crear(pedido);
            System.out.println("✅ Pedido creado exitosamente con ID: " + pedido.getId());
// Mostrar detalle del pedido
            pedidoService.mostrarDetallePedido(pedido.getId());
// Intentar crear pedido con stock insuficiente (debería fallar)
            System.out.println("\n⚠️ INTENTANDO CREAR PEDIDO CON STOCK INSUFICIENTE");
            Pedido pedidoInvalido = new Pedido();
            pedidoInvalido.agregarItem(new ItemPedido(smartphone, 150)); // Stock solo 100
            try {
                pedidoService.crear(pedidoInvalido);
            } catch (Exception e) {
                System.out.println("❌ Error esperado: " + e.getMessage());
            }
// Mostrar todos los pedidos
            System.out.println("\n📋 LISTADO DE TODOS LOS PEDIDOS");
            List<Pedido> pedidos = pedidoService.obtenerTodos();
            for (Pedido p : pedidos) {
                pedidoService.mostrarDetallePedido(p.getId());
            }
        } catch (Exception e) {
            System.err.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
