package service;
import dao.ItemPedidoDAOImpl;
import dao.PedidoDAOImpl;
import dao.ProductoDAOImpl;
import model.ItemPedido;
import model.Pedido;
import model.Producto;
import java.util.List;
import java.util.Optional;
public class PedidoServiceImpl implements GenericService<Pedido> {
    private final PedidoDAOImpl pedidoDAO = new PedidoDAOImpl();
    private final ProductoDAOImpl productoDAO = new ProductoDAOImpl();
    private final ItemPedidoDAOImpl itemPedidoDAO = new ItemPedidoDAOImpl();
    @Override
    public void crear(Pedido pedido) throws Exception {
        validarPedido(pedido);
// Verificar stock y descontarlo
        for (ItemPedido item : pedido.getItems()) {
            Producto producto = productoDAO.obtenerPorId(item.getProducto().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado: " +
                            item.getProducto().getId()));
            if (producto.getCantidad() < item.getCantidad()) {
                throw new IllegalArgumentException("Stock insuficiente para el producto: " +
                        producto.getNombre());
            }
// Descontar stock
            producto.setCantidad(producto.getCantidad() - item.getCantidad());
            productoDAO.actualizar(producto);
        }
        pedidoDAO.crear(pedido);
    }
    @Override
    public Optional<Pedido> obtenerPorId(int id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("ID de pedido inválido");
        }
        return pedidoDAO.obtenerPorId(id);
    }
    @Override
    public List<Pedido> obtenerTodos() throws Exception {
        return pedidoDAO.obtenerTodos();
    }
    @Override
    public void actualizar(Pedido pedido) throws Exception {
        validarPedido(pedido);
        pedidoDAO.actualizar(pedido);
    }
    @Override
    public void eliminar(int id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("ID de pedido inválido");
        }
        Optional<Pedido> pedidoOpt = pedidoDAO.obtenerPorId(id);
        if (pedidoOpt.isEmpty()) {
            throw new IllegalArgumentException("Pedido no encontrado con ID: " + id);
        }
// Restaurar stock de productos
        Pedido pedido = pedidoOpt.get();
        for (ItemPedido item : pedido.getItems()) {
            Producto producto = productoDAO.obtenerPorId(item.getProducto().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado: " +
                            item.getProducto().getId()));
            producto.setCantidad(producto.getCantidad() + item.getCantidad());
            productoDAO.actualizar(producto);
        }
        pedidoDAO.eliminar(id);
    }
    public void mostrarDetallePedido(int pedidoId) throws Exception {
        Pedido pedido = pedidoDAO.obtenerPorId(pedidoId)
                .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado con ID: " +
                        pedidoId));
        System.out.println("\n📋 DETALLE DEL PEDIDO #" + pedidoId);
        System.out.println("Fecha: " + pedido.getFecha());
        System.out.println("----------------------------------------");
        for (ItemPedido item : pedido.getItems()) {
            Producto producto = item.getProducto();
            System.out.printf("%-20s %-15s %-5d $%.2f%n",
                    producto.getNombre(),
                    "(" + producto.getCategoria().getNombre() + ")",
                    item.getCantidad(),
                    item.getSubtotal());
        }
        System.out.println("----------------------------------------");
        System.out.printf("%-41s $%.2f%n", "TOTAL:", pedido.getTotal());
    }
    private void validarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo");
        }
        if (pedido.getItems() == null || pedido.getItems().isEmpty()) {
            throw new IllegalArgumentException("El pedido debe contener al menos un ítem");
        }
        for (ItemPedido item : pedido.getItems()) {
            if (item.getCantidad() <= 0) {
                throw new IllegalArgumentException("La cantidad debe ser mayor que cero para todos los ítems");
            }
            if (item.getProducto() == null) {
                throw new IllegalArgumentException("Todos los ítems deben tener un producto asociado");
            }
        }
    }
}