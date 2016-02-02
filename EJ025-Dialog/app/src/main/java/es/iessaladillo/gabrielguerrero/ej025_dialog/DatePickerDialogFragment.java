package es.iessaladillo.gabrielguerrero.ej025_dialog;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

/**
 * Created by Usuario on 27/11/2015.
 */
public class DatePickerDialogFragment extends DialogFragment {

    private DatePickerDialog.OnDateSetListener mListener;

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendario = Calendar.getInstance();
        return new DatePickerDialog(this.getActivity(), mListener, calendario.get(Calendar.YEAR),
                calendario.get(Calendar.MONTH),calendario.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (DatePickerDialog.OnDateSetListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()+ " debe implementar DatePickerDialog.OnDateSetListener");
        }
    }

}
