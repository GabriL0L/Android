package es.iessaladillo.gabrielguerrero.ej022_fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Usuario on 12/11/2015.
 */
public class SecundariaActivity extends AppCompatActivity implements UnoFragment.CallBack{

    private static final String MENSAJE = "MENSAJE";
    FragmentManager gestor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        gestor = getSupportFragmentManager();
        Intent intent = getIntent();
        String mensaje = intent.getStringExtra(MENSAJE);
        cargarFragmento(mensaje);
    }

    public static void start(Context context,String mensaje){
        Intent intent = new Intent(context,SecundariaActivity.class);
        intent.putExtra(MENSAJE,mensaje);
        context.startActivity(intent);
    }

    private void cargarFragmento(String mensaje) {
        FragmentTransaction transaccion = gestor.beginTransaction();
        transaccion.replace(R.id.flHuecoSecundario, UnoFragment.newInstance(mensaje));
        transaccion.commit();
    }

    @Override
    public void pulsado(String mensaje) {
        Toast.makeText(getApplicationContext(),"Para de darle al botoncico,tonto",Toast.LENGTH_SHORT).show();
    }
}
