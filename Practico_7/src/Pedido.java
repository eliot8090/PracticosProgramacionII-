import java.util.ArrayList;
import java.util.List;

public class Pedido implements Pagable{
    private Cliente cliente;
    private String estado;
    private List<Producto> productos;


    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.estado = estado;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto){
        productos.add(producto);
    }
    @Override
    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.calcularTotal();
        }
        return total;
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        cliente.notificar("Su pedido ha cambiado de estado a: " + estado);
    }

}

