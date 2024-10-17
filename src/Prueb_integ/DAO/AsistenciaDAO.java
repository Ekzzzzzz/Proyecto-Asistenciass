package Prueb_integ.DAO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Prueb_integ.Basededatos.ConexionBaseDatos;
import Prueb_integ.Logica.Asistencia;

public class AsistenciaDAO {
    private ConexionBaseDatos conexion;
    private List<Asistencia> listaAsistencias;

    public AsistenciaDAO() {
        conexion = ConexionBaseDatos.obtenerInstancia();
        listaAsistencias = new ArrayList<>();  // Simulamos una lista de asistencias en memoria
    }

    public void guardarAsistencia(String estudianteId) {
        conexion.conectar();
        // Simulamos que se guarda en la "base de datos"
        Asistencia nuevaAsistencia = new Asistencia(estudianteId, LocalDateTime.now());
        listaAsistencias.add(nuevaAsistencia);
        System.out.println("Guardando asistencia en la base de datos para el estudiante ID: " + estudianteId);
    }

    public List<Asistencia> obtenerAsistencias() {
        conexion.conectar();
        // Simulamos la obtención de datos desde una base de datos
        return listaAsistencias;
    }
}
