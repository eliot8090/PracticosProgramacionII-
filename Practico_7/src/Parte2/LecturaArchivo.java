package Parte2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class LecturaArchivo {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            File archivo = new File("datos.txt");
            scanner = new Scanner(archivo);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: El archivo no existe.");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
