package Parte2;

import java.util.Scanner;
public class ConversionNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Ingrese un número entero: ");
            String entrada = scanner.nextLine();
            int numero = Integer.parseInt(entrada);
            System.out.println("Número ingresado: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("Error: La entrada no es un número válido.");
        } finally {
            scanner.close();
        }
    }
}

