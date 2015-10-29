package es.iessaladillo.gabrielguerrero.ej015_parcelable;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class OtraActivity extends AppCompatActivity {

    public static final String STATE_ALUMNO_2 = "ESTADO_ALUMNO_2";
    public static final String EXTRA_ALUMNO = "ALUMNO";
    private TextView lblDNI;
    private EditText txtNombre;
    private EditText txtEdad;
    private Button btnEnviar;
    private Alumno mAlumno;
    private Spinner spnSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otra);
        if(savedInstanceState != null)
            mAlumno = savedInstanceState.getParcelable(STATE_ALUMNO_2);
        else
            mAlumno = new Alumno();
        initViews();
        Intent otroIntent = getIntent();
        mAlumno = otroIntent.getParcelableExtra(EXTRA_ALUMNO);
        lblDNI.setText(mAlumno.getDni());
    }

    private void initViews() {
        lblDNI = (TextView) findViewById(R.id.lblDNI);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtEdad = (EditText) findViewById(R.id.txtEdad);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        spnSexo = (Spinner) findViewById(R.id.spnSexo);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public static void start(Activity activity,Alumno alumno,int requestCode){
        Intent intent = new Intent(activity,OtraActivity.class);
        intent.putExtra(EXTRA_ALUMNO,alumno);
        activity.startActivityForResult(intent, requestCode);
    }

    @Override
    public void finish(){
        Intent result = new Intent();
        viewsToAlumno();
        result.putExtra(EXTRA_ALUMNO, mAlumno);
        setResult(RESULT_OK, result);

        super.finish();
    }

    private void viewsToAlumno() {
        String[] sexos = getResources().getStringArray(R.array.sexo);

        mAlumno.setNombre(txtNombre.getText().toString());
        mAlumno.setEdad(txtEdad.getText().toString());
        mAlumno.setSexo(sexos[spnSexo.getSelectedItemPosition()]);
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(STATE_ALUMNO_2, mAlumno);
    }


}
