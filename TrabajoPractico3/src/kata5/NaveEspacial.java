package kata5;

public class NaveEspacial {
    private String nombre;
    private int combustible;
    private final int combustibleMaximo = 100;

    public NaveEspacial(String nombre, int combustible) {
        this.nombre = nombre;
        this.combustible = combustible;
    }

    public void despegar(){
        if (combustible >= 10){
            combustible -=10;
        }else{
            System.out.println("No es posible despegar");
        }
    }
    public void avanzar(int distancia){
        if (combustible >= distancia) {
            combustible -= distancia;
            System.out.println(nombre + " ha avanzado " + distancia + " unidades.");
        } else {
            System.out.println("Combustible insuficiente para avanzar.");
        }
    }
    public void recargarCombustible(int cantidad){
        if (combustible + cantidad <= combustibleMaximo) {
            combustible += cantidad;
            System.out.println(nombre + " ha recargado " + cantidad + " de combustible");

        }else{
            combustible=combustibleMaximo;
            System.out.println(nombre + " tiene el tanque de combustible lleno ");
        }
    }
    public void mostrarEstado(){
        System.out.println("Nombre de la nave: " + nombre);
        System.out.println("Cantidad de combustible actual " + combustible);
    }
}
