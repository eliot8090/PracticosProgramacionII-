import java.util.Scanner;

public class EjercicioSiete {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nota;

        do {
            System.out.println("Ingrese una nota (0-10): ");
            nota = scanner.nextInt();
            System.out.println("Error: Nota invalida. Ingrese una nota entre 0 y 10.");
        } while (nota > 10 || nota < 0);
        System.out.println("Nota guardada correctamente");
    }
}
