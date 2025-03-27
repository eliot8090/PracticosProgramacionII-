import java.util.Scanner;

public class EjercicioTresss {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int edad;
        System.out.println("Ingrese su edad");
        edad = scanner.nextInt();
        if (edad >=0 && edad<= 12) {
            System.out.println("Usted es un niño");
        } else if (edad > 12 && edad < 18) {
            System.out.println("Usted es un adolescente");
        } else if (edad > 17 && edad < 60) {
            System.out.println("Usted es un adulto");
        } else {
            System.out.println("Usted es un adulto mayor");
        }
    }
}
