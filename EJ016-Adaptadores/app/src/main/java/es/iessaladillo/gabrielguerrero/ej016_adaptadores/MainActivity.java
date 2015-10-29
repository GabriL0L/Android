package es.iessaladillo.gabrielguerrero.ej016_adaptadores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lstNombres;
    private ArrayList<String> nombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        lstNombres = (ListView) findViewById(R.id.lstNombres);
        nombres =  new ArrayList<String>();
        nombres.add("Juan");
        nombres.add("Pepe");
        nombres.add("Antonio");

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombres);
        lstNombres.setAdapter(adaptador);
        lstNombres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String nombre = (String) lstNombres.getItemAtPosition(position);
                enviar(nombre);
            }
        });

    }

    private void enviar(String nombre){
        OtraActivity.start(this,nombre);
    }

}
