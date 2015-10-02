package es.iessaladillo.gabrielguerrero.ej005;

import android.graphics.Color;
import android.graphics.Typeface;
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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button aceptar;
    private Button cancelar;
    private EditText usuario;
    private EditText contrasenha;
    private TextView user;
    private TextView pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

   private void initViews(){
       aceptar = (Button) findViewById(R.id.button2);
       cancelar = (Button) findViewById(R.id.button);
       usuario = (EditText) findViewById(R.id.editText2);
       contrasenha = (EditText) findViewById(R.id.editText3);
       user = (TextView) findViewById(R.id.textView3);
       pass = (TextView) findViewById(R.id.textView2);

       aceptar.setOnClickListener(new Button.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(getApplicationContext(),"Conectando con el usuario " + usuario.getText().toString() + "...",Toast.LENGTH_SHORT).show();
           }
       });

       cancelar.setOnClickListener(new Button.OnClickListener() {
           @Override
           public void onClick(View view) {
                usuario.setText("");
               contrasenha.setText("");
           }
       });

       usuario.setOnFocusChangeListener(new View.OnFocusChangeListener() {
           @Override
           public void onFocusChange(View v, boolean hasFocus) {
               if (hasFocus) {
                   user.setTextColor(Color.GREEN);
                   user.setTypeface(Typeface.DEFAULT_BOLD);
               } else {
                   user.setTextColor(Color.GRAY);
                   user.setTypeface(Typeface.DEFAULT);
               }
           }
       });

       contrasenha.setOnFocusChangeListener(new View.OnFocusChangeListener() {
           @Override
           public void onFocusChange(View v, boolean hasFocus) {
               if(hasFocus){
                   pass.setTextColor(Color.GREEN);
                   pass.setTypeface(Typeface.DEFAULT_BOLD);
               }else{
                   pass.setTextColor(Color.GRAY);
                   pass.setTypeface(Typeface.DEFAULT);
               }
           }
       });

       usuario.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {

           }

           @Override
           public void afterTextChanged(Editable s) {
               aceptar.setEnabled(!TextUtils.isEmpty(usuario.getText().toString()) && !TextUtils.isEmpty(contrasenha.getText().toString()));
               if (TextUtils.isEmpty(usuario.getText().toString())) {
                   user.setVisibility(View.INVISIBLE);
               } else {
                   user.setVisibility(View.VISIBLE);
               }
           }
       });

       contrasenha.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {

           }

           @Override
           public void afterTextChanged(Editable s) {
               aceptar.setEnabled(!TextUtils.isEmpty(usuario.getText().toString()) && !TextUtils.isEmpty(contrasenha.getText().toString()));
               if(TextUtils.isEmpty(contrasenha.getText().toString())){
                   pass.setVisibility(View.INVISIBLE);
               }else{
                   pass.setVisibility(View.VISIBLE);
               }
           }
       });

   }
}
