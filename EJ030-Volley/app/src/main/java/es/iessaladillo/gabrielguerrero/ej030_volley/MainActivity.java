package es.iessaladillo.gabrielguerrero.ej030_volley;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String URL_DATOS = "https://dl.dropboxusercontent.com/u/67422/Android/json/datos.json";
    private static final String KEY_NOMBRE = "nombre";
    private static final String KEY_FECHA = "fecha";
    private final String NOMBRE = "Baldomero";
    private Button btnBuscar;
    private TextView lblBuscar;
    private TareaSecundaria tarea;
    private TareaEco tareaEco;
    private Button btnEco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBuscar = (Button) findViewById(R.id.btnBuscar);
        lblBuscar = (TextView) findViewById(R.id.lblBuscar);
        btnEco = (Button) findViewById(R.id.btnEco);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(isConnectionAvailable()) {
                       buscar();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnEco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isConnectionAvailable()){
                    subir();
                }
            }
        });

    }

    private boolean isConnectionAvailable() {
        ConnectivityManager gestorConectividad = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo infoRed = gestorConectividad.getActiveNetworkInfo();

        return (infoRed != null && infoRed.isConnected());
    }

    private void buscar(){

        tarea = new TareaSecundaria();
        tarea.execute();

    }

    private void subir(){
        tareaEco = new TareaEco();
        tareaEco.execute("Baldomero");
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (tarea != null) {
            tarea.cancel(true);
            tarea = null;
        }
    }

    class TareaSecundaria extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            String contenido = "";
            HttpURLConnection conexion = null;
            try {

                URL url = new URL(URL_DATOS);
                conexion = (HttpURLConnection) url.openConnection();

                conexion.setReadTimeout(10000);
                conexion.setConnectTimeout(15000);
                conexion.setRequestMethod("GET");
                conexion.setDoInput(true);
                conexion.connect();

                if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {

                    BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));

                    String linea = lector.readLine();
                    while (linea != null) {
                        contenido += linea;
                        linea = lector.readLine();
                    }
                    lector.close();
                }

                return contenido;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (conexion != null) {
                    conexion.disconnect();
                }
            }

            return contenido;
        }


        @Override
        protected void onPostExecute(String result) {
            lblBuscar.setText(result);
        }

    }

    class TareaEco extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            String resultado = "";
            String nombre = strings[0];

            try {
                URL url = new URL("http://www.informaticasaladillo.es/echo.php");
                HttpURLConnection conexion = (HttpURLConnection) url.openConnection();

                conexion.setRequestMethod("POST");
                conexion.setDoOutput(true);
                conexion.setDoInput(true);

                PrintWriter escritor = new PrintWriter(conexion.getOutputStream());

                escritor.write(KEY_NOMBRE + "=" + URLEncoder.encode(nombre, "UTF-8"));
                escritor.write("&"+ KEY_FECHA + "="+ URLEncoder.encode(String.valueOf(new Date()), "UTF-8"));
                escritor.flush();
                escritor.close();

                if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    BufferedReader lector = new BufferedReader( new InputStreamReader(conexion.getInputStream()));
                    String linea = lector.readLine();
                    while (linea != null) {
                        resultado += linea;
                        linea = lector.readLine();
                    }
                    lector.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return resultado;
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
        }

    }
}
