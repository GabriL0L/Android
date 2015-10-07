package es.iessaladillo.gabrielguerrero.ej001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView lblMostrar;
    private EditText txt1; //Nombre
    private EditText txt2; //Apellido
    private Button btnAN;
    private Button btnNA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews(){
        lblMostrar = (TextView) findViewById(R.id.lblMostrar);
        txt1 = (EditText) findViewById(R.id.txt1);
        txt2 = (EditText) findViewById(R.id.txt2);
        btnAN = (Button) findViewById(R.id.btnAN);
        btnNA = (Button) findViewById(R.id.btnNA);
    }

    public void mostrarANOnClick(View v){
        String mensaje = getString(R.string.senior) + " " + txt2.getText().toString() + ", " + txt1.getText().toString();
        lblMostrar.setText(mensaje);
        Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
/*        btnAN.setEnabled(false);
        btnNA.setEnabled(true);*/
        btnAN.setVisibility(View.INVISIBLE);
        btnNA.setVisibility(View.VISIBLE);
    }

    public void mostrarNAOnClick(View v){
        String mensaje = getString(R.string.senior) + " " + txt1.getText().toString() + ", " + txt2.getText().toString();
        lblMostrar.setText(mensaje);
        Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
//        btnNA.setEnabled(false);
//        btnAN.setEnabled(true);
        btnNA.setVisibility(View.INVISIBLE);
        btnAN.setVisibility(View.VISIBLE);
    }

}
