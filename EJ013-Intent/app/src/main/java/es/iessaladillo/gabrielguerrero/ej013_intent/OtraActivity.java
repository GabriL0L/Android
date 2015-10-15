package es.iessaladillo.gabrielguerrero.ej013_intent;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class OtraActivity extends AppCompatActivity {

    private TextView lblTexto ;
    private String mTexto;
    public static final String EXTRA_TEXTO = "extra";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otra);

        Intent intent = getIntent();
        mTexto = intent.getStringExtra(EXTRA_TEXTO);

        initViews();


    }

    private void initViews() {
        lblTexto = (TextView) findViewById(R.id.lblTexto);
        lblTexto.setText(mTexto);
    }

    public static void start(Context context,String texto){
        Intent intent = new Intent(context,OtraActivity.class);
        intent.putExtra(EXTRA_TEXTO,texto);
        context.startActivity(intent);
    }

}
