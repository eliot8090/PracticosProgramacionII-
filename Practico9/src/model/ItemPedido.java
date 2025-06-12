package model;

public class ItemPedido {
    private int id;
    private Producto producto;
    private int cantidad;
    private double subtotal;
    public ItemPedido() {}
    public ItemPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = producto.getPrecio() * cantidad;
    }
    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) {
        this.producto = producto;
        calcularSubtotal();
    }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        calcularSubtotal();
    }
    public double getSubtotal() { return subtotal; }
    private void calcularSubtotal() {
        if (producto != null) {
            this.subtotal = producto.getPrecio() * cantidad;
        }
    }
    @Override
    public String toString() {
        return String.format("ItemPedido [ID: %d, Producto: %s, Cantidad: %d, Subtotal: %.2f]",
                id, producto.getNombre(), cantidad, subtotal);
    }
}
