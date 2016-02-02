package es.iessaladillo.gabrielguerrero.mislibrosfavoritos;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by Usuario on 11/12/2015.
 */
public class AceptarCancelarFragment extends DialogFragment {
    public interface MiDialogListener {
        public void onEliminarButtonClick(DialogFragment dialog);
        public void onCancelarButtonClick(DialogFragment dialog);
    }

    MiDialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder cons = new AlertDialog.Builder(this.getActivity());
        cons.setTitle("Eliminación");
        cons.setIcon(R.drawable.ic_action_name2);
        cons.setMessage("¿Está seguro de que desea eliminar los libros?");
        cons.setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onEliminarButtonClick(AceptarCancelarFragment.this);
            }
        });
        cons.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onCancelarButtonClick(AceptarCancelarFragment.this);
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
