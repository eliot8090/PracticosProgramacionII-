//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Empleado empleado1 = new Empleado(1, "Juan Pérez", "Gerente", 50000.0);
        Empleado empleado2 = new Empleado("María Gómez", "Analista");
        Empleado empleado3 = new Empleado("Carlos López", "Desarrollador");
        Empleado empleado4 = new Empleado(2, "Ana Rodríguez", "Contador", 45000.0);

        // Utilizando los métodos sobrecargados para actualizar salarios
        System.out.println("--- Salarios Iniciales ---");
        System.out.println(empleado1);
        System.out.println(empleado2);
        System.out.println(empleado3);
        System.out.println(empleado4);
        System.out.println();

        empleado1.actualizarSalarioPorcentaje(10);
        empleado2.actualizarSalarioFijo(3000.0);
        empleado3.actualizarSalarioPorcentaje(5.5);

        System.out.println("--- Salarios Después de Actualización ---");
        System.out.println(empleado1);
        System.out.println(empleado2);
        System.out.println(empleado3);
        System.out.println(empleado4);
        System.out.println();


        System.out.println("--- Información de Empleados ---");
        System.out.println(empleado1);
        System.out.println(empleado2);
        System.out.println(empleado3);
        System.out.println(empleado4);
        System.out.println();

        System.out.println("Total de empleados creados: " + Empleado.mostrarTotalEmpleados());
    }
}