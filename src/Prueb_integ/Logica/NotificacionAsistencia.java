package Prueb_integ.Logica;
public class NotificacionAsistencia {
    public void enviarNotificacion(String estudianteId) {
        // Simulación del envío de notificación
        // En un sistema real, esto podría enviarse por correo electrónico, SMS, etc.
        System.out.println("Notificación enviada a los padres del estudiante con ID: " + estudianteId);
    }

    public void enviarNotificacionAusenciaProlongada(String estudianteId) {
        // Simulación de notificación de ausencia prolongada
        System.out.println("Notificación enviada a la administración por ausencia prolongada del estudiante con ID: " + estudianteId);
    }
}

