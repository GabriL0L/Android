package es.iessaladillo.gabrielguerrero.ej035_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Usuario on 01/02/2016.
 */
public class InstitutoSQLiteHelper extends SQLiteOpenHelper{

    private static final String SQL_CREATE_ALUMNOS =
            "CREATE TABLE " + Instituto.Alumno.TABLA + " (" +
                    Instituto.Alumno._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Instituto.Alumno.NOMBRE + " TEXT, " +
                    Instituto.Alumno.EDAD + " INTEGER, " +
                    Instituto.Alumno.FOTO + " TEXT, " +
                    Instituto.Alumno.REPETIDOR + " INTEGER, " +
                    Instituto.Alumno.CURSO + " TEXT, " +
                    Instituto.Alumno.TELEFONO + " TEXT, " +
                    Instituto.Alumno.DIRECCION + " TEXT" +
                    " )";

    public InstitutoSQLiteHelper(Context contexto, String nombreBD,
                                 SQLiteDatabase.CursorFactory factory, int versionBD) {

        super(contexto, nombreBD, factory, versionBD);
    }

    public InstitutoSQLiteHelper(Context contexto){
        super(contexto,Instituto.BD_NOMBRE,null,Instituto.BD_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ALUMNOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + Instituto.Alumno.TABLA);
        db.execSQL(SQL_CREATE_ALUMNOS);
    }
}
