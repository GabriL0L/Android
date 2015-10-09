package es.iessaladillo.gabrielguerrero.ej011_pluralargs;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText suspensos;
    private Button ver;
    private TextInputLayout tilSuspensos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initViews(){
        suspensos = (EditText) findViewById(R.id.suspensos);
        ver = (Button) findViewById(R.id.ver);
        tilSuspensos = (TextInputLayout) findViewById(R.id.tilSuspensos);

        ver.setEnabled(false);

        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numSuspensos = Integer.valueOf(suspensos.getText().toString());
                String mensaje = String.format(getResources().getQuantityString(
                        R.plurals.num_de_suspensos, numSuspensos),numSuspensos);
                Toast.makeText(getApplicationContext(),mensaje, Toast.LENGTH_SHORT).show();
            }
        });

        suspensos.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(TextUtils.isEmpty(suspensos.getText().toString())){
                    tilSuspensos.setError("Debe introducir un número.");
                    ver.setEnabled(false);
                }else{
                    tilSuspensos.setErrorEnabled(false);
                    ver.setEnabled(true);
                }

            }
        });
    }

}
