package es.iessaladillo.gabrielguerrero.pr029_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Usuario on 14/01/2016.
 */
public class Adaptador extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final ArrayList<ListItem> mDatos;
    private View emptyView;
    private OnItemLongClickListener onItemLongClickListener;
    private OnItemClickListener onItemClickListener;

    public Adaptador(ArrayList<ListItem> datos) {
        mDatos = datos;
    }

    public ArrayList<ListItem> getData() {
        return mDatos;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ListItem.TYPE_CHILD) {
            return onCreateAlumnoViewHolder(parent);
        } else {
            return onCreateGrupoViewHolder(parent);
        }
    }

    private RecyclerView.ViewHolder onCreateAlumnoViewHolder(ViewGroup parent) {

        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fila, parent, false);

        final RecyclerView.ViewHolder viewHolder = new AlumnoViewHolder(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(v, (Alumno) mDatos.get(viewHolder.getAdapterPosition()), viewHolder.getAdapterPosition());
                }
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (onItemLongClickListener != null) {
                    // Se informa al listener.
                    onItemLongClickListener.onItemLongClick(view,
                            mDatos.get(viewHolder.getAdapterPosition()),
                            viewHolder.getAdapterPosition());
                    return true;
                } else {
                    return false;
                }
            }
        });

        return viewHolder;
    }


    @Override
    public int getItemViewType(int position) {
        return mDatos.get(position).getType();
    }

    private RecyclerView.ViewHolder onCreateGrupoViewHolder(ViewGroup parent) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fila_grupo, parent, false);
        final RecyclerView.ViewHolder viewHolder = new GrupoViewHolder(itemView);
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (onItemLongClickListener != null) {
                    // Se informa al listener.
                    onItemLongClickListener.onItemLongClick(view,
                            mDatos.get(viewHolder.getAdapterPosition()),
                            viewHolder.getAdapterPosition());
                    return true;
                } else {
                    return false;
                }
            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (mDatos.get(position).getType() == ListItem.TYPE_CHILD) {
            ((AlumnoViewHolder) holder).onBind((Alumno) mDatos.get(position));
        } else {
            ((GrupoViewHolder) holder).onBind((Grupo) mDatos.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mDatos.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        this.onItemLongClickListener = listener;
    }

    public void addItem(Alumno alumno){
        mDatos.add(alumno);
        notifyItemInserted(mDatos.size() - 1);
        checkIfEmpty();
    }

    public void removeItem(int position){
        mDatos.remove(position);
        notifyItemRemoved(position);
        checkIfEmpty();
    }

    private void checkIfEmpty() {
        if (emptyView != null) {
            emptyView.setVisibility(getItemCount() > 0 ? View.GONE : View.VISIBLE);
        }
    }

    public void setEmptyView(View emptyView) {
        this.emptyView = emptyView;
        checkIfEmpty();
    }

    static class AlumnoViewHolder extends RecyclerView.ViewHolder {

        // El contenedor de vistas para un elemento de la lista debe contener...
        private final TextView lblNombre;
        private final TextView lblEdad;

        // El constructor recibe la vista-fila.
        public AlumnoViewHolder(View itemView) {
            super(itemView);
            // Se obtienen las vistas de la vista-fila.
            lblNombre = (TextView) itemView.findViewById(R.id.lblNombre);
            lblEdad = (TextView) itemView.findViewById(R.id.lblEdad);
        }

        public void onBind(Alumno alumno) {
            // Se escriben los datos en la vista.
            lblNombre.setText(alumno.getNombre());
            lblEdad.setText(String.valueOf(alumno.getEdad()));
        }

    }

    // Contenedor de vistas para la vista-fila.
    static class GrupoViewHolder extends RecyclerView.ViewHolder {

        // El contenedor de vistas para un elemento de la lista debe contener...
        private final TextView lblEncCiclo;

        // El constructor recibe la vista-fila.
        public GrupoViewHolder(View itemView) {
            super(itemView);
            // Se obtienen las vistas de la vista-fila.
            lblEncCiclo = (TextView) itemView.findViewById(R.id.lblEncCiclo);
        }

        public void onBind(Grupo grupo) {
            // Se escriben los datos en la vista.
            lblEncCiclo.setText(grupo.getNombre());
        }

    }

    public interface OnItemClickListener {
        void onItemClick(View view, Alumno alumno, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View view, ListItem listItem, int position);
    }
}
