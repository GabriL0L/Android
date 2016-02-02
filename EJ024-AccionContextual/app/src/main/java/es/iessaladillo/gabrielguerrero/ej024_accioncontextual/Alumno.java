package es.iessaladillo.gabrielguerrero.ej024_accioncontextual;

/**
 * Created by Usuario on 29/10/2015.
 */
public class Alumno {
    private String nombre;
    private String edad;
    private String telefono;

    public Alumno(String nombre, String edad,String telefono){
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEdad() {
        return edad;
    }

    public String getTelefono() {
        return telefono;
    }
}
