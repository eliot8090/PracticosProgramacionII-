package dao;
import config.DatabaseConnectionPool;
import model.Producto;
import model.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoDAOImpl implements GenericDAO<Producto> {
    @Override
    public void crear(Producto producto) throws Exception {
        String sql = "INSERT INTO productos (nombre, descripcion, precio, cantidad, id_categoria) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql,
                     Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getDescripcion());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setInt(4, producto.getCantidad());
            stmt.setInt(5, producto.getCategoria().getId());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("No se pudo crear el producto, ninguna fila afectada");
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    producto.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("No se obtuvo el ID generado para el producto");
                }
            }
        }
    }
    @Override
    public Optional<Producto> obtenerPorId(int id) throws Exception {
        String sql = "SELECT p.*, c.nombre as categoria_nombre, c.descripcion as categoria_descripcion " + "FROM productos p JOIN categorias c ON p.id_categoria = c.id WHERE p.id = ?";
        try (Connection conn = DatabaseConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapearProducto(rs));
                }
            }
        }
        return Optional.empty();
    }
    @Override
    public List<Producto> obtenerTodos() throws Exception {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT p.*, c.nombre as categoria_nombre, c.descripcion as categoria_descripcion " + "FROM productos p JOIN categorias c ON p.id_categoria = c.id ORDER BY p.nombre";
        try (Connection conn = DatabaseConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                productos.add(mapearProducto(rs));
            }
        }
        return productos;
    }
    @Override
    public void actualizar(Producto producto) throws Exception {
        String sql = "UPDATE productos SET nombre = ?, descripcion = ?, precio = ?, cantidad =?, id_categoria = ? WHERE id = ?";
        try (Connection conn = DatabaseConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getDescripcion());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setInt(4, producto.getCantidad());
            stmt.setInt(5, producto.getCategoria().getId());
            stmt.setInt(6, producto.getId());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("No se pudo actualizar el producto, ninguna fila afectada");
            }
        }
    }
    @Override
    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (Connection conn = DatabaseConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("No se pudo eliminar el producto, ninguna fila afectada");
            }
        }
    }
    public List<Producto> obtenerPorCategoria(int idCategoria) throws Exception {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT p.*, c.nombre as categoria_nombre, c.descripcion as categoria_descripcion " + "FROM productos p JOIN categorias c ON p.id_categoria = c.id WHERE p.id_categoria = ? ORDER BY p.nombre";
        try (Connection conn = DatabaseConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCategoria);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    productos.add(mapearProducto(rs));
                }
            }
        }
        return productos;
    }
    public boolean existeCategoria(int idCategoria) throws Exception {
        String sql = "SELECT COUNT(*) FROM categorias WHERE id = ?";
        try (Connection conn = DatabaseConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCategoria);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }
    private Producto mapearProducto(ResultSet rs) throws SQLException {
        Producto producto = new Producto();
        producto.setId(rs.getInt("id"));
        producto.setNombre(rs.getString("nombre"));
        producto.setDescripcion(rs.getString("descripcion"));
        producto.setPrecio(rs.getDouble("precio"));
        producto.setCantidad(rs.getInt("cantidad"));
        Categoria categoria = new Categoria();
        categoria.setId(rs.getInt("id_categoria"));
        categoria.setNombre(rs.getString("categoria_nombre"));
        categoria.setDescripcion(rs.getString("categoria_descripcion"));
        producto.setCategoria(categoria);
        return producto;
    }
}