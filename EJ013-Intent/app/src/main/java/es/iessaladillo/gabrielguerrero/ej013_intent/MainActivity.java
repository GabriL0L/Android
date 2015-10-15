package es.iessaladillo.gabrielguerrero.ej013_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText txtTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        txtTexto = (EditText) findViewById(R.id.txtTexto);

        findViewById(R.id.btnEnviar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviar();
            }
        });

        findViewById(R.id.btnMostrarOtra).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarOtro();
            }
        });
    }

    private void enviar(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT,txtTexto.getText().toString());
        startActivity(intent);
    }

    private void enviarOtro(){
        OtraActivity.start(this,txtTexto.getText().toString());
    }


}
