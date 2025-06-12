package dao;
import config.DatabaseConnectionPool;
import model.Pedido;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class PedidoDAOImpl implements GenericDAO<Pedido> {

    private final ItemPedidoDAOImpl itemPedidoDAO = new ItemPedidoDAOImpl();
    @Override
    public void crear(Pedido pedido) throws Exception {
        String sql = "INSERT INTO pedidos (fecha, total) VALUES (?, ?)";
        Connection conn = null;
        try {
            conn = DatabaseConnectionPool.getConnection();
            conn.setAutoCommit(false); // Iniciar transacción
            // Insertar pedido
            try (PreparedStatement stmt = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS)) {
                stmt.setDate(1, Date.valueOf(pedido.getFecha()));
                stmt.setDouble(2, pedido.getTotal());
                int affectedRows = stmt.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("No se pudo crear el pedido");
                }
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        pedido.setId(generatedKeys.getInt(1));
                    }
                }
            }
// Insertar items del pedido
            for (ItemPedido item : pedido.getItems()) {
                item.setPedido(pedido);
                itemPedidoDAO.crear(item);
            }
            conn.commit(); // Confirmar transacción
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback(); // Revertir en caso de error
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }
    @Override
    public Optional<Pedido> obtenerPorId(int id) throws Exception {
        String sql = "SELECT * FROM pedidos WHERE id = ?";
        try (Connection conn = DatabaseConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Pedido pedido = new Pedido();
                    pedido.setId(rs.getInt("id"));
                    pedido.setFecha(rs.getDate("fecha").toLocalDate());
                    pedido.setTotal(rs.getDouble("total"));
// Obtener items del pedido
                    pedido.setItems(itemPedidoDAO.obtenerPorPedido(id));
                    return Optional.of(pedido);
                }
            }
        }
        return Optional.empty();
    }
    @Override
    public List<Pedido> obtenerTodos() throws Exception {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedidos ORDER BY fecha DESC";
        try (Connection conn = DatabaseConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id"));
                pedido.setFecha(rs.getDate("fecha").toLocalDate());
                pedido.setTotal(rs.getDouble("total"));
// Obtener items del pedido
                pedido.setItems(itemPedidoDAO.obtenerPorPedido(pedido.getId()));
                pedidos.add(pedido);
            }
        }
        return pedidos;
    }
    @Override
    public void actualizar(Pedido pedido) throws Exception {
        String sql = "UPDATE pedidos SET fecha = ?, total = ? WHERE id = ?";
        try (Connection conn = DatabaseConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(pedido.getFecha()));
            stmt.setDouble(2, pedido.getTotal());
            stmt.setInt(3, pedido.getId());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("No se pudo actualizar el pedido");
            }
        }
    }
    @Override
    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM pedidos WHERE id = ?";
        try (Connection conn = DatabaseConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("No se pudo eliminar el pedido");
            }
        }
    }
}