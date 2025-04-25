import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaSoporte {
    private List<TicketSoporte> tickets;
    private static int contadorTicketsCreados = 0;

    public SistemaSoporte() {
        this.tickets = new ArrayList<>();
    }

    public void crearTicket(String descripcion, Usuario usuario) {
        contadorTicketsCreados++;
        TicketSoporte nuevoTicket = new TicketSoporte(contadorTicketsCreados, descripcion, usuario);
        this.tickets.add(nuevoTicket);
        System.out.println("Ticket ID " + nuevoTicket.getId() + " creado.");
    }

    public void asignarTecnico(int ticketId, Tecnico tecnico) {
        for (TicketSoporte ticket : tickets) {
            if (ticket.getId() == ticketId) {
                ticket.asignarTecnico(tecnico.getNombre());
                System.out.println("Técnico " + tecnico.getNombre() + " asignado al Ticket ID " + ticketId + ".");
                return;
            }
        }
        System.out.println("No se encontró ningún ticket con el ID " + ticketId + ".");
    }

    public List<TicketSoporte> listarTicketsPorEstado(String estado) {
        return tickets.stream()
                .filter(ticket -> ticket.getEstado().equalsIgnoreCase(estado))
                .collect(Collectors.toList());
    }

    public void listarTodosLosTickets() {
        System.out.println("\n--- Listado de todos los tickets ---");
        for (TicketSoporte ticket : tickets) {
            System.out.println(ticket.mostrarDetalle() + "\n---");
        }
    }

    public static int obtenerCantidadTicketsCreados() {
        return contadorTicketsCreados;
    }
}
