package es.iessaladillo.gabrielguerrero.ej029_asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar prbBarra;
    private TextView lblMensaje;
    private ProgressBar prbCirculo;
    private Button btnIniciar;
    private final static int MAX = 10;
    private TareaSecundaria tarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        prbBarra = (ProgressBar) findViewById(R.id.prbBarra);
        lblMensaje = (TextView) findViewById(R.id.lblMensaje);
        prbCirculo = (ProgressBar) findViewById(R.id.prbCirculo);
        btnIniciar = (Button) findViewById(R.id.btnIniciar);
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciar();
            }
        });
    }

    private void iniciar(){
        btnIniciar.setEnabled(false);

        prbBarra.setVisibility(View.VISIBLE);
        lblMensaje.setText(R.string.trabajando);
        lblMensaje.setVisibility(View.VISIBLE);
        prbCirculo.setVisibility(View.VISIBLE);
        prbBarra.setMax(MAX);

        tarea = new TareaSecundaria();
        tarea.execute(MAX);

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (tarea != null) {
            tarea.cancel(true);
            tarea = null;
        }
    }

    class TareaSecundaria extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected Integer doInBackground(Integer... progreso) {
            for(int i=0; i < progreso[0]; i++){

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (isCancelled()) {
                    break;
                }

                publishProgress(i+1,progreso[0]);
            }
            return progreso[0];
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            lblMensaje.setText(getString(R.string.trabajando, values[0], values[1]));
            prbBarra.setProgress(values[0]);
        }


        @Override
        protected void onPostExecute(Integer result) {
            lblMensaje.setText(getResources().getQuantityString(
                    R.plurals.realizadas, result, result));

            //Se resetean las vistas
            prbBarra.setVisibility(View.INVISIBLE);
            prbBarra.setProgress(0);
            prbCirculo.setVisibility(View.INVISIBLE);
            prbCirculo.setProgress(0);
            btnIniciar.setEnabled(true);
        }

    }

}

