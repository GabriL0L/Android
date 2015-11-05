package es.iessaladillo.gabrielguerrero.ej020_menusimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        txtNombre = (EditText) findViewById(R.id.txtNombre);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id){
            case R.id.aprobar:
                Toast.makeText(getApplicationContext(), txtNombre.getText().toString() + " ha sido aprobado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.suspender:
                Toast.makeText(getApplicationContext(), txtNombre.getText().toString() + " ha sido suspendido", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem aprobar = menu.findItem(R.id.aprobar);
        MenuItem suspender = menu.findItem(R.id.suspender);
        String nombre = txtNombre.getText().toString();

        aprobar.setTitle(getString(R.string.frase_aprobado,nombre));
        suspender.setTitle(getString(R.string.frase_suspenso,nombre));

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onResume() {
        invalidateOptionsMenu();
        super.onResume();
    }
}
