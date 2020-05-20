package com.mcr.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<String> nombres;
    private int layout;
    private OnItemClickListener itemClickListener;

    public Adapter(List<String> nombres,int layout,OnItemClickListener itemClickListener)
    {
        this.nombres = nombres;
        this.layout = layout;
        this.itemClickListener=itemClickListener;
    }
    
    /*
    Infla la vista
     */
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    /*
    Este metodo se lanza cuando se construye el recyclerview
    Normalmente en este metodo es donde se agregan los datos a la vista
    si se agregan mas elementos, este metodo ya no vuelve a ser llamado
     */
    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.bind(nombres.get(position),itemClickListener);
    }

    @Override
    public int getItemCount() {
        return nombres.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvNombre;
        public ViewHolder(View itemView)
        {
            super(itemView);
            this.tvNombre = (TextView) itemView.findViewById(R.id.tvItem);
        }

        /*
        El volcado de los datos se hace aqui para mantener el indice actualizado
         */
        public void bind(final String nombre,final OnItemClickListener listener)
        {
            this.tvNombre.setText(nombre);
            tvNombre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClickListener(nombre,getAdapterPosition());
                }
            });
        }

    }

    public interface OnItemClickListener
    {
        void onItemClickListener(String nombre,int posicion);
    }


}
