package es.iessaladillo.gabrielguerrero.ej017_adaptadorpersonalizado;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Usuario on 29/10/2015.
 */
public class MiAdaptador extends ArrayAdapter<Alumno> {

    private final ArrayList<Alumno> datos;

    public MiAdaptador(Context contexto, ArrayList<Alumno> datos) {
        super(contexto, R.layout.fila, datos);
        this.datos = datos;
    }

    private static class ViewHolder {

        private final TextView lblNombre;
        private final TextView lblEdad;

        public ViewHolder(View itemView) {
            lblNombre = (TextView) itemView.findViewById(R.id.lblNombre);
            lblEdad = (TextView) itemView.findViewById(R.id.lblEdad);
        }

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fila, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        onBindViewHolder(holder, position);

        return convertView;
    }


    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.lblNombre.setText(datos.get(position).getNombre());
        holder.lblNombre.setTextColor(Color.BLACK);
        holder.lblEdad.setText(datos.get(position).getEdad());

        if (Integer.valueOf(datos.get(position).getEdad()) < 18){
            holder.lblEdad.setText(datos.get(position).getEdad() + "* años");
            holder.lblEdad.setTextColor(Color.RED);
        }else{
            holder.lblEdad.setText(datos.get(position).getEdad() + " años");
            holder.lblEdad.setTextColor(Color.BLACK);
        }
    }

}
