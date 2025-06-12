package model;
public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad;
    private Categoria categoria;
    // Constructores
    public Producto() {}
    public Producto(String nombre, String descripcion, double precio, int cantidad, Categoria categoria) {
        setNombre(nombre);
        setDescripcion(descripcion);
        setPrecio(precio);
        setCantidad(cantidad);
        setCategoria(categoria);
    }
    // Getters y Setters con validaciones
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }
        this.nombre = nombre;
    }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero");
        }
        this.precio = precio;
    }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        this.cantidad = cantidad;
    }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("El producto debe tener una categoría asociada");
        }
        this.categoria = categoria;
    }
    @Override
    public String toString() {
        return String.format("Producto [ID: %d, Nombre: %s, Precio: %.2f, Stock: %d, Categoría: %s]",
        id, nombre, precio, cantidad, categoria.getNombre());
    }
}
