package es.iessaladillo.gabrielguerrero.ej021_popupmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lstAlumnos;
    private List<Alumno> alumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        Alumno[] arrayAlumnos;
        lstAlumnos = (ListView) findViewById(R.id.lstAlumnos);
        alumnos =  new ArrayList<Alumno>();
        alumnos.add(new Alumno("Baldomero","2º CFGS","658956123","C/Falsa 123"));
        alumnos.add(new Alumno("Germán Ginés","1º CFGM","651247893","C/ Falsa 124"));
        alumnos.add(new Alumno("Pepe","1º CFGS","652315897","C/ Falsa 125"));
        alumnos.add(new Alumno("Paco","2º CFGM","633121221","C/ Falsa 126"));

        AlumnosAdapter adaptador = new AlumnosAdapter(getApplicationContext(),alumnos);
        lstAlumnos.setAdapter(adaptador);
    }


}
