package EjercicioNueve;

import java.util.Scanner;

import static EjercicioNueve.calcularEnvio.calcularCostoEnvio;
import static EjercicioNueve.calcularTotalCompra.calcularTotal;

public class EjercicioNueve {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double peso;
        String zona;
        double precioProducto;
        double costoEnvio;
        double precioFinal;

        System.out.println("Ingrese el precio del producto: ");
        precioProducto = scanner.nextDouble();
        System.out.println("Ingrese el peso del paquete: ");
        peso = scanner.nextDouble();

        scanner.nextLine();

        System.out.println("Ingrese la zona de envio(Nacional/Internacional: ");
        zona = scanner.nextLine();



        costoEnvio = calcularCostoEnvio(peso, zona);
        if (costoEnvio == -1) {
            System.out.println("Zona de envío no válida.");
        } else {
            double totalCompra = calcularTotal(precioProducto, costoEnvio);
            System.out.println("El costo de envío es: " + costoEnvio);
            System.out.println("El total a pagar es: " + totalCompra);
        }

    }
}
