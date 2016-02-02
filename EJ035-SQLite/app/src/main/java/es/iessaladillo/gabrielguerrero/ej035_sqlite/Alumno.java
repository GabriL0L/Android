package es.iessaladillo.gabrielguerrero.ej035_sqlite;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Usuario on 01/02/2016.
 */
public class Alumno implements Parcelable {

    private int id;
    private String nombre;
    private int edad;
    private String foto;
    private boolean repetidor;
    private String curso;
    private String telefono;
    private String direccion;

    public Alumno(int id,String nombre,int edad,String foto,boolean repetidor,String curso,String telefono,String direccion){
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.foto = foto;
        this.repetidor = repetidor;
        this.curso = curso;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Alumno(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isRepetidor() {
        return repetidor;
    }

    public void setRepetidor(boolean repetidor) {
        this.repetidor = repetidor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.nombre);
        dest.writeInt(this.edad);
        dest.writeString(this.foto);
        dest.writeByte(repetidor ? (byte) 1 : (byte) 0);
        dest.writeString(this.curso);
        dest.writeString(this.telefono);
        dest.writeString(this.direccion);
    }

    protected Alumno(Parcel in) {
        this.id = in.readInt();
        this.nombre = in.readString();
        this.edad = in.readInt();
        this.foto = in.readString();
        this.repetidor = in.readByte() != 0;
        this.curso = in.readString();
        this.telefono = in.readString();
        this.direccion = in.readString();
    }

    public static final Parcelable.Creator<Alumno> CREATOR = new Parcelable.Creator<Alumno>() {
        public Alumno createFromParcel(Parcel source) {
            return new Alumno(source);
        }

        public Alumno[] newArray(int size) {
            return new Alumno[size];
        }
    };
}