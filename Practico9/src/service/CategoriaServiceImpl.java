package service;
import dao.CategoriaDAOImpl;
import model.Categoria;
import java.util.List;
import java.util.Optional;
public class CategoriaServiceImpl implements GenericService<Categoria> {
    private final CategoriaDAOImpl dao = new CategoriaDAOImpl();
    @Override
    public void crear(Categoria categoria) throws Exception {
        validarCategoria(categoria);
        if (dao.existeNombre(categoria.getNombre())) {
            throw new IllegalArgumentException("Ya existe una categoría con el nombre: " +
                    categoria.getNombre());
        }
        dao.crear(categoria);
    }
    @Override
    public Optional<Categoria> obtenerPorId(int id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("ID de categoría inválido");
        }
        return dao.obtenerPorId(id);
    }
    @Override
    public List<Categoria> obtenerTodos() throws Exception {
        return dao.obtenerTodos();
    }
    @Override
    public void actualizar(Categoria categoria) throws Exception {
        validarCategoria(categoria);
        Optional<Categoria> existente = dao.obtenerPorId(categoria.getId());
        if (existente.isEmpty()) {
            throw new IllegalArgumentException("No existe la categoría con ID: " +
                    categoria.getId());
        }
// Verificar si el nombre ha cambiado
        if (!existente.get().getNombre().equals(categoria.getNombre())) {
            if (dao.existeNombre(categoria.getNombre())) {
                throw new IllegalArgumentException("Ya existe una categoría con el nombre: " +
                        categoria.getNombre());
            }
        }
        dao.actualizar(categoria);
    }
    @Override
    public void eliminar(int id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("ID de categoría inválido");
        }
        if (dao.tieneProductosAsociados(id)) {
            throw new IllegalStateException("No se puede eliminar la categoría porque tiene productos asociados");
        }
        dao.eliminar(id);
    }
    private void validarCategoria(Categoria categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("La categoría no puede ser nula");
        }
        if (categoria.getNombre() == null || categoria.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la categoría no puede estar vacío");
        }
    }
}
