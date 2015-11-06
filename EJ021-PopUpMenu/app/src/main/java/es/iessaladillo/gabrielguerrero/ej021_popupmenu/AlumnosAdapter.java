package es.iessaladillo.gabrielguerrero.ej021_popupmenu;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Usuario on 06/11/2015.
 */
public class AlumnosAdapter extends ArrayAdapter<Alumno> {

    private final List<Alumno> mAlumnos;
    private final LayoutInflater mInflador;

    public AlumnosAdapter(Context contexto, List<Alumno> alumnos) {
        super(contexto, R.layout.fila, alumnos);
        mAlumnos = alumnos;
        mInflador = LayoutInflater.from(contexto);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = mInflador.inflate(R.layout.fila, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        onBindViewHolder(holder, position);

        return convertView;
    }

    private void onBindViewHolder(ViewHolder holder, int position) {
        Alumno alumno = mAlumnos.get(position);
        holder.lblNombre.setText(alumno.getNombre());
        holder.lblNombre.setTextColor(Color.BLACK);
        holder.lblTelefono.setText(alumno.getTelefono());
        holder.lblTelefono.setTextColor(Color.GRAY);
        holder.lblDireccion.setText(alumno.getDireccion());
        holder.lblDireccion.setTextColor(Color.GRAY);
        holder.lblCurso.setText(alumno.getCurso());
        holder.lblCurso.setTextColor(Color.GRAY);

        holder.imgPopupMenu.setOnClickListener(new imgPopupMenuOnClickListener(mAlumnos.get(position)));

    }

    static class ViewHolder {

        private final TextView lblNombre;
        private final TextView lblTelefono;
        private final TextView lblDireccion;
        private final TextView lblCurso;
        private final ImageView imgPopupMenu;

        public ViewHolder(View itemView) {

            lblNombre = (TextView) itemView.findViewById(R.id.lblNombre);
            lblTelefono = (TextView) itemView.findViewById(R.id.lblTelefono);
            lblDireccion = (TextView) itemView.findViewById(R.id.lblDireccion);
            lblCurso = (TextView) itemView.findViewById(R.id.lblCurso);
            imgPopupMenu = (ImageView) itemView.findViewById(R.id.imgPopupMenu);

        }

    }


    private class imgPopupMenuOnClickListener implements View.OnClickListener {

        private final Alumno mAlumno;


        public imgPopupMenuOnClickListener(Alumno alumno) {
            mAlumno = alumno;
        }


        @Override
        public void onClick(View v) {

            PopupMenu popup = new PopupMenu(getContext(), v);

            MenuInflater inflador = popup.getMenuInflater();
            inflador.inflate(R.menu.menu_item_popup, popup.getMenu());
            popup.setOnMenuItemClickListener(new PopupMenuOnMenuItemClickListener(
                    mAlumno));

            popup.show();
        }
    }

    private class PopupMenuOnMenuItemClickListener implements
            PopupMenu.OnMenuItemClickListener {


        final Alumno alumno;


        public PopupMenuOnMenuItemClickListener(Alumno alumno) {
            this.alumno = alumno;
        }


        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.mnuLlamar:
                    Intent intent1 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)" + alumno.getTelefono()));
                    getContext().startActivity(intent1);
                    break;
                case R.id.mnuEnviarMensaje:
                    Intent intent2 = new Intent(Intent.ACTION_SEND, Uri.parse("tel:(+34)" + alumno.getTelefono()));
                    getContext().startActivity(intent2);
                    break;
            }
            return true;
        }

    }

}