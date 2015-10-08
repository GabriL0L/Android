package es.iessaladillo.gabrielguerrero.ej009_textinputlayout;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout tilNombre;
    private EditText txtNombre;
    private TextInputLayout tilTelefono;
    private EditText txtTelefono;
    private TextInputLayout tilEmail;
    private EditText txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initViews(){
        tilNombre = (TextInputLayout) findViewById(R.id.tilNombre);
        tilTelefono = (TextInputLayout) findViewById(R.id.tilTelefono);
        tilEmail = (TextInputLayout) findViewById(R.id.tilEmail);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtTelefono = (EditText) findViewById(R.id.txtTelefono);
        txtEmail = (EditText) findViewById(R.id.txtEmail);

        txtNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!TextUtils.isEmpty(txtNombre.getText().toString())){
                    if(!isValidName(txtNombre.getText().toString())){
                        tilNombre.setError("El nombre debe empezar por mayúsculas y contener solo letras.");
                    }else{
                        tilNombre.setErrorEnabled(false);
                    }
                }else{
                    tilNombre.setErrorEnabled(false);
                }
            }
        });

        txtTelefono.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!TextUtils.isEmpty(txtTelefono.getText().toString())) {
                    if (!isValidPhoneNumber(txtTelefono.getText().toString())) {
                        tilTelefono.setError("No es un número de teléfono válido.");
                    } else {
                        tilTelefono.setErrorEnabled(false);
                    }
                } else {
                    tilTelefono.setErrorEnabled(false);
                }
            }
        });

        txtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!TextUtils.isEmpty(txtEmail.getText().toString())) {
                    if (!Patterns.EMAIL_ADDRESS.matcher(txtEmail.getText().toString()).matches()) {
                        tilEmail.setError("Debe tener el formato usuario@dominio.tipo");
                    } else {
                        tilEmail.setErrorEnabled(false);
                    }
                } else {
                    tilEmail.setErrorEnabled(false);
                }
            }
        });

    }

    private boolean isValidPhoneNumber(String comprobar){
        boolean salida = true;

        if(comprobar.length() > 0 && comprobar.length() < 9)
            salida = false;
        if(!comprobar.startsWith("6") && !comprobar.startsWith("7") && !comprobar.startsWith("8") && !comprobar.startsWith("9"))
            salida = false;

        return salida;
    }

    private boolean isValidName(String comprobar){
        boolean salida = true;

        if(!comprobar.matches("[A-ZÑ][[a-zñ]||\\s]*")){
            salida = false;
        }

        return salida;
    }


}
