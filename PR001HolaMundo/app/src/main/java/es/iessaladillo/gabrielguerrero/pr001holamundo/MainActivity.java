package es.iessaladillo.gabrielguerrero.pr001holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView lblSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        lblSaludo = (TextView) findViewById(R.id.lblSaludo);
    }

    public void btnInsultarOnClick(View v){
        lblSaludo.setText("Prueba");
    }



}
