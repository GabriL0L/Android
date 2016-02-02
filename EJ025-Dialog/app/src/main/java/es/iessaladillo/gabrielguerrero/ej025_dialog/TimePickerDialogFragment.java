package es.iessaladillo.gabrielguerrero.ej025_dialog;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

/**
 * Created by Usuario on 27/11/2015.
 */
public class TimePickerDialogFragment extends DialogFragment {

    private TimePickerDialog.OnTimeSetListener listener;

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendario = Calendar.getInstance();
        return new TimePickerDialog(this.getActivity(),listener, calendario.get(Calendar.HOUR),calendario.get(Calendar.MINUTE), true);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            listener = (TimePickerDialog.OnTimeSetListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()+ " debe implementar TimePickerDialog.OnTimeSetListener");
        }
    }

}
