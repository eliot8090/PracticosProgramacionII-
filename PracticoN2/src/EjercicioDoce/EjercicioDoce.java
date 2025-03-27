package EjercicioDoce;

import java.util.Scanner;

public class EjercicioDoce {
    public static void main(String[] args) {
        double [] precios = new double[5];

        precios[0] = 199.99;
        precios[1] = 299.5;
        precios[2] = 149.75;
        precios[3] = 399.0;
        precios[4] = 89.99;
        System.out.println( "Precios originales");
        for (double precio: precios){
            System.out.println("Precio: $ " + precio);
        }
        precios [2] = 129.99;
        System.out.println("Precios modificados");
        for (double precio: precios){
            System.out.println("Precio: $ " + precio);
        }
    }
}
