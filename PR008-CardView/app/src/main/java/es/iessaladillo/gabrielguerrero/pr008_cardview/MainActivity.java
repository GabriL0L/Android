package es.iessaladillo.gabrielguerrero.pr008_cardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText cuenta;
    private EditText porPropina;
    private EditText propina;
    private EditText total;
    private Button calcularCuenta;
    private Button limpiarCuenta;
    private Button redondearCuenta;
    private EditText comensal;
    private EditText porComensal;
    private Button calcularComensal;
    private Button limpiarComensal;
    private Button redondearComensal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initViews(){
        cuenta = (EditText) findViewById(R.id.cuenta);
        porPropina = (EditText) findViewById(R.id.porPropina);
        propina = (EditText) findViewById(R.id.propina);
        total = (EditText) findViewById(R.id.total);
        calcularCuenta = (Button) findViewById(R.id.calcularCuenta);
        limpiarCuenta = (Button) findViewById(R.id.limpiarCuenta);
        redondearCuenta = (Button) findViewById(R.id.redondearCuenta);
        comensal = (EditText) findViewById(R.id.comensales);
        porComensal = (EditText) findViewById(R.id.porComensal) ;
        calcularComensal = (Button) findViewById(R.id.calcularComensal);
        limpiarComensal = (Button) findViewById(R.id.limpiarComensal);
        redondearComensal = (Button) findViewById(R.id.redondearComensal);

        calcularCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float prop = Float.valueOf(cuenta.getText().toString()) * (Float.valueOf(porPropina.getText().toString())/100);
                propina.setText(String.format(Locale.getDefault(),".2f",prop));
                total.setText(String.format(Locale.getDefault(),".2f",(Float.valueOf(cuenta.getText().toString())+prop)));
            }
        });

        limpiarCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cuenta.setText("");
                porPropina.setText("");
                propina.setText("");
                total.setText("");
            }
        });

        redondearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float ctotal = Float.valueOf(total.getText().toString());
                float nuevoTotal = (float) Math.floor(ctotal);
                if(nuevoTotal != ctotal){
                    nuevoTotal += 1;
                }
                total.setText(String.format(Locale.getDefault(),".2f",nuevoTotal));
            }
        });

        calcularComensal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float cambio;
                cambio = Float.valueOf(total.getText().toString()) / Float.valueOf(comensal.getText().toString());
                porComensal.setText(String.format(Locale.getDefault(),".2f",cambio));
            }
        });

        limpiarComensal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comensal.setText("");
                porComensal.setText("");
            }
        });

        redondearComensal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float ctotal = Float.valueOf(porComensal.getText().toString());
                float nuevoTotal = (float) Math.floor(ctotal);
                if(nuevoTotal != ctotal){
                    nuevoTotal += 1;
                }
                porComensal.setText(String.format(Locale.getDefault(),".2f",nuevoTotal));
            }
        });
    }

}
