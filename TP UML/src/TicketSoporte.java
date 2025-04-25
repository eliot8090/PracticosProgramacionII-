import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TicketSoporte {
    private int id;
    private String descripcion;
    private String estado;
    private LocalDateTime fechaCreacion;
    private Usuario usuario;
    private String tecnicoAsignado;

    public TicketSoporte(int id, String descripcion) {
        this(id, descripcion, null);
    }

    public TicketSoporte(int id, String descripcion, Usuario usuario) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = "abierto";
        this.fechaCreacion = LocalDateTime.now();
        this.usuario = usuario;
        this.tecnicoAsignado = null;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getTecnicoAsignado() {
        return tecnicoAsignado;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void cerrarTicket() {
        this.estado = "cerrado";
    }

    public void asignarTecnico(String tecnico) {
        this.tecnicoAsignado = tecnico;
    }

    public String mostrarDetalle() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String usuarioInfo = (usuario != null) ? "\nUsuario: " + usuario.getNombre() + " (" + usuario.getEmail() + ")" : "\nUsuario: No asignado";
        String tecnicoInfo = (tecnicoAsignado != null) ? "\nTécnico Asignado: " + tecnicoAsignado : "\nTécnico Asignado: No asignado";
        return "Ticket ID: " + id + "\n" +
                "Descripción: " + descripcion + "\n" +
                "Estado: " + estado + "\n" +
                "Fecha de Creación: " + fechaCreacion.format(formatter) +
                usuarioInfo +
                tecnicoInfo;
    }

    public static void main(String[] args) {

        Usuario usuario1 = new Usuario(101, "Ana Pérez", "ana.perez@example.com");

        TicketSoporte ticket2 = new TicketSoporte(2, "Error al guardar el documento", usuario1);
        TicketSoporte ticket3 = new TicketSoporte(3, "Solicitud de nueva funcionalidad");

        ticket2.asignarTecnico("Carlos López");

        System.out.println("Detalle del Ticket 2:\n" + ticket2.mostrarDetalle());
        System.out.println("\nDetalle del Ticket 3:\n" + ticket3.mostrarDetalle());
    }
    @Override
    public String toString() {
        return "Ticket ID: " + id + ", Descripción: " + descripcion + ", Estado: " + estado;
    }
}
