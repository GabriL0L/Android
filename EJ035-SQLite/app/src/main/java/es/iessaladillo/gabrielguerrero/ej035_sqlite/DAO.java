package es.iessaladillo.gabrielguerrero.ej035_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuario on 01/02/2016.
 */

public class DAO {

    private final InstitutoSQLiteHelper mHelper;
    private static DAO mInstance;
    public static DAO getInstance(Context contexto){

        if(mInstance == null)
            mInstance = new DAO(contexto);

        return mInstance;
    }

    public DAO(Context contexto) {
        mHelper = new InstitutoSQLiteHelper(contexto);
    }

    public SQLiteDatabase openWritableDatabase() {
        return mHelper.getWritableDatabase();
    }

    public void closeDatabase() {
        mHelper.close();
    }

    public long createAlumno(Alumno alumno) {
        SQLiteDatabase bd = mHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Instituto.Alumno.NOMBRE, alumno.getNombre());
        valores.put(Instituto.Alumno.EDAD, alumno.getEdad());
        valores.put(Instituto.Alumno.FOTO, alumno.getFoto());
        valores.put(Instituto.Alumno.REPETIDOR, alumno.isRepetidor());
        valores.put(Instituto.Alumno.CURSO, alumno.getCurso());
        valores.put(Instituto.Alumno.TELEFONO, alumno.getTelefono());
        valores.put(Instituto.Alumno.DIRECCION, alumno.getDireccion());

        long resultado = bd.insert(Instituto.Alumno.TABLA, null, valores);

        mHelper.close();

        return resultado;
    }


    public boolean deleteAlumno(long id) {
        SQLiteDatabase bd = mHelper.getWritableDatabase();

        long resultado = bd.delete(Instituto.Alumno.TABLA, Instituto.Alumno._ID + " = "
                + id, null);

        mHelper.close();

        return resultado > 0;
    }

    public boolean updateAlumno(Alumno alumno) {
        SQLiteDatabase bd = mHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Instituto.Alumno.NOMBRE, alumno.getNombre());
        valores.put(Instituto.Alumno.EDAD, alumno.getEdad());
        valores.put(Instituto.Alumno.FOTO, alumno.getFoto());
        valores.put(Instituto.Alumno.REPETIDOR, alumno.isRepetidor());
        valores.put(Instituto.Alumno.CURSO, alumno.getCurso());
        valores.put(Instituto.Alumno.TELEFONO, alumno.getTelefono());
        valores.put(Instituto.Alumno.DIRECCION, alumno.getDireccion());

        long resultado = bd.update(Instituto.Alumno.TABLA, valores, Instituto.Alumno._ID
                + " = " + alumno.getId(), null);

        mHelper.close();

        return resultado > 0;

    }

    public List<Alumno> getAllAlumnos() {
        SQLiteDatabase bd = mHelper.getWritableDatabase();
        List<Alumno> lista = new ArrayList<>();

        Cursor cursor = this.queryAllAlumnos(bd);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Alumno alumno = cursorToAlumno(cursor);
            lista.add(alumno);
            cursor.moveToNext();
        }

        cursor.close();
        mHelper.close();

        return lista;
    }

    public Cursor queryAllAlumnos(SQLiteDatabase bd) {
        return  bd.query(Instituto.Alumno.TABLA, Instituto.Alumno.TODOS, null,
                null, null, null, Instituto.Alumno.NOMBRE);
    }

    public Alumno cursorToAlumno(Cursor cursorAlumno) {
        Alumno alumno = new Alumno();

        alumno.setId(cursorAlumno.getInt(
                cursorAlumno.getColumnIndexOrThrow(Instituto.Alumno._ID)));
        alumno.setNombre(cursorAlumno.getString(
                cursorAlumno.getColumnIndexOrThrow(Instituto.Alumno.NOMBRE)));
        alumno.setId(cursorAlumno.getInt(
                cursorAlumno.getColumnIndexOrThrow(Instituto.Alumno.EDAD)));
        alumno.setCurso(cursorAlumno.getString(
                cursorAlumno.getColumnIndexOrThrow(Instituto.Alumno.FOTO)));
        alumno.setCurso(cursorAlumno.getString(
                cursorAlumno.getColumnIndexOrThrow(Instituto.Alumno.REPETIDOR)));
        alumno.setCurso(cursorAlumno.getString(
                cursorAlumno.getColumnIndexOrThrow(Instituto.Alumno.CURSO)));
        alumno.setTelefono(cursorAlumno.getString(
                cursorAlumno.getColumnIndexOrThrow(Instituto.Alumno.TELEFONO)));
        alumno.setDireccion(cursorAlumno.getString(
                cursorAlumno.getColumnIndexOrThrow(Instituto.Alumno.DIRECCION)));

        return alumno;
    }

}
