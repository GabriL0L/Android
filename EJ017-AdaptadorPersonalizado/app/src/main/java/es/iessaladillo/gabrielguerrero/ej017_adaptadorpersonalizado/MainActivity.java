package es.iessaladillo.gabrielguerrero.ej017_adaptadorpersonalizado;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lstAlumnos;
    private ArrayList<Alumno> alumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        Alumno[] arrayAlumnos;
        lstAlumnos = (ListView) findViewById(R.id.lstAlumnos);
        alumnos =  createAlumnos();

        MiAdaptador adaptador = new MiAdaptador(getApplicationContext(),alumnos);
        lstAlumnos.setAdapter(adaptador);
        lstAlumnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Alumno alumno = (Alumno) lstAlumnos.getItemAtPosition(position);
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)" + alumno.getTelefono()));

                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "No se puede llamar", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private ArrayList<Alumno> createAlumnos(){
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

        alumnos.add(new Alumno("Baldomero","27","652215318"));
        alumnos.add(new Alumno("Antonio","15","623327845"));
        alumnos.add(new Alumno("Juan","24","658794122"));
        alumnos.add(new Alumno("Pepito","18","611211311"));
        alumnos.add(new Alumno("Baldomero","27","652215318"));
        alumnos.add(new Alumno("Antonio","15","623327845"));
        alumnos.add(new Alumno("Juan","24","658794122"));
        alumnos.add(new Alumno("Pepito","18","611211311"));
        alumnos.add(new Alumno("Baldomero","27","652215318"));
        alumnos.add(new Alumno("Antonio","15","623327845"));
        alumnos.add(new Alumno("Juan","24","658794122"));
        alumnos.add(new Alumno("Pepito","18","611211311"));
        alumnos.add(new Alumno("Baldomero","27","652215318"));
        alumnos.add(new Alumno("Antonio","15","623327845"));
        alumnos.add(new Alumno("Juan","24","658794122"));
        alumnos.add(new Alumno("Pepito","18","611211311"));
        alumnos.add(new Alumno("Baldomero","27","652215318"));
        alumnos.add(new Alumno("Antonio","15","623327845"));
        alumnos.add(new Alumno("Juan","24","658794122"));
        alumnos.add(new Alumno("Pepito","18","611211311"));

        return alumnos;
    }

}
