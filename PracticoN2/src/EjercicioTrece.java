import java.util.Scanner;

public class EjercicioTrece {
    public static void main(String[] args) {
        double [] precios = new double[5];

        precios[0] = 199.99;
        precios[1] = 299.5;
        precios[2] = 149.75;
        precios[3] = 399.0;
        precios[4] = 89.99;
        System.out.println( "\nPrecios originales");
        mostrarPrecios(precios, 0);
        precios [2] = 129.99;
        System.out.println("\nPrecios modificados");
        mostrarPrecios(precios, 0);
}

public static void mostrarPrecios (double [] precios, int indice){
    if (indice < precios.length){
        System.out.printf("\nPrecio: $" + precios[indice]);
        mostrarPrecios(precios, indice +1);

    }
}
}