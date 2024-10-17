package Prueb_integ;
import java.util.HashMap;
import java.util.Map;

public class CodigoAutenticacion extends Autenticacion {
    private Map<String, String> registroCodigos;  // Mapa que simula el almacenamiento de códigos asignados

    public CodigoAutenticacion() {
        registroCodigos = new HashMap<>();
    }

    // Método para generar y registrar un código de autenticación para un estudiante
    public String generarCodigo(String estudianteId) {
        String codigo = "CODE-" + estudianteId + "-" + System.currentTimeMillis();
        registroCodigos.put(codigo, estudianteId);
        System.out.println("Código generado para el estudiante ID: " + estudianteId);
        return codigo;
    }

    // Implementación del método de autenticación basado en código
    @Override
    public boolean autenticar(String codigo) {
        if (registroCodigos.containsKey(codigo)) {
            String estudianteId = registroCodigos.get(codigo);
            System.out.println("Código válido. Estudiante ID: " + estudianteId + " autenticado exitosamente.");
            return true;
        } else {
            System.out.println("Código inválido.");
            return false;
        }
    }
}
