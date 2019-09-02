package com.example.pizzeriahuichi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos>
        implements View.OnClickListener {

    ArrayList<ClsPizza> listDatos;
    private View.OnClickListener listener;

    public AdapterDatos(ArrayList<ClsPizza> listDatos) {
        this.listDatos = listDatos;
    }

    //Nos enlace este adaptador con el itemlilst
    @NonNull
    @Override
    public AdapterDatos.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);

        view.setOnClickListener(this);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDatos.ViewHolderDatos holder, int position) {
        holder.etinombre.setText(listDatos.get(position).getNombre());
        holder.etiinformacion.setText(listDatos.get(position).getPrecio());
        holder.foto.setImageResource(listDatos.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder{

        TextView etinombre, etiinformacion;
        ImageView foto;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            etinombre = itemView.findViewById(R.id.lbl_tituloPizza);
            etiinformacion = itemView.findViewById(R.id.lbl_descripcionPizza);
            foto = itemView.findViewById(R.id.imagePizza1);
        }

    }

    @Override
    public void onClick(View view){
        if(listener != null){
            listener.onClick(view);
        }
    }
}