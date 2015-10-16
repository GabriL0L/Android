package es.iessaladillo.gabrielguerrero.ej014_intentenviorecepcion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OtraActivity extends AppCompatActivity {

    private static final String EXTRA_DNI = "DNI";
    public static final String EXTRA_NOMBRE = "NOMBRE";
    public static final String EXTRA_EDAD = "EDAD";
    private TextView lblDNI;
    private EditText txtNombre;
    private EditText txtEdad;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otra);
        initViews();
        Intent otroIntent = getIntent();
        String dni = otroIntent.getStringExtra(EXTRA_DNI);
        lblDNI.setText(dni);
    }

    private void initViews() {
        lblDNI = (TextView) findViewById(R.id.lblDNI);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtEdad = (EditText) findViewById(R.id.txtEdad);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public static void start(Activity activity,String dni,int requestCode){
        Intent intent = new Intent(activity,OtraActivity.class);
        intent.putExtra(EXTRA_DNI,dni);
        activity.startActivityForResult(intent, requestCode);
    }

    @Override
    public void finish(){
        Intent result = new Intent();
        result.putExtra(EXTRA_NOMBRE,txtNombre.getText().toString());
        result.putExtra(EXTRA_EDAD,Integer.valueOf(txtEdad.getText().toString()));
        setResult(RESULT_OK,result);

        super.finish();
    }

}
