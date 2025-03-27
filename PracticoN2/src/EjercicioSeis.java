import java.util.Scanner;

public class EjercicioSeis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num;
        int positivos=0;
        int negativos=0;
        int ceros=0;

        for (int i = 1; i<=10; i++){
            System.out.println("Ingrese el numero "+i+": ");
            num = scanner.nextInt();
            if (num > 0) {
                positivos = positivos + 1;
            } else if (num < 0){
                negativos = negativos + 1;
            }else{
                ceros = ceros +1;
            }
        }
        System.out.println("Resultados:");
        System.out.println("Positivos: "+positivos);
        System.out.println("Negativos: "+negativos);
        System.out.println("Ceros: "+ceros);
    }
}
