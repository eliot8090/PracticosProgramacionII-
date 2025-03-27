package EjercicioDiez;

import java.util.Scanner;

import static EjercicioDiez.actualizarStock.ActualStock;

public class EjercicioDiez {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stockActual;
        int cantidadVendida;
        int cantidadRecibidaNuevoStock;
        int nuevoStock;

        System.out.println("Ingrese el stock actual del producto");
        stockActual = scanner.nextInt();
        System.out.println("Ingrese la cantidad vendida");
        cantidadVendida = scanner.nextInt();
        System.out.println("Ingrese la cantida recibida");
        cantidadRecibidaNuevoStock = scanner.nextInt();
        nuevoStock = ActualStock(stockActual, cantidadVendida, cantidadRecibidaNuevoStock);
        System.out.println("El nuevo stock del producto es " + nuevoStock);

    }
}
