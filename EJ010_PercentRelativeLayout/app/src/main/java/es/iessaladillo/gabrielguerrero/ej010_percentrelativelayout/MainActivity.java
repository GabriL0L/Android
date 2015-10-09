package es.iessaladillo.gabrielguerrero.ej010_percentrelativelayout;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView ai;
    private TextView ad;
    private TextView mi;
    private TextView md;
    private TextView abi;
    private TextView abd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initViews(){
        ai = (TextView) findViewById(R.id.arriba_izquierda);
        ad = (TextView) findViewById(R.id.arriba_derecha);
        mi = (TextView) findViewById(R.id.medio_izquierda);
        md = (TextView) findViewById(R.id.medio_derecha);
        abi = (TextView) findViewById(R.id.abajo_izquierda);
        abd = (TextView) findViewById(R.id.abajo_derecha);

        abd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ai.setBackgroundColor(Color.parseColor("#FFFFFF"));
                ad.setBackgroundColor(Color.parseColor("#FFFFFF"));
                mi.setBackgroundColor(Color.parseColor("#FFFFFF"));
                md.setBackgroundColor(Color.parseColor("#FFFFFF"));
                abi.setBackgroundColor(Color.parseColor("#FFFFFF"));
                abd.setBackgroundColor(Color.parseColor("#FFFFFF"));

                Snackbar.make(findViewById(R.id.raiz),"Se han cambiado los colores",Snackbar.LENGTH_LONG).setAction("Deshacer", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ai.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.ai));
                        ad.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.ad));
                        mi.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.mi));
                        md.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.md));
                        abi.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.abi));
                        abd.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.abd));
                    }
                }).show();
            }
        });

    }


}
