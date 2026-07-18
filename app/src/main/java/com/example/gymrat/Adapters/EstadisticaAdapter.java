package com.example.gymrat.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymrat.Models.Estadistica;
import com.example.gymrat.R;

import java.util.ArrayList;

public class EstadisticaAdapter extends RecyclerView.Adapter<EstadisticaAdapter.ViewHolder> {

    private final ArrayList<Estadistica> lista;

    public EstadisticaAdapter(ArrayList<Estadistica> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_estadistica, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Estadistica estadistica = lista.get(position);

        holder.imgIcono.setImageResource(estadistica.getIcono());
        holder.txtValor.setText(estadistica.getValor());
        holder.txtTitulo.setText(estadistica.getTitulo());

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgIcono;
        TextView txtValor;
        TextView txtTitulo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgIcono = itemView.findViewById(R.id.imgIcono);
            txtValor = itemView.findViewById(R.id.txtValor);
            txtTitulo = itemView.findViewById(R.id.txtTitulo);
        }
    }
}