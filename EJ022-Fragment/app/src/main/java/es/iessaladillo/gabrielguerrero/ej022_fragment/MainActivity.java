package es.iessaladillo.gabrielguerrero.ej022_fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements UnoFragment.CallBack{

    FragmentManager gestor;
    FrameLayout fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gestor = getSupportFragmentManager();
        cargarFragmento("Uno",R.id.flHueco);
        initViews();
    }

    private void initViews() {
        fl = (FrameLayout) findViewById(R.id.flHuecoSecundario);
        Button btnCambiar = (Button) findViewById(R.id.btnCambiar);

        btnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fl == null){
                    SecundariaActivity.start(MainActivity.this,"Mensaje");
                }else{
                    cargarFragmento("Dos",R.id.flHuecoSecundario);
                }
            }
        });
    }


    private void cargarFragmento(String mensaje, int idHueco) {
        FragmentTransaction transaccion = gestor.beginTransaction();
        transaccion.replace(idHueco, UnoFragment.newInstance(mensaje));
        transaccion.commit();
    }


    @Override
    public void pulsado(String mensaje) {
        if(fl == null){
            SecundariaActivity.start(MainActivity.this,mensaje);
        }else{
            cargarFragmento(mensaje,R.id.flHuecoSecundario);
        }
    }
}
