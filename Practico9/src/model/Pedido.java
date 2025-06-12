package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private LocalDate fecha;
    private List<ItemPedido> items;
    private double total;
    public Pedido() {
        this.fecha = LocalDate.now();
        this.items = new ArrayList<>();
        this.total = 0.0;
    }
    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public List<ItemPedido> getItems() { return items; }
    public void setItems(List<ItemPedido> items) {
        this.items = items;
        calcularTotal();
    }
    public double getTotal() { return total; }
    public void agregarItem(ItemPedido item) {
        items.add(item);
        calcularTotal();
    }
    public void removerItem(ItemPedido item) {
        items.remove(item);
        calcularTotal();
    }
    private void calcularTotal() {
        this.total = items.stream()
                .mapToDouble(ItemPedido::getSubtotal)
                .sum();
    }
    @Override
    public String toString() {
        return String.format("Pedido [ID: %d, Fecha: %s, Total: %.2f]",
                id, fecha, total);
    }
}
