package es.iessaladillo.gabrielguerrero.pr031_swiperefresh;

import android.os.Parcelable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final long MILISEGUNDOS_ESPERA = 2000;
    private static final String STATE_DATOS = "state_datos";
    private static final String STATE_LISTA = "state_lista";
    private SwipeRefreshLayout swlPanel;
    private final SimpleDateFormat mFormateador = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
    private RecyclerView lstLista;
    private Parcelable mEstadoLista;
    private ArrayList<String> mDatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
