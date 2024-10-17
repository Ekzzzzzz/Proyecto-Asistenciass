package Prueb_integ;
public class SistemaAsistenciaFacade {
    private RegistroAsistencia registroAsistencia;
    private ReporteAsistencia reporteAsistencia;
    private NotificacionAsistencia notificacionAsistencia;
    Autenticacion autenticacion;

    // Constructor que utiliza el Factory para obtener el tipo de autenticación
    public SistemaAsistenciaFacade(String tipoAutenticacion) {
        AutenticacionFactory factory = new AutenticacionFactory();
        this.autenticacion = factory.crearAutenticacion(tipoAutenticacion);
        registroAsistencia = new RegistroAsistencia();
        reporteAsistencia = new ReporteAsistencia();
        notificacionAsistencia = new NotificacionAsistencia();
    }

    public void registrarAsistencia(String codigo) {
        if (autenticacion.autenticar(codigo)) {
            String estudianteId = codigo.split("-")[1];  // Extrae el estudianteId del código
            registroAsistencia.registrar(estudianteId);
        }
    }

    public void generarReporte() {
        reporteAsistencia.generar();
    }

    public void enviarNotificacion(String estudianteId) {
        notificacionAsistencia.enviarNotificacion(estudianteId);
    }
}

