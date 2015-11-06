package es.iessaladillo.gabrielguerrero.ej021_popupmenu;

/**
 * Created by Usuario on 06/11/2015.
 */
public class Alumno {
    private String nombre;
    private String curso;
    private String telefono;
    private String direccion;

    public Alumno(String nombre, String curso,String telefono,String direccion){
        this.nombre = nombre;
        this.curso = curso;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCurso() {
        return curso;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }
}
