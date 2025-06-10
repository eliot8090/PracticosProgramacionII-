package Parte2;

import java.util.Scanner;

public class ValidarEdad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Ingrese su edad: ");
            int edad = scanner.nextInt();
            if (edad < 0 || edad > 120) {
                throw new EdadInvalidaException("Edad fuera de rango (0-120 años permitidos).");
            }
            System.out.println("Edad válida: " + edad);
        } catch (EdadInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

