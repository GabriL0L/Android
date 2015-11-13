package es.iessaladillo.gabrielguerrero.ej022_fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Usuario on 12/11/2015.
 */
public class UnoFragment extends Fragment{

    private static final String MENSAJE = "MENSAJE";
    private CallBack listener;
    private EditText txtFragmento;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_uno,container,false);
    }

    public static UnoFragment newInstance(String mensaje) {
        UnoFragment fragment = new UnoFragment();
        Bundle argumentos = new Bundle();

        argumentos.putString(MENSAJE,mensaje);
        fragment.setArguments(argumentos);

        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (CallBack) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException("La actividad debe implementar la interfaz CallBack");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Bundle argumentos = getArguments();
        String mensaje = argumentos.getString(MENSAJE);
        View v = getView();
        TextView lblMensaje = (TextView) v.findViewById(R.id.lblMensaje);
        Button btnFragmento = (Button) v.findViewById(R.id.btnFragmento);
        txtFragmento = (EditText) v.findViewById(R.id.txtFragmento);

        lblMensaje.setText(mensaje);

        btnFragmento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.pulsado(txtFragmento.getText().toString());
            }
        });

        super.onActivityCreated(savedInstanceState);
    }

    public interface CallBack{
       public void pulsado(String mensaje);
    }
}
