package es.iessaladillo.gabrielguerrero.ej002;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews(){
        editText = (EditText) findViewById(R.id.editText);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    Toast.makeText(getApplicationContext(),"Modo educado activado",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Modo educado desactivado",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void buttonOnClick(View v){
        String texto = "";

        if(checkBox.isChecked()){
            texto += "Tenga usted buenos días, señor " + editText.getText().toString();
            Toast.makeText(this,texto,Toast.LENGTH_SHORT).show();
        }else{
            texto += "Buenos días, " + editText.getText().toString();
            Toast.makeText(this,texto,Toast.LENGTH_SHORT).show();
        }

    }

}
