package kata5;

public class AgenciaEspacial {
    public static void main(String[] args) {
        NaveEspacial nave1 = new NaveEspacial("Amy", 50);
        nave1.avanzar(60);
        nave1.recargarCombustible(40);
        nave1.avanzar(60);
        nave1.mostrarEstado();
    }
}
