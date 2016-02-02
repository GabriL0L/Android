package es.iessaladillo.gabrielguerrero.ej025_dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Usuario on 27/11/2015.
 */
public class CitaDialogFragment extends DialogFragment{

    private EditText txtIntroducirCita;
    private String cita;

    public interface MiCitaListener {
        public void getCita(DialogFragment dialog,String cita);
    }

    MiCitaListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View vista = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_cita_layout,null);
        AlertDialog.Builder cons = new AlertDialog.Builder(this.getActivity());
        cons.setTitle("Cita");
        txtIntroducirCita = (EditText) vista.findViewById(R.id.txtIntroducirCita);
        cons.setView(vista);

        cons.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                cita = txtIntroducirCita.getText().toString();
                listener.getCita(CitaDialogFragment.this,cita);
            }
        });
        cons.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        return cons.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (MiCitaListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()+ " debe implementar MiCitaListener");
        }
    }
}
