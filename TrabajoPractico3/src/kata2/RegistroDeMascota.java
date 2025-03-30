package kata2;

public class RegistroDeMascota {
    public static void main(String[] args) {
        Mascota mascota1 = new Mascota("Amy", "Gato", 1);
        mascota1.mostrarInfo();

        mascota1.cumplirAnios();
        mascota1.mostrarInfo();
    }
}
