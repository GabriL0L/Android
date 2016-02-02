package es.iessaladillo.gabrielguerrero.pr029_recyclerview;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Adaptador.OnItemClickListener, Adaptador.OnItemLongClickListener{

    private static final String STATE_LISTA = "estadoLista";
    private static final String STATE_DATOS = "state_datos";

    private RecyclerView lstAlumnos;
    private Adaptador mAdaptador;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<ListItem> mDatos;
    private Parcelable mEstadoLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            mDatos = getDatos();
        }
        else {
            mDatos = savedInstanceState.getParcelableArrayList(STATE_DATOS);
            mEstadoLista = savedInstanceState.getParcelable(STATE_LISTA);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        setupRecyclerView();

    }

    private void setupRecyclerView() {
        RecyclerView lstAlumnos = (RecyclerView) findViewById(R.id.lstAlumnos);
        lstAlumnos.setHasFixedSize(true);
        mAdaptador = new Adaptador(mDatos);
        mAdaptador.setOnItemClickListener(this);
        mAdaptador.setOnItemLongClickListener(this);
        mAdaptador.setEmptyView(findViewById(R.id.lblNoHayAlumnos));
        lstAlumnos.setAdapter(mAdaptador);
        mLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        lstAlumnos.setLayoutManager(mLayoutManager);
        lstAlumnos.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mEstadoLista = mLayoutManager.onSaveInstanceState();
        outState.putParcelable(STATE_LISTA, mEstadoLista);
        outState.putParcelableArrayList(STATE_DATOS, mAdaptador.getData());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mEstadoLista != null) {
            mLayoutManager.onRestoreInstanceState(mEstadoLista);
        }
    }

    @Override
    public void onItemClick(View view, Alumno alumno, int position) {
        Toast.makeText(this, "Datos alumno: " +
                        alumno.getNombre() + " " + alumno.getCurso() + " " + alumno.getCiclo(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(View view, ListItem elemento, int position) {
        mAdaptador.removeItem(position);
    }

    private ArrayList<ListItem> getDatos() {
        ArrayList<ListItem> datos = new ArrayList<>();
        datos.add(new Grupo("CFGM Sistemas Microinformáticos y Redes"));
        datos.add(new Alumno("Baldomero", 16, "CFGM", "2º"));
        datos.add(new Alumno("Sergio", 27, "CFGM", "1º"));
        datos.add(new Alumno("Atanasio", 17, "CFGM", "1º"));
        datos.add(new Alumno("Oswaldo", 26, "CFGM", "1º"));
        datos.add(new Alumno("Rodrigo", 22, "CFGM", "2º"));
        datos.add(new Alumno("Antonio", 16, "CFGM", "1º"));
        datos.add(new Grupo("CFGS Desarrollo de Aplicaciones Multiplataforma"));
        datos.add(new Alumno("Pedro", 22, "CFGS", "2º"));
        datos.add(new Alumno("Pablo", 22, "CFGS", "2º"));
        datos.add(new Alumno("Rodolfo", 21, "CFGS", "1º"));
        datos.add(new Alumno("Gervasio", 24, "CFGS", "2º"));
        datos.add(new Alumno("Prudencia", 20, "CFGS", "2º"));
        datos.add(new Alumno("Gumersindo", 17, "CFGS", "2º"));
        datos.add(new Alumno("Gerardo", 18, "CFGS", "1º"));
        datos.add(new Alumno("Óscar", 21, "CFGS", "2º"));
        return datos;
    }
}
