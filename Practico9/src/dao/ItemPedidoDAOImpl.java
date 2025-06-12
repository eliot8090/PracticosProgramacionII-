package dao;
import config.DatabaseConnectionPool;
import model.ItemPedido;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class ItemPedidoDAOImpl implements GenericDAO<ItemPedido> {
    @Override
    public void crear(ItemPedido item) throws Exception {
        String sql = "INSERT INTO items_pedido (pedido_id, producto_id, cantidad, subtotal) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql,
                     Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, item.getPedido().getId());
            stmt.setInt(2, item.getProducto().getId());
            stmt.setInt(3, item.getCantidad());
            stmt.setDouble(4, item.getSubtotal());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("No se pudo crear el ítem de pedido");
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        }
    }
    @Override
    public Optional<ItemPedido> obtenerPorId(int id) throws Exception {
        String sql = "SELECT i.*, p.nombre as producto_nombre, p.precio as producto_precio, " + "c.id as categoria_id, c.nombre as categoria_nombre " + "FROM items_pedido i " + "JOIN productos p ON i.producto_id = p.id " + "JOIN categorias c ON p.id_categoria = c.id " + "WHERE i.id = ?";
        try (Connection conn = DatabaseConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapearItemPedido(rs));
                }
            }
        }
        return Optional.empty();
    }
    @Override
    public List<ItemPedido> obtenerTodos() throws Exception {
        List<ItemPedido> items = new ArrayList<>();
        String sql = "SELECT i.*, p.nombre as producto_nombre, p.precio as producto_precio, " + "c.id as categoria_id, c.nombre as categoria_nombre " + "FROM items_pedido i " + "JOIN productos p ON i.producto_id = p.id " + "JOIN categorias c ON p.id_categoria = c.id";
        try (Connection conn = DatabaseConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                items.add(mapearItemPedido(rs));
            }
        }
        return items;
    }
    @Override
    public void actualizar(ItemPedido item) throws Exception {
        String sql = "UPDATE items_pedido SET cantidad = ?, subtotal = ? WHERE id = ?";
        try (Connection conn = DatabaseConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, item.getCantidad());
            stmt.setDouble(2, item.getSubtotal());
            stmt.setInt(3, item.getId());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("No se pudo actualizar el ítem de pedido");
            }
        }
    }
    @Override
    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM items_pedido WHERE id = ?";
        try (Connection conn = DatabaseConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("No se pudo eliminar el ítem de pedido");
            }
        }
    }
    public List<ItemPedido> obtenerPorPedido(int pedidoId) throws Exception {
        List<ItemPedido> items = new ArrayList<>();
        String sql = "SELECT i.*, p.nombre as producto_nombre, p.precio as producto_precio, " + "c.id as categoria_id, c.nombre as categoria_nombre " + "FROM items_pedido i " + "JOIN productos p ON i.producto_id = p.id " + "JOIN categorias c ON p.id_categoria = c.id " + "WHERE i.pedido_id = ?";
        try (Connection conn = DatabaseConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pedidoId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    items.add(mapearItemPedido(rs));
                }
            }
        }
        return items;
    }
    private ItemPedido mapearItemPedido(ResultSet rs) throws SQLException {
        ItemPedido item = new ItemPedido();
        item.setId(rs.getInt("id"));
        item.setCantidad(rs.getInt("cantidad"));
        item.setSubtotal(rs.getDouble("subtotal"));
        Producto producto = new Producto();
        producto.setId(rs.getInt("producto_id"));
        producto.setNombre(rs.getString("producto_nombre"));
        producto.setPrecio(rs.getDouble("producto_precio"));
        Categoria categoria = new Categoria();
        categoria.setId(rs.getInt("categoria_id"));
        categoria.setNombre(rs.getString("categoria_nombre"));
        producto.setCategoria(categoria);
        item.setProducto(producto);
        return item;
    }
}
