package es.iessaladillo.gabrielguerrero.mislibrosfavoritos;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AceptarCancelarFragment.MiDialogListener{

    private ListView lstLibros;
    private CardView cvSinopsis;
    private TextView lblNombre;
    private TextView lblSinopsis;
    private ImageView btnCerrar;
    private LibrosAdapter adapter;
    private ArrayList<Libro> libros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        libros = Coleccion.obtenerColeccion();

        adapter = new LibrosAdapter(this,libros);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    private void initViews() {
        lstLibros = (ListView) findViewById(R.id.lstLibros);
        cvSinopsis = (CardView) findViewById(R.id.cvSinopsis);
        lblNombre = (TextView) findViewById(R.id.lblNombre);
        lblSinopsis = (TextView) findViewById(R.id.lblSinopsis);
        btnCerrar = (ImageView) findViewById(R.id.btnCerrar);

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cvSinopsis.setVisibility(View.INVISIBLE);
            }
        });

        lstLibros.setAdapter(adapter);
        lstLibros.setEmptyView((TextView) findViewById(R.id.lblNoHayLibros));

        lstLibros.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);

        lstLibros.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {
                actionMode.setTitle(lstLibros.getCheckedItemCount() + " de " + lstLibros.getCount());
            }

            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                actionMode.getMenuInflater().inflate(R.menu.menu_eliminar, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.mnuEliminar:
                        DialogFragment frgMiDialogo = new AceptarCancelarFragment();
                        frgMiDialogo.show(getSupportFragmentManager(), "AceptarCancelarFragment");
                        break;
                }

                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {

            }
        });

        lstLibros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Libro libro = libros.get(i);
                cvSinopsis.setVisibility(View.VISIBLE);
                lblNombre.setText(libro.getNombre());
                lblSinopsis.setText(libro.getSinopsis());
            }
        });


    }


    private ArrayList<Libro> getElementosSeleccionados(ListView lst, boolean uncheck) {

        ArrayList<Libro> datos = new ArrayList<>();
        SparseBooleanArray selec = lst.getCheckedItemPositions();

        for (int i = 0; i < selec.size(); i++) {

            if (selec.valueAt(i)) {
                int position = selec.keyAt(i);

                if (uncheck) {
                    lst.setItemChecked(position, false);
                }

                datos.add((Libro) lst.getItemAtPosition(selec.keyAt(i)));
            }
        }

        return datos;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mnuNuevo) {
            startActivity(new Intent(this,AgregarActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onEliminarButtonClick(DialogFragment dialog) {
        ArrayList<Libro> librosEliminar = getElementosSeleccionados(lstLibros, true);

        for (Libro libro : librosEliminar) {
            Coleccion.borrarLibro(libro);
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onCancelarButtonClick(DialogFragment dialog) {
        Toast.makeText(this,"Los libros no han sido eliminados",Toast.LENGTH_SHORT).show();
    }

    //Adaptador del ListView dentro de MainActivity
    class LibrosAdapter extends ArrayAdapter<Libro> {

        private final ArrayList<Libro> libros;
        private final LayoutInflater inflador;

        public LibrosAdapter(Context contexto, ArrayList<Libro> libros) {
            super(contexto, R.layout.fila, libros);
            this.libros = libros;
            inflador = LayoutInflater.from(contexto);
        }

        //Para comprobar si se recicla la vista
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if (convertView == null) {
                convertView = inflador.inflate(R.layout.fila, parent, false);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            }

            else {
                holder = (ViewHolder) convertView.getTag();
            }

            onBindViewHolder(holder, position);

            return convertView;
        }


        private void onBindViewHolder(ViewHolder holder, int position) {
            Libro libro = libros.get(position);
            holder.bind(libro);
        }


         class ViewHolder {

            private final ImageView imgLibro;
            private final TextView lblNombre;
            private final TextView lblAutor;
            private final TextView lblAnho;

            public ViewHolder(View itemView) {

                imgLibro = (ImageView) itemView.findViewById(R.id.imgLibro);
                lblNombre = (TextView) itemView.findViewById(R.id.lblNombre);
                lblAutor = (TextView) itemView.findViewById(R.id.lblAutor);
                lblAnho = (TextView) itemView.findViewById(R.id.lblAnho);

            }

             public void bind(Libro libro) {
                 try {
                     Picasso.with(imgLibro.getContext()).load(libro.getURL()).into(imgLibro);
                }catch(IllegalArgumentException e){
                    imgLibro.setImageResource(R.drawable.ic_eliminar);
                    e.printStackTrace();
                }
                lblNombre.setText(libro.getNombre());
                lblAutor.setText(libro.getAutor());
                lblAnho.setText(libro.getAnho());
            }
        }

    }

}
