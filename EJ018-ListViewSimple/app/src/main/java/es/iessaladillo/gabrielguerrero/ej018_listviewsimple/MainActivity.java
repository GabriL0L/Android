package es.iessaladillo.gabrielguerrero.ej018_listviewsimple;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private ImageButton btnAgregar;
    private ListView lstAlumnos;
    private Parcelable mEstadoLista;
    private ArrayList<String> alumnos;
    private ArrayAdapter<String> adaptador;
    private static final String STATE_LISTA = "estadoLista";
    private static final String STATE_DATOS = "estadoDatos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null)
            alumnos = new ArrayList<String>();
        else
            alumnos = savedInstanceState.getStringArrayList(STATE_DATOS);
        initViews();
    }

    private void initViews(){
        lstAlumnos = (ListView) findViewById(R.id.lstAlumnos);
        lstAlumnos.setEmptyView(findViewById(R.id.lblNoHayAlumnos));
        btnAgregar = (ImageButton) findViewById(R.id.btnAgregar);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String nombre = txtNombre.getText().toString();
                    if (!TextUtils.isEmpty(nombre)) {
                        adaptador.add(nombre);
                        txtNombre.setText("");
                        comprobarDatos(txtNombre.getText().toString());
                }
            }
        });

        txtNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                comprobarDatos(editable.toString());
            }
        });

        /*comprobarDatos(txtNombre.getText().toString());
        txtNombre.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String nombre = txtNombre.getText().toString();
                    if (!TextUtils.isEmpty(nombre)) {
                        agregarAlumno(nombre);
                        return true;
                    }
                }
                return false;
            }
        });*/

        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alumnos);
        lstAlumnos.setAdapter(adaptador);
        lstAlumnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String nombre = (String) lstAlumnos.getItemAtPosition(position);
                enviar(nombre);
            }
        });
        lstAlumnos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                adaptador.remove((String) lstAlumnos.getItemAtPosition(position));
                return true;
            }
        });

    }

    private void comprobarDatos(String nombre){
        btnAgregar.setEnabled(!TextUtils.isEmpty(nombre));
    }

    private void enviar(String nombre){
        OtraActivity.start(this,nombre);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Se salva el estado del ListView.
        mEstadoLista = lstAlumnos.onSaveInstanceState();
        outState.putParcelable(STATE_LISTA, mEstadoLista);
        outState.putStringArrayList(STATE_DATOS, alumnos);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Se obtiene el estado anterior de la lista.
        mEstadoLista = savedInstanceState.getParcelable(STATE_LISTA);
        alumnos = savedInstanceState.getStringArrayList(STATE_DATOS);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Se retaura el estado de la lista.
        if (mEstadoLista != null) {
            lstAlumnos.onRestoreInstanceState(mEstadoLista);
        }
    }

}
