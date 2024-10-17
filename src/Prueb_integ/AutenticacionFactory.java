package Prueb_integ;
public class AutenticacionFactory {
    // Método para crear instancias de autenticación basada en el tipo solicitado
    public Autenticacion crearAutenticacion(String tipo) {
        if (tipo.equalsIgnoreCase("codigo")) {
            return new CodigoAutenticacion();
        }
        // Pueden añadirse otros tipos de autenticación si es necesario en el futuro
        else {
            throw new IllegalArgumentException("Tipo de autenticación no soportado: " + tipo);
        }
    }
}
