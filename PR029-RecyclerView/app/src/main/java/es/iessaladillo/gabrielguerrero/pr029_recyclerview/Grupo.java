package es.iessaladillo.gabrielguerrero.pr029_recyclerview;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Usuario on 15/01/2016.
 */
public class Grupo extends ListItem implements Parcelable {
    private String nombre;


    public Grupo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int getType() {
        return ListItem.TYPE_HEADER;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
    }

    protected Grupo(Parcel in) {
        this.nombre = in.readString();
    }

    public static final Parcelable.Creator<Grupo> CREATOR = new Parcelable.Creator<Grupo>() {
        public Grupo createFromParcel(Parcel source) {
            return new Grupo(source);
        }

        public Grupo[] newArray(int size) {
            return new Grupo[size];
        }
    };

}
