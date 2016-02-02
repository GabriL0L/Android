package es.iessaladillo.gabrielguerrero.mislibrosfavoritos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class AgregarActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtAutor;
    private EditText txtFecha;
    private EditText txtURL;
    private EditText txtSinopsis;
    private ImageView imgPortada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarAgregar);
        setSupportActionBar(toolbar);

        initViews();
    }

    private void initViews() {
        txtNombre = (EditText) findViewById(R.id.txtTitulo);
        txtAutor = (EditText) findViewById(R.id.txtAutor);
        txtFecha = (EditText) findViewById(R.id.txtAnho);
        txtSinopsis = (EditText) findViewById(R.id.txtSinopsis);
        txtURL = (EditText) findViewById(R.id.txtURL);
        imgPortada = (ImageView) findViewById(R.id.imgPortada);

        txtURL.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    try{
                        Picasso.with(imgPortada.getContext()).load(txtURL.getText().toString()).into(imgPortada);
                    }catch(IllegalArgumentException e){
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_anadir, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mnuAgregar) {

            if(txtNombre.getText().toString().isEmpty() || txtSinopsis.getText().toString().isEmpty()){
                Toast.makeText(this,"Debe añadir al menos título y sinopsis.",Toast.LENGTH_SHORT).show();
            }else{
                Coleccion.anadirLibro(new Libro(txtNombre.getText().toString(),txtAutor.getText().toString(),
                        txtFecha.getText().toString(),txtURL.getText().toString(),txtSinopsis.getText().toString()));

                Toast.makeText(this,"El libro ha sido añadido a su colección.",Toast.LENGTH_SHORT).show();

                finish();
            }


            return true;

        }

        return super.onOptionsItemSelected(item);
    }

}
