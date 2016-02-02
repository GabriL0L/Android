package es.iessaladillo.gabrielguerrero.ej031_volley;

/**
 * Created by Usuario on 22/01/2016.
 */

import android.os.Parcelable;


public abstract class ListItem implements Parcelable {
    static final int TYPE_HEADER=0;
    static final int TYPE_CHILD=1;

    public abstract int getType();
}