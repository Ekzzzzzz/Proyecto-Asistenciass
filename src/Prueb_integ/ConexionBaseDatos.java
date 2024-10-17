package Prueb_integ;

public class ConexionBaseDatos {
    private static ConexionBaseDatos instancia;

    private ConexionBaseDatos() {
        // Inicializar conexión
    }

    public static ConexionBaseDatos obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConexionBaseDatos();
        }
        return instancia;
    }

    public void conectar() {
        // Lógica de conexión a la base de datos
    }
}
