package es.iessaladillo.gabrielguerrero.ej019_listviewseleccion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private Button btnComprobar;
    private ListView lstRespuestas;
    private ImageView img;
    private ArrayAdapter mAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        btnComprobar = (Button) findViewById(R.id.btnComprobar);
        lstRespuestas = (ListView) findViewById(R.id.lstRespuestas);
        img = (ImageView) findViewById(R.id.img);
        String[] respuestas = getResources().getStringArray(R.array.respuestas);

        Picasso.with(this).load("http://lorempixel.com/100/100/nature").into(img);
        mAdaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, respuestas);

        lstRespuestas.setAdapter(mAdaptador);
        lstRespuestas.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        lstRespuestas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                btnComprobar.setEnabled(true);
            }
        });

        btnComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.equals((String) lstRespuestas.getItemAtPosition(lstRespuestas.getCheckedItemPosition()), "2")){
                    Toast.makeText(getApplicationContext(),"Respuesta correcta",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Respuesta incorrecta",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflador = getMenuInflater();
        inflador.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
}
