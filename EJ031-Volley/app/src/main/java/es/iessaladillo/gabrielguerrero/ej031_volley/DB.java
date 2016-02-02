package es.iessaladillo.gabrielguerrero.ej031_volley;

import java.util.ArrayList;
import java.util.List;

public class DB {
    private static ArrayList<ListItem> mDatos = new ArrayList<>();




    public static ArrayList<ListItem> getmDatos() {
        return mDatos;
    }

    public static void setmDatos(ArrayList<ListItem> mDatos) {
        DB.mDatos = mDatos;
    }


}
