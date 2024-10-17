package Prueb_integ;
import java.util.List;

public class ReporteAsistencia {
    private AsistenciaDAO asistenciaDAO;

    public ReporteAsistencia() {
        asistenciaDAO = new AsistenciaDAO();  // Usa el DAO para obtener los datos de asistencia
    }

    public void generar() {
        List<Asistencia> asistencias = asistenciaDAO.obtenerAsistencias();  // Obtiene las asistencias de la base de datos

        if (asistencias.isEmpty()) {
            System.out.println("No hay registros de asistencia para mostrar.");
        } else {
            System.out.println("Reporte de Asistencia:");
            for (Asistencia asistencia : asistencias) {
                System.out.println("Estudiante ID: " + asistencia.getEstudianteId() + ", Fecha: " + asistencia.getFechaHora());
            }
        }
    }
}
