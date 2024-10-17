package Prueb_integ.Logica;

public class Estudiante implements Cloneable {
    private String id;
    private String nombre;

    public Estudiante(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public Estudiante clone() throws CloneNotSupportedException {
        return (Estudiante) super.clone();
    }
}
