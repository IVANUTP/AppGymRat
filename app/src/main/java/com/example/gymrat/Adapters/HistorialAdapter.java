package com.example.gymrat.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymrat.Models.Historial;
import com.example.gymrat.R;

import java.util.ArrayList;

public class HistorialAdapter extends RecyclerView.Adapter<HistorialAdapter.ViewHolder> {

    private final ArrayList<Historial> lista;

    public HistorialAdapter(ArrayList<Historial> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_historial, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Historial historial = lista.get(position);

        holder.txtDia.setText(historial.getDia());
        holder.txtMes.setText(historial.getMes());
        holder.txtRutina.setText(historial.getRutina());
        holder.txtDuracion.setText(historial.getDuracion());
        holder.txtVolumen.setText(historial.getVolumen());
        holder.txtMejora.setText(historial.getMejora());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtDia;
        TextView txtMes;
        TextView txtRutina;
        TextView txtDuracion;
        TextView txtVolumen;
        TextView txtMejora;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtDia = itemView.findViewById(R.id.txtDia);
            txtMes = itemView.findViewById(R.id.txtMes);
            txtRutina = itemView.findViewById(R.id.txtRutina);
            txtDuracion = itemView.findViewById(R.id.txtDuracion);
            txtVolumen = itemView.findViewById(R.id.txtVolumen);
            txtMejora = itemView.findViewById(R.id.txtMejora);
        }
    }
}