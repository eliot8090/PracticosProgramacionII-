package kata4;

public class Gallina {
    private int idGallina;
    private int edad;
    private int huevosPuestos;

    public Gallina(int idGallina, int edad, int huevosPuestos) {
        this.idGallina = idGallina;
        this.edad = edad;
        this.huevosPuestos = huevosPuestos;
    }
    public void ponerHuevo(){
        huevosPuestos += 1;
    }
    public void envejecer(){
        edad += 1;
    }
    public void mostrarEstado(){
        System.out.println("identificador: " + idGallina);
        System.out.println("Edad: " + edad);
        System.out.println("Huevos puestos: " + huevosPuestos);
    }
}
