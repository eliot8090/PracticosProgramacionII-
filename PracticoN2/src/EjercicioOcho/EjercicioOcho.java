package EjercicioOcho;

import java.util.Scanner;

import static EjercicioOcho.calcularPrecioFinal.PrecioFinal;

public class EjercicioOcho {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    double precioBase;
    double impuesto;
    double descuento;

        System.out.println("Ingrese el precio del producto: ");
        precioBase = scanner.nextDouble();
        System.out.println("Ingrese el porcentaje de impuesto: ");
        impuesto = scanner.nextDouble();
        System.out.println("Ingrese el porcentaje de descuento: ");
        descuento = scanner.nextDouble();

        double precioFinal = PrecioFinal(precioBase, impuesto, descuento);
        System.out.println("El precio final del producto es: " + precioFinal);

    }
}
