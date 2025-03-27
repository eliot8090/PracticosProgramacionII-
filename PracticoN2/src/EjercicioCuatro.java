import java.util.Scanner;

public class EjercicioCuatro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int Producto;
        String categoria;
        double preciofinal;


        System.out.println("Ingrese el precio del producto: ");
        Producto = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese la categoria del producto: (A, B o C) ");
        categoria = scanner.nextLine().toUpperCase();

        System.out.println("El precio original es: " + Producto);

        switch (categoria) {
            case "A":
                System.out.println("Descuento aplicado: 10%");
                preciofinal = Producto * 0.90;
                System.out.println("Precio final: " + preciofinal);
                break;
            case "B":
                System.out.println("Descuento aplicado: 15%");
                preciofinal = Producto * 0.85;
                System.out.println("Precio final: " + preciofinal);
                break;
            case "C":
                System.out.println("Descuento aplicado: 20%");
                preciofinal = Producto * 0.80;
                System.out.println("Precio final: " + preciofinal);
                break;
            default:
                System.out.println("Datos incorrectos.");
                break;
        }
    }
}
