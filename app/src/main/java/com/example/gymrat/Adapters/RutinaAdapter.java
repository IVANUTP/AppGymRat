package com.example.gymrat.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymrat.R;

import java.util.List;

public class RutinaAdapter extends RecyclerView.Adapter<RutinaAdapter.ViewHolder> {

    private final List<String> lista;

    public RutinaAdapter(List<String> lista) {
        this.lista = lista;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rutina, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        // Información estática
        holder.txtNombre.setText("Push");
        holder.txtDia.setText("Lunes");
        holder.txtEjercicios.setText("8");

        holder.txtSeries.setText("24");
        holder.txtDuracion.setText("70m");
        holder.txtEstado.setText("ACTIVA");
        holder.txtUltimoEntreno.setText("Último entrenamiento: Hace 2 días");
    }


    @Override
    public int getItemCount() {
        return lista.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombre;
        TextView txtDia;
        TextView txtEjercicios;
        TextView txtSeries;
        TextView txtDuracion;
        TextView txtEstado;
        TextView txtUltimoEntreno;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNombre = itemView.findViewById(R.id.txtNombreRutina);
            txtDia = itemView.findViewById(R.id.txtDia);

            txtEjercicios = itemView.findViewById(R.id.txtEjercicios);
            txtSeries = itemView.findViewById(R.id.txtSeries);
            txtDuracion = itemView.findViewById(R.id.txtDuracion);

            txtEstado = itemView.findViewById(R.id.txtEstado);
            txtUltimoEntreno = itemView.findViewById(R.id.txtUltimoEntreno);
        }
    }
}