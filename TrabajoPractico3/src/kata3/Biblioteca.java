package kata3;

public class Biblioteca {
    public static void main(String[] args) {
        Libro libro1 = new Libro("Creación de la Coca-Cola", "Coca-Cola Company", 1905);
        libro1.setAnioPublicacion(1855);
        libro1.setAnioPublicacion(1910);

        System.out.println("Informacion del libro");
        libro1.mostrarInfo();
    }
}
