import java.util.Scanner;

public class EjercicioDos {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int num;
        int num2;
        int num3;

        System.out.println("Ingrese el primer numero: ");
        num = scanner.nextInt();
        System.out.println("Ingrese el segundo numero: ");
        num2 = scanner.nextInt();
        System.out.println("Ingrese el tercer numero: ");
        num3 = scanner.nextInt();

        if ((num>num2) && (num>num3)) {
            System.out.println(num + " es el mayor");
        } else if ((num2>num) && (num2 > num3)) {
            System.out.println(num2 + " es el mayor");
        }else{
            System.out.println(num3+" es el mayor");
        }
    }
}
