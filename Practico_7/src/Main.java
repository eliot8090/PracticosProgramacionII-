//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Juan Pérez", "juan@mail.com");
        Pedido pedido = new Pedido(cliente);
        pedido.agregarProducto(new Producto("Laptop", 1000));
        pedido.agregarProducto(new Producto("Mouse", 50));
        pedido.agregarProducto(new Producto("Teclado", 80));
        System.out.println("Total a pagar: $" + pedido.calcularTotal());

        PagoConDescuento tarjeta = new TarjetaCredito("1234-5678-9012-3456");
        PagoConDescuento paypal = new PayPal("usuario@paypal.com");
        double monto = 500;
        double descuento = 10;
        tarjeta.procesarPago(monto * tarjeta.aplicarDescuento(descuento));
        paypal.procesarPago(monto * paypal.aplicarDescuento(descuento));

        pedido.cambiarEstado("Enviado");
        pedido.cambiarEstado("Entregado");

    }
}