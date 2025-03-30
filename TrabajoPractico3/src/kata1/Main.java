//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Estudiante estudiante1 = new Estudiante("Elio", "Bonafede", "Comision 3", 8);
        System.out.println("Información del estudiante");
        estudiante1.mostrarInfo();

        estudiante1.subirCalificacion(2);
        System.out.println("Calificación después de subir nota");
        estudiante1.mostrarInfo();

        estudiante1.bajarCalificacion(1);
        System.out.println("Calificación después de bajar nota");
        estudiante1.mostrarInfo();
    }
}