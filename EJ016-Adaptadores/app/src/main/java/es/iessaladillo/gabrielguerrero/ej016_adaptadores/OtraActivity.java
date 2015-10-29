package es.iessaladillo.gabrielguerrero.ej016_adaptadores;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OtraActivity extends AppCompatActivity {

    public static final String EXTRA_NOMBRE =  "NOMBRE";
    private TextView lblNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otra);
        initViews();
        Intent intent = getIntent();
        lblNombre.setText(intent.getStringExtra(EXTRA_NOMBRE));
    }

    private void initViews() {
        lblNombre = (TextView) findViewById(R.id.lblNombre);
    }

    public static void start(Activity activity,String nombre){
        Intent intent = new Intent(activity,OtraActivity.class);
        intent.putExtra(EXTRA_NOMBRE,nombre);
        activity.startActivity(intent);
    }


}
