package Prueb_integ.Logica;
import java.time.LocalDateTime;

import Prueb_integ.DAO.AsistenciaDAO;

public class RegistroAsistencia {
    private AsistenciaDAO asistenciaDAO;

    public RegistroAsistencia() {
        asistenciaDAO = new AsistenciaDAO();  // Se conecta al DAO para interactuar con la base de datos
    }

    public void registrar(String estudianteId) {
        // Aquí puedes agregar lógica adicional, como validaciones o reglas de negocio.
        Asistencia nuevaAsistencia = new Asistencia(estudianteId, LocalDateTime.now());
        asistenciaDAO.guardarAsistencia(estudianteId);  // Guarda la asistencia en la base de datos
        System.out.println("Asistencia registrada para el estudiante con ID: " + estudianteId);
    }
}
