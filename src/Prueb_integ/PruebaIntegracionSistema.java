package Prueb_integ;
public class PruebaIntegracionSistema {
    public static void main(String[] args) {
        // Crear el sistema con autenticación basada en código
        SistemaAsistenciaFacade sistemaAsistencia = new SistemaAsistenciaFacade("codigo");

        // Generar un código para el estudiante
        CodigoAutenticacion codigoAutenticacion = (CodigoAutenticacion) sistemaAsistencia.autenticacion;
        String codigo = codigoAutenticacion.generarCodigo("12345");

        // Registrar asistencia usando el código
        sistemaAsistencia.registrarAsistencia(codigo);

        // Generar reporte
        sistemaAsistencia.generarReporte();

        // Enviar notificación
        sistemaAsistencia.enviarNotificacion("12345");
    }
}

