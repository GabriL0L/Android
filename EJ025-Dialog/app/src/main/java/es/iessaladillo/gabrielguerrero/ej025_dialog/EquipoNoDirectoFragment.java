package es.iessaladillo.gabrielguerrero.ej025_dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.AdapterView;

/**
 * Created by Usuario on 26/11/2015.
 */
public class EquipoNoDirectoFragment extends DialogFragment {
    private String[] equipos;
    private int seleccion;

    public interface MiDialogListener {
        public void onItemNoDirectoClick(DialogFragment dialog, String equipo);
    }

    MiDialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder cons = new AlertDialog.Builder(this.getActivity());
        cons.setTitle("Equipos");
        equipos = getResources().getStringArray(R.array.equipos);
        cons.setSingleChoiceItems(equipos, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                seleccion = i;
            }
        });
        cons.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onItemNoDirectoClick(EquipoNoDirectoFragment.this, equipos[seleccion]);
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
            listener = (MiDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()+ " debe implementar MiDialogListener");
        }
    }
}
