package EjercicioOnce;

import java.util.Scanner;

import static EjercicioOnce.DescuentoEspecial.crearDescuentoEspecial;

public class EjercicioOnce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double precio;
        double descuentoAplicado;

        System.out.println( "Ingrese el precio del producto");
        precio = scanner.nextDouble();

        double Descuento = crearDescuentoEspecial(precio);
        System.out.println("El descuento especial aplicado es " + Descuento);
        descuentoAplicado = precio - Descuento;
        System.out.println("El precio final con descuento es " + descuentoAplicado);
        }
}
