package kata4;

public class GranjaDigital {
    public static void main(String[] args) {
    Gallina gallina1 = new Gallina(1502, 4, 10);
    Gallina gallina2 = new Gallina(1402, 3, 85);
        System.out.println("Estado actual del gallinero");
        gallina1.mostrarEstado();
        gallina2.mostrarEstado();

    gallina1.ponerHuevo();
    gallina2.ponerHuevo();

    gallina1.envejecer();
    gallina2.envejecer();
        System.out.println("Estado del gallinero actualizado");
    gallina1.mostrarEstado();
    gallina2.mostrarEstado();
    }
}
