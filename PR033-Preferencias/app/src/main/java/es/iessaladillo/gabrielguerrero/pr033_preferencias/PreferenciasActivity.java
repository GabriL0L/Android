package es.iessaladillo.gabrielguerrero.pr033_preferencias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PreferenciasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Se muestra el fragmento de preferencias en la actividad.
        getFragmentManager().beginTransaction() .replace(android.R.id.content, new PreferenciasFragment()).commit();
    }
}
