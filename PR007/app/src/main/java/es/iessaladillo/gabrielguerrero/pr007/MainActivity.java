package es.iessaladillo.gabrielguerrero.pr007;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText txtMensaje;
    private TextView lblTexto;
    private ImageView btnEnviar;
    private ScrollView scvTexto;
    private SimpleDateFormat sdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());

    }

    public void initViews(){
        lblTexto = (TextView) findViewById(R.id.lblTexto);
        txtMensaje = (EditText) findViewById(R.id.txtMensaje);
        btnEnviar = (ImageView) findViewById(R.id.btnEnviar);
        scvTexto = (ScrollView) findViewById(R.id.scvTexto);

        txtMensaje.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    if (!TextUtils.isEmpty(txtMensaje.getText().toString())) {

                        String hora = sdf.format(new Date());
                        lblTexto.append("[" + hora + "] " + txtMensaje.getText().toString() + "\n\n");
                        txtMensaje.setText("");

                        hacerScroll(scvTexto, View.FOCUS_DOWN);
                    }
                }
                return false;
            }
        });
        txtMensaje.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                btnEnviar.setEnabled(!TextUtils.isEmpty(txtMensaje.getText()));
            }

        });
        btnEnviar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(txtMensaje.getText().toString())) {

                    String hora = sdf.format(new Date());
                    lblTexto.append("[" + hora + "] " + txtMensaje.getText().toString() + "\n\n");
                    txtMensaje.setText("");

                    hacerScroll(scvTexto, View.FOCUS_DOWN);
                }
            }
        });
        btnEnviar.setEnabled(!TextUtils.isEmpty(txtMensaje.getText()));
        hacerScroll(scvTexto, View.FOCUS_DOWN);
    }


    private void hacerScroll(final ScrollView scv, final int focus) {
        scv.post(new Runnable() {
            @Override
            public void run() {
                scv.fullScroll(focus);
            }
        });
    }

}
