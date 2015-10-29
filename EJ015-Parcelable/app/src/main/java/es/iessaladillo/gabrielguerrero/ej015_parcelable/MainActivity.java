package es.iessaladillo.gabrielguerrero.ej015_parcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String STATE_ALUMNO = "ESTADO_ALUMNO";
    private EditText txtDNI;
    private TextView lblNombre;
    private TextView lblEdad;
    private Button btnObtener;
    private static final int REQUEST_CODE = 1;
    private Alumno mAlumno;
    private TextView lblSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null)
            mAlumno = savedInstanceState.getParcelable(STATE_ALUMNO);
        else
            mAlumno = new Alumno();

        initViews();
    }

    private void initViews() {
        txtDNI = (EditText) findViewById(R.id.txtDNI);
        lblNombre = (TextView) findViewById(R.id.lblNombre);
        lblEdad = (TextView) findViewById(R.id.lblEdad);
        btnObtener = (Button) findViewById(R.id.btnObtener);
        lblSexo = (TextView) findViewById(R.id.lblSexo);
        alumnoToViews();

        btnObtener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OtraActivity.start(MainActivity.this, new Alumno(txtDNI.getText().toString(), "", "", ""), REQUEST_CODE);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            mAlumno = intent.getParcelableExtra(OtraActivity.EXTRA_ALUMNO);
            alumnoToViews();
        }

    }

    private void alumnoToViews() {
        lblNombre.setText(mAlumno.getNombre());
        lblEdad.setText(mAlumno.getEdad());
        lblSexo.setText(mAlumno.getSexo());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(STATE_ALUMNO, mAlumno);
        super.onSaveInstanceState(outState);
    }


}
