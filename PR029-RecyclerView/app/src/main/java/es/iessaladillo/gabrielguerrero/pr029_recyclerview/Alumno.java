package es.iessaladillo.gabrielguerrero.pr029_recyclerview;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Usuario on 14/01/2016.
 */
public class Alumno extends ListItem implements Parcelable {

    private final String nombre;
    private final int edad;
    private final String ciclo;
    private final String curso;


    public Alumno(String nombre, int edad, String ciclo, String curso) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciclo = ciclo;
        this.curso = curso;
    }


    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCiclo() {
        return ciclo;
    }

    public String getCurso() {
        return curso;
    }

    @Override
    public int getType() {
        return ListItem.TYPE_CHILD;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeInt(this.edad);
        dest.writeString(this.ciclo);
        dest.writeString(this.curso);
    }

    protected Alumno(Parcel in) {
        this.nombre = in.readString();
        this.edad = in.readInt();
        this.ciclo = in.readString();
        this.curso = in.readString();
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
