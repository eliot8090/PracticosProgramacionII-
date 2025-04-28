public class EmpleadoAComision extends Empleado {
    private double salarioMinimo;
    private int cantClientesCaptados;
    private double montoPorCliente;
    public EmpleadoAComision(String DNI, String nombre, String apellido, int anioIngreso,
                             double sm, int ccc, double mpc) {
        super(DNI, nombre, apellido, anioIngreso);
        this.salarioMinimo = sm;
        this.cantClientesCaptados = ccc;
        this.montoPorCliente = mpc;
    }
    public int getCantClientesCaptados() {
        return cantClientesCaptados;
    }
    @Override
    public double getSalario() {
        double sal = montoPorCliente * cantClientesCaptados;
        return Math.max(sal, salarioMinimo);
    }
}
