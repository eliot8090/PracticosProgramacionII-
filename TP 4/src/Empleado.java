public class Empleado {
    private int id;
    private String nombre;
    private String puesto;
    private double salario;
    private static int totalEmpleados = 0;

    public Empleado(int id, String nombre, String puesto, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        Empleado.totalEmpleados++;
    }

    public Empleado(String nombre, String puesto) {
        this.id = Empleado.totalEmpleados + 1;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = 25000.0;
        Empleado.totalEmpleados++;
    }

    public void actualizarSalarioPorcentaje(double porcentajeAumento) {
        this.salario += this.salario * (porcentajeAumento / 100);
    }

    public void actualizarSalarioFijo(double cantidadAumento) {
        this.salario += cantidadAumento;
    }

    @Override
    public String toString() {
        return "ID: " + this.id +
                ", Nombre: " + this.nombre +
                ", Puesto: " + this.puesto +
                ", Salario: $" + String.format("%.2f", this.salario);
    }


    public static int mostrarTotalEmpleados() {
        return Empleado.totalEmpleados;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public static int getTotalEmpleados() {
        return totalEmpleados;
    }
}
