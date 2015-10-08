package com.example.gabriel.pr011_snackbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button toastDinamico;
    private Button layoutPropio;
    private Button cambiarVisibilidad;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

     }

    public void initViews(){
        toastDinamico = (Button) findViewById(R.id.toastDinamico);
        layoutPropio = (Button) findViewById(R.id.layoutPropio);
        cambiarVisibilidad = (Button) findViewById(R.id.cambiarVisibilidad);
        texto = (TextView) findViewById(R.id.texto);

        toastDinamico.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast toast = new Toast(getApplicationContext());

                LinearLayout raiz = new LinearLayout(getApplicationContext());
                raiz.setBackgroundColor(Color.parseColor("#FF7F50"));
                TextView texto = new TextView(getApplicationContext());
                texto.setText("Toast generado dinamicamente desde la aplicación.");
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT, 0);
                texto.setLayoutParams(params);
                texto.setGravity(Gravity.CENTER);
                raiz.addView(texto);
                toast.setView(raiz);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        layoutPropio.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                try {
                    View raiz = LayoutInflater.from(getApplicationContext()).inflate(R.layout.toast, null);
                    TextView lblMensaje = (TextView) raiz.findViewById(R.id.lblMensaje);
                    if (lblMensaje != null) {
                        lblMensaje.setText("Toast con layout propio");
                        Toast toast = new Toast(getApplicationContext());
                        toast.setView(raiz);
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Toast con layout propio", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Toast con layout propio", Toast.LENGTH_LONG).show();
                }
            }
        });

        cambiarVisibilidad.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if(texto.getVisibility() == View.INVISIBLE){
                    texto.setVisibility(View.VISIBLE);
                }else{
                    texto.setVisibility(View.INVISIBLE);
                }

                Snackbar.make(findViewById(R.id.lraiz), "Se ha eliminado el texto", Snackbar.LENGTH_LONG)
                        .setAction("Deshacer", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (texto.getVisibility() == View.INVISIBLE) {
                                    texto.setVisibility(View.VISIBLE);
                                } else {
                                    texto.setVisibility(View.INVISIBLE);
                                }

                            }
                        }).show();
            }
        });
    }


}
