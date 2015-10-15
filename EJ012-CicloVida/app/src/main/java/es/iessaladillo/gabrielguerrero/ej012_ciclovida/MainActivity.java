package es.iessaladillo.gabrielguerrero.ej012_ciclovida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String STATE_CONTADOR = "estado_contador";
    private Button btnIncrementar;
    private TextView lblContador;
    private int mContador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null)
            mContador = savedInstanceState.getInt(STATE_CONTADOR);

        initViews();
    }

    private void initViews() {
        btnIncrementar = (Button) findViewById(R.id.btnIncrementar);
        lblContador = (TextView) findViewById(R.id.lblContador);

        lblContador.setText(String.valueOf(mContador));

        btnIncrementar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContador++;
                lblContador.setText(String.valueOf(mContador));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_CONTADOR,mContador);
    }

}
