public class Estudiante {
    private String nombre;
    private String apellido;
    private String curso;
    private double calificacion;

    public Estudiante(String nombre, String apellido, String curso, double calificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.calificacion = calificacion;
    }
    public void mostrarInfo() {
        System.out.println("Apellido: " + apellido);
        System.out.println("Nombre: " + nombre);
        System.out.println("Curso: " + curso);
        System.out.println("Calificacion " + calificacion);
    }
    public void subirCalificacion(double puntos){
        if (puntos > 0) {
            calificacion += puntos;
            if (calificacion > 10) {
                calificacion = 10;
            }
        }
    }
    public void bajarCalificacion(double puntos){
        if (puntos > 0) {
            calificacion -= puntos;
            if (calificacion < 0) {
                calificacion = 0;
            }
        }
    }

}
