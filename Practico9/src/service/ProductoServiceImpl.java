package service;
import dao.ProductoDAOImpl;
import model.Producto;
import service.CategoriaServiceImpl;
import java.util.List;
import java.util.Optional;
public class ProductoServiceImpl implements GenericService<Producto> {
    private final ProductoDAOImpl productoDAO = new ProductoDAOImpl();
    private final CategoriaServiceImpl categoriaService = new CategoriaServiceImpl();
    @Override
    public void crear(Producto producto) throws Exception {
        validarProducto(producto);
        if (!categoriaService.obtenerPorId(producto.getCategoria().getId()).isPresent()) {
            throw new IllegalArgumentException("No existe la categoría con ID: " +
                    producto.getCategoria().getId());
        }
        productoDAO.crear(producto);
    }
    @Override
    public Optional<Producto> obtenerPorId(int id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("ID de producto inválido");
        }
        return productoDAO.obtenerPorId(id);
    }
    @Override
    public List<Producto> obtenerTodos() throws Exception {
        return productoDAO.obtenerTodos();
    }
    @Override
    public void actualizar(Producto producto) throws Exception {
        validarProducto(producto);
        Optional<Producto> existente = productoDAO.obtenerPorId(producto.getId());
        if (existente.isEmpty()) {
            throw new IllegalArgumentException("No existe el producto con ID: " +
                    producto.getId());
        }
        if (!categoriaService.obtenerPorId(producto.getCategoria().getId()).isPresent()) {
            throw new IllegalArgumentException("No existe la categoría con ID: " +
                    producto.getCategoria().getId());
        }
        productoDAO.actualizar(producto);
    }
    @Override
    public void eliminar(int id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("ID de producto inválido");
        }
        productoDAO.eliminar(id);
    }
    public List<Producto> obtenerPorCategoria(int idCategoria) throws Exception {
        if (idCategoria <= 0) {
            throw new IllegalArgumentException("ID de categoría inválido");
        }
        if (!categoriaService.obtenerPorId(idCategoria).isPresent()) {
            throw new IllegalArgumentException("No existe la categoría con ID: " + idCategoria);
        }
        return productoDAO.obtenerPorCategoria(idCategoria);
    }
    private void validarProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }
        if (producto.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero");
        }
        if (producto.getCantidad() < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        if (producto.getCategoria() == null) {
            throw new IllegalArgumentException("El producto debe tener una categoría asociada");
        }
    }
}

