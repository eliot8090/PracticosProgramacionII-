package service;
import java.util.List;
import java.util.Optional;
public interface GenericService<T> {
    void crear(T entidad) throws Exception;
    Optional<T> obtenerPorId(int id) throws Exception;
    List<T> obtenerTodos() throws Exception;
    void actualizar(T entidad) throws Exception;
    void eliminar(int id) throws Exception;
}
