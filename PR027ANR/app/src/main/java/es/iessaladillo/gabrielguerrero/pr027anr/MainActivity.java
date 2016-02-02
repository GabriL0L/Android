package es.iessaladillo.gabrielguerrero.pr027anr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button btnPulsar;
    private Thread hiloSecundario;
    private TextView lblReloj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        btnPulsar = (Button) findViewById(R.id.btnPulsar);
        lblReloj = (TextView) findViewById(R.id.lblReloj);

        btnPulsar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnPulsar.getText().toString().equals("INICIAR")) {
                    iniciarReloj();
                } else {
                    pararReloj();
                }
            }
        });

    }

    private void pararReloj() {
        hiloSecundario.interrupt();
        btnPulsar.setText("INICIAR");
    }

    private void iniciarReloj() {
        hiloSecundario = new Thread(new Reloj());
        hiloSecundario.start();
        btnPulsar.setText("PARAR");
    }

    private class Reloj implements Runnable {
        final SimpleDateFormat formateador = new SimpleDateFormat("HH:mm:ss");

        @Override
        public void run() {
            while (true) {
                final String cadena = formateador.format(new Date());
                lblReloj.post(new Runnable() {

                    @Override
                    public void run() {
                        lblReloj.setText(cadena);
                    }

                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }

        }
    }
}
