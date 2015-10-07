package es.iessaladillo.gabrielguerrero.ej004;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imagen;
    private RadioGroup grupito;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

   private void initViews(){
       imagen = (ImageView) findViewById(R.id.imagen);
       grupito = (RadioGroup) findViewById(R.id.grupito);
       boton = (Button) findViewById(R.id.boton);



       grupito.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup radioGroup, int marcado) {
               switch (marcado) {
                   case R.id.primavera:
                       imagen.setImageResource(R.drawable.primavera);
                       break;
                   case R.id.verano:
                       imagen.setImageResource(R.drawable.verano);
                       break;

                   case R.id.otonho:
                       imagen.setImageResource(R.drawable.otonho);
                       break;

                   case R.id.invierno:
                       imagen.setImageResource(R.drawable.invierno);
                       break;
               }
           }
       });

       grupito.check(R.id.primavera);

       imagen.setOnClickListener(new ImageView.OnClickListener() {
           public void onClick(View view) {
               switch (grupito.getCheckedRadioButtonId()) {
                   case R.id.primavera:
                       grupito.check(R.id.verano);
                       break;
                   case R.id.verano:
                       grupito.check(R.id.otonho);
                       break;

                   case R.id.otonho:
                       grupito.check(R.id.invierno);
                       break;

                   case R.id.invierno:
                       grupito.check(R.id.primavera);
                       break;
               }
           }
       });

       boton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String texto = getString(R.string.me_gusta_);
               switch(grupito.getCheckedRadioButtonId()){
                   case R.id.primavera:
                       texto += getString(R.string.la_primavera);
                       break;
                   case R.id.verano:
                       texto += getString(R.string.el_verano);
                       break;

                   case R.id.otonho:
                       texto += getString(R.string.el_otonho);
                       break;

                   case R.id.invierno:
                       texto += getString(R.string.el_invierno);
                       break;
               }

               Toast.makeText(getApplicationContext(),texto,Toast.LENGTH_SHORT).show();
           }
       });
   }
}
