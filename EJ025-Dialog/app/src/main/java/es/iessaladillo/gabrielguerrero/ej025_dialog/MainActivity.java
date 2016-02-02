package es.iessaladillo.gabrielguerrero.ej025_dialog;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class MainActivity extends AppCompatActivity implements MiDialogFragment.MiDialogListener,
        SiNoDialogFragment.MiDialogListener, EquipoDialogFragment.MiDialogListener,
        EquipoNoDirectoFragment.MiDialogListener, EquipoMultipleFragment.MiDialogListener,
        CitaDialogFragment.MiCitaListener, TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener{

    @Bind(R.id.txtCita)
    EditText txtCita;
    @Bind(R.id.txtFechaNac)
    EditText txtFechaNac;
    @Bind(R.id.txtHoraExamen)
    EditText txtHoraExamen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        txtCita.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    DialogFragment frgMiDialogo = new CitaDialogFragment();
                    frgMiDialogo.show(getSupportFragmentManager(), "CitaDialogFragment");
                }
            }
        });

        txtFechaNac.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    DialogFragment frgMiDialogo = new DatePickerDialogFragment();
                    frgMiDialogo.show(getSupportFragmentManager(), "DatePickerDialogFragment");
                }
            }
        });

        txtHoraExamen.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    DialogFragment frgMiDialogo = new TimePickerDialogFragment();
                    frgMiDialogo.show(getSupportFragmentManager(), "TimePickerDialogFragment");
                }
            }
        });

    }

    @OnClick(R.id.btnPulsar)
    public void mostrarDialogo(){
        DialogFragment frgMiDialogo = new MiDialogFragment();
        frgMiDialogo.show(getSupportFragmentManager(), "MiDialogFragment");
    }

    @OnClick(R.id.btnSiNo)
    public void mostrarDialogoSiNo(){
        DialogFragment frgMiDialogo = new SiNoDialogFragment();
        frgMiDialogo.show(getSupportFragmentManager(), "SiNoDialogFragment");
    }

    @OnClick(R.id.btnEquipo)
    public void mostrarEquipo(){
        DialogFragment frgMiDialogo = new EquipoDialogFragment();
        frgMiDialogo.show(getSupportFragmentManager(), "EquipoDialogFragment");
    }

    @OnClick(R.id.btnEquipoND)
    public void mostrarEquipoNoDirecto(){
        DialogFragment frgMiDialogo = new EquipoNoDirectoFragment();
        frgMiDialogo.show(getSupportFragmentManager(), "EquipoNoDirectoFragment");
    }

    @OnClick(R.id.btnEquipoM)
    public void mostrarEquipoMultiple(){
        DialogFragment frgMiDialogo = new EquipoMultipleFragment();
        frgMiDialogo.show(getSupportFragmentManager(), "EquipoMultipleFragment");
    }


    @Override
    public void onPositiveButtonClick(DialogFragment dialog) {
        Toast.makeText(this,"El botón ha sido pulsado",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSiButtonClick(DialogFragment dialog) {
        Toast.makeText(this,"El tio ha dicho que si",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNoButtonClick(DialogFragment dialog) {
        Toast.makeText(this,"El tio ha dicho que no",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(DialogFragment dialog, String equipo) {
        String texto = "El tio seleccionó: " + equipo;
        Toast.makeText(this,texto,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemNoDirectoClick(DialogFragment dialog, String equipo) {
        String texto = "El tio seleccionó: " + equipo;
        Toast.makeText(this,texto,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemMultipleClick(DialogFragment dialog, String resultado) {
        String texto = "El tio seleccionó:" + resultado;

        Toast.makeText(this,texto,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void getCita(DialogFragment dialog, String cita) {
        txtCita.setText(cita);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        String texto = String.format("%02d/%02d/%04d",day,month+1,year);
        txtFechaNac.setText(texto);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        String texto = String.format("%02d:%02d",hour,minute);
        txtHoraExamen.setText(texto);
    }
}
