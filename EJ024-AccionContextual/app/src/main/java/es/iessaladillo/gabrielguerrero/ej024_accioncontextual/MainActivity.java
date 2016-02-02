package es.iessaladillo.gabrielguerrero.ej024_accioncontextual;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String STATE_LISTA = "ESTADO_LISTA";
    private static final String STATE_DATOS = "ESTADO_DATOS";
    private ListView lstAlumnos;
    private ArrayList<Alumno> alumnos;
    private MiAdaptador adaptador;
    private Parcelable mEstadoLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            alumnos =  createAlumnos();
        }else{
            mEstadoLista = savedInstanceState.getParcelable(STATE_LISTA);
            alumnos = (ArrayList<Alumno>) savedInstanceState.getSerializable(STATE_DATOS);
        }

        initViews();
    }

    private void initViews() {
        lstAlumnos = (ListView) findViewById(R.id.lstAlumnos);
        lstAlumnos.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        adaptador = new MiAdaptador(getApplicationContext(),alumnos);
        lstAlumnos.setAdapter(adaptador);

        lstAlumnos.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int i, long l, boolean b) {
                mode.setTitle(lstAlumnos.getCheckedItemCount() + " de " + lstAlumnos.getCount());
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.alumnos_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mnuAprobar:
                        String mensaje = "";
                        ArrayList<Alumno> alumnosAprobar = getElementosSeleccionados(lstAlumnos, false);

                        for (Alumno alumno : alumnosAprobar) {
                            mensaje += alumno.getNombre() + " ";
                        }

                        mensaje = "Han aprobado: " + mensaje;
                        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
                        break;
                    case R.id.mnuEliminar:
                        ArrayList<Alumno> alumnosEliminar = getElementosSeleccionados(lstAlumnos, true);

                        for (Alumno alumno : alumnosEliminar) {
                            adaptador.remove(alumno);
                        }

                        adaptador.notifyDataSetChanged();
                        Toast.makeText(getApplicationContext(), alumnosEliminar.size() + " alumnos eliminados.", Toast.LENGTH_LONG).show();
                        break;
                }

                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {

            }
        });

    }

    private ArrayList<Alumno> createAlumnos(){
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

        alumnos.add(new Alumno("Baldomero", "27", "652215318"));
        alumnos.add(new Alumno("Antonio","15","623327845"));
        alumnos.add(new Alumno("Juan", "24", "658794122"));
        alumnos.add(new Alumno("Pepito", "18", "611211311"));

        return alumnos;
    }

    private ArrayList<Alumno> getElementosSeleccionados(ListView lst, boolean uncheck) {

        ArrayList<Alumno> datos = new ArrayList<>();
        SparseBooleanArray selec = lst.getCheckedItemPositions();

        for (int i = 0; i < selec.size(); i++) {

            if (selec.valueAt(i)) {
                int position = selec.keyAt(i);

                if (uncheck) {
                    lst.setItemChecked(position, false);
                }

                datos.add((Alumno) lst.getItemAtPosition(selec.keyAt(i)));
            }
        }

        return datos;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        mEstadoLista = lstAlumnos.onSaveInstanceState();
        outState.putParcelable(STATE_LISTA,mEstadoLista);
        outState.putSerializable(STATE_DATOS,alumnos);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mEstadoLista != null){
            lstAlumnos.onRestoreInstanceState(mEstadoLista);
        }
    }
}
