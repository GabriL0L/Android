package es.iessaladillo.gabrielguerrero.ej025_dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import java.util.ArrayList;

/**
 * Created by Usuario on 26/11/2015.
 */
public class EquipoMultipleFragment extends DialogFragment {
    private String[] equipos;
    private String resultado = "";
    private int seleccion;
    private boolean[] seleccionados;

    public interface MiDialogListener {
        public void onItemMultipleClick(DialogFragment dialog,String resultado);
    }

    MiDialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder cons = new AlertDialog.Builder(this.getActivity());
        cons.setTitle("Equipos favoritos");
        equipos = getResources().getStringArray(R.array.equipos);
        seleccionados = new boolean[]{false,false,false,false,false};
        cons.setMultiChoiceItems(equipos, seleccionados, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                seleccionados[i] = b;
            }
        });

        cons.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                for(int j=0;j<seleccionados.length;j++){
                    if(seleccionados[j]){
                        resultado += " " + equipos[j];
                    }
                }
                listener.onItemMultipleClick(EquipoMultipleFragment.this, resultado);
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
