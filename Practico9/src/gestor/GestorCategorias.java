package gestor;

import config.DatabaseConnection;
import model.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class GestorCategorias {
    // 🔹 Agregar nueva categoría (valida duplicados por nombre)
    public void agregarCategoria(String nombre, String descripcion) {
        if (existeCategoria(nombre)) {
            System.out.println("❌ Ya existe una categoría con ese nombre.");
            return;
        }
        String sql = "INSERT INTO categorias (nombre, descripcion) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql,
                     Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nombre);
            stmt.setString(2, descripcion);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int nuevoID = rs.getInt(1);
                    System.out.println("✅ Categoría agregada con ID: " + nuevoID);
                }
            } else {
                System.out.println("❌ No se pudo agregar la categoría.");
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al agregar categoría: " + e.getMessage());
        }
    }
    // 🔹 Verifica si ya existe una categoría con el mismo nombre
    private boolean existeCategoria(String nombre) {
        String sql = "SELECT COUNT(*) FROM categorias WHERE nombre = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al verificar duplicado: " + e.getMessage());
        }
        return false;
    }
    // 🔹 Mostrar una categoría por ID
    public void mostrarCategoria(int id) {
        String sql = "SELECT * FROM categorias WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("🗂 Categoría encontrada:");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Descripción: " + rs.getString("descripcion"));
            } else {
                System.out.println("❌ No se encontró la categoría con ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al mostrar categoría: " + e.getMessage());
        }
    }
    // 🔹 Listar todas las categorías
    public void listarCategorias() {
        String sql = "SELECT * FROM categorias";
        List<Categoria> lista = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Categoria cat = new Categoria(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion")
                );
                lista.add(cat);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al listar categorías: " + e.getMessage());
        }
        if (lista.isEmpty()) {
            System.out.println("📭 No hay categorías en la base de datos.");
        } else {
            System.out.println("\n📋 LISTA DE CATEGORÍAS:");
            for (Categoria c : lista) {
                System.out.printf("ID: %d | Nombre: %s | Descripción: %s\n",
                        c.getId(), c.getNombre(), c.getDescripcion());
            }
        }
    }
    // 🔹 Actualizar una categoría por ID
    public void actualizarCategoria(int id, String nombre, String descripcion) {
        String sql = "UPDATE categorias SET nombre = ?, descripcion = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, descripcion);
            stmt.setInt(3, id);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Categoría actualizada con éxito.");
            } else {
                System.out.println("❌ No se encontró la categoría con ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al actualizar categoría: " + e.getMessage());
        }
    }
    // 🔹 Eliminar una categoría por ID
    public void eliminarCategoria(int id) {
        String sql = "DELETE FROM categorias WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Categoría eliminada con éxito.");
            } else {
                System.out.println("❌ No se encontró la categoría con ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar categoría: " + e.getMessage());
        }
    }
}
