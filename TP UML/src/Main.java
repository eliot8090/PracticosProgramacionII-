import java.util.List;

public class Main {
    public static void main(String[] args) {

        Usuario usuarioA = new Usuario(201, "Laura Gómez", "laura.gomez@example.com");
        Usuario usuarioB = new Usuario(202, "Pedro Vargas", "pedro.vargas@example.com");


        Tecnico tecnicoX = new Tecnico(301, "Ana Ruiz", "Redes");
        Tecnico tecnicoY = new Tecnico(302, "Juan Pérez", "Software");


        SistemaSoporte sistema = new SistemaSoporte();


        sistema.crearTicket("No hay conexión a internet", usuarioA);
        sistema.crearTicket("Error al iniciar la aplicación", usuarioB);
        sistema.crearTicket("Solicitud de restablecimiento de contraseña", usuarioA);


        sistema.asignarTecnico(1, tecnicoX);
        sistema.asignarTecnico(2, tecnicoY);


        System.out.println("\n--- Tickets Abiertos ---");
        List<TicketSoporte> ticketsAbiertos = sistema.listarTicketsPorEstado("abierto");
        ticketsAbiertos.forEach(ticket -> System.out.println(ticket));


        List<TicketSoporte> todosLosTickets = sistema.listarTicketsPorEstado("abierto");
        if (!todosLosTickets.isEmpty()) {
            todosLosTickets.get(0).cerrarTicket();
        }


        sistema.listarTodosLosTickets();


        System.out.println("\nCantidad total de tickets creados: " + SistemaSoporte.obtenerCantidadTicketsCreados());
    }
}