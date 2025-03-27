package EjercicioOcho;
public class calcularPrecioFinal{
    public static double PrecioFinal (double precioBase, double
impuesto, double descuento) {
        return precioBase + (precioBase * impuesto / 100) - (precioBase * descuento / 100);
    }
}
