import java.util.Collection;

public class Buscador<T extends Identificable<K>, K> {

    public T buscar(Collection<? extends T> elementos, K id) {
        for (T elemento : elementos) {
            if (elemento.tieneMismoID(id)) {
                return elemento;
            }
        }
        return null; // Devuelve null si no se encuentra el elemento
    }
}