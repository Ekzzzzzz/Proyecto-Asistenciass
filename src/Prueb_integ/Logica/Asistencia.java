package Prueb_integ.Logica;
import java.time.LocalDateTime;

public class Asistencia {
    private String estudianteId;
    private LocalDateTime fechaHora;

    public Asistencia(String estudianteId, LocalDateTime fechaHora) {
        this.estudianteId = estudianteId;
        this.fechaHora = fechaHora;
    }

    
    public void setEstudianteId(String estudianteId) {
        this.estudianteId = estudianteId;
    }


    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }


    public String getEstudianteId() {
        return "";
    }

    public String getFechaHora() {
        return "";
    }

}
