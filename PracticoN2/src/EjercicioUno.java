import java.util.Scanner;

public class EjercicioUno {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

    int año;

        System.out.println("Ingrese el año");
       año = scanner.nextInt();

       if((año % 4 == 0 && año % 100 != 0) || (año % 400 == 0)) {
           System.out.println("Es bisiesto");
        }else{
           System.out.println("No es bisiesto");}
    }
}