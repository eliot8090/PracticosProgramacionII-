import java.util.Scanner;

public class EjercicioCinco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num=1;
        int contador=0;

        while(num!=0){
            System.out.println("Ingrese un numero (0 para terminar): ");
            num = scanner.nextInt();
            if (num%2==0){
                contador = contador+num;
            }
        }
        System.out.println("La suma de los numeros pares es: "+contador);
    }
}