package es.iessaladillo.gabrielguerrero.ej032_retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Instituto.InstitutoInterface servicio;
    private TextView txtHola;
    private Call<List<Alumno>> llamada;
    private Call<Alumno> llamadaAnadir;
    private Button btnAnadir;
    private Button btnEliminar;
    private int idEliminar;
    private Call<Alumno> llamadaEliminar;
    private Button btnModificar;
    private Call<Alumno> llamadaModificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHola = (TextView) findViewById(R.id.txtHola);
        btnAnadir = (Button) findViewById(R.id.btnAnadir);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnModificar = (Button) findViewById(R.id.btnModificar);

        servicio = Instituto.getServicio();
        llamada = servicio.listarAlumnos();
        llamada.enqueue(new Callback<List<Alumno>>() {
            @Override
            public void onResponse(Response<List<Alumno>> response) {
                List<Alumno> lista = response.body();

                txtHola.setText(lista.get(0).getNombre());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        btnAnadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llamadaAnadir = servicio.agregarAlumno(new Alumno(false, 25, "Calle Pokémon Nº 123", "625523321", "2º Bachillerato", "Juan"));
                llamadaAnadir.enqueue(new Callback<Alumno>() {
                    @Override
                    public void onResponse(Response<Alumno> response) {
                        Alumno alumno = response.body();
                        idEliminar = alumno.getId();
                        txtHola.setText(String.valueOf(idEliminar));
                        Toast.makeText(getApplicationContext(), alumno.getNombre() + " ha sido añadido", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llamadaEliminar = servicio.eliminarAlumno(idEliminar);
                llamadaEliminar.enqueue(new Callback<Alumno>() {
                    @Override
                    public void onResponse(Response<Alumno> response) {
                        Toast.makeText(getApplicationContext(),"El alumno ha sido eliminado",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });
            }
        });

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llamadaModificar = servicio.updateAlumno(idEliminar,new Alumno(false, 15, "Calle Falsa Nº 123", "655555555", "3º ESO", "Pepe"));
                llamadaModificar.enqueue(new Callback<Alumno>() {
                    @Override
                    public void onResponse(Response<Alumno> response) {
                        Toast.makeText(getApplicationContext(),"El alumno número " + idEliminar + " ha sido modificado",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });
            }
        });

    }
}
