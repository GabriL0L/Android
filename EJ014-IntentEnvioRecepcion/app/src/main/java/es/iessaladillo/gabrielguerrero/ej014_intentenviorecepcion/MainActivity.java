package es.iessaladillo.gabrielguerrero.ej014_intentenviorecepcion;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    private EditText txtDNI;
    private TextView lblNombre;
    private TextView lblEdad;
    private Button btnObtener;
    private static final int REQUEST_CODE = 1;
    private String mNombre = "";
    private int mEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {
        txtDNI = (EditText) findViewById(R.id.txtDNI);
        lblNombre = (TextView) findViewById(R.id.lblNombre);
        lblEdad = (TextView) findViewById(R.id.lblEdad);
        btnObtener = (Button) findViewById(R.id.btnObtener);

        btnObtener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OtraActivity.start(MainActivity.this, txtDNI.getText().toString(), REQUEST_CODE);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            mNombre = intent.getStringExtra(OtraActivity.EXTRA_NOMBRE);
            mEdad = intent.getIntExtra(OtraActivity.EXTRA_EDAD, 0);
            lblNombre.setText(mNombre);
            lblEdad.setText(String.valueOf(mEdad));
        }

    }

}
