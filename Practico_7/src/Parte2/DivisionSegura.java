package Parte2;

import java.util.Scanner;

public class DivisionSegura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Ingrese el primer número: ");
            int numerador = scanner.nextInt();
            System.out.print("Ingrese el segundo número: ");
            int denominador = scanner.nextInt();
            int resultado = numerador / denominador;
            System.out.println("El resultado de la división es: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: No se puede dividir por cero. Ingrese otro número.");
        } finally {
            scanner.close();
        }
    }
}

