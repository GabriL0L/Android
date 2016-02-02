package es.iessaladillo.gabrielguerrero.mislibrosfavoritos;

/**
 * Created by Usuario on 11/12/2015.
 */
public class Libro {

    private String nombre;
    private String autor;
    private String anho;
    private String URL;
    private String sinopsis;

    public Libro(String nombre, String autor, String anho, String URL, String sinopsis) {
        this.nombre = nombre;
        this.autor = autor;
        this.anho = anho;
        this.URL = URL;
        this.sinopsis = sinopsis;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}
