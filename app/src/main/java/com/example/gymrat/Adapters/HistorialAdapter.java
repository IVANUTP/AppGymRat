package com.example.gymrat.Adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymrat.Models.Historial;
import com.example.gymrat.R;

import java.util.ArrayList;

public class HistorialAdapter extends RecyclerView.Adapter<HistorialAdapter.ViewHolder> {

    private static final String COLOR_POSITIVO = "#16A34A";
    private static final String COLOR_NEGATIVO = "#DC2626";

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

        // --- Lógica de mejora positiva/negativa ---
        String mejoraTexto = historial.getMejora(); // ej: "+8%" o "-3%"
        boolean esPositiva = !mejoraTexto.trim().startsWith("-");

        // Normalizamos el texto para que siempre tenga el signo +
        String valorLimpio = mejoraTexto.replace("+", "").replace("-", "").trim();
        holder.txtMejora.setText((esPositiva ? "+" : "-") + valorLimpio);

        if (esPositiva) {
            holder.badgeMejora.setBackgroundResource(R.drawable.bg_badge_mejora_positiva);
            holder.iconoTendencia.setImageResource(R.drawable.ic_trend_up);
            holder.iconoTendencia.setColorFilter(Color.parseColor(COLOR_POSITIVO));
            holder.txtMejora.setTextColor(Color.parseColor(COLOR_POSITIVO));
        } else {
            holder.badgeMejora.setBackgroundResource(R.drawable.bg_badge_mejora_negativa);
            holder.iconoTendencia.setImageResource(R.drawable.ic_trend_down);
            holder.iconoTendencia.setColorFilter(Color.parseColor(COLOR_NEGATIVO));
            holder.txtMejora.setTextColor(Color.parseColor(COLOR_NEGATIVO));
        }

        // Ocultamos el divisor en el último item para que no quede
        // una línea pegada al borde inferior de la card blanca
        boolean esUltimo = position == getItemCount() - 1;
        holder.divider.setVisibility(esUltimo ? View.GONE : View.VISIBLE);
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
        ImageView iconoTendencia;
        LinearLayout badgeMejora;
        View divider;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtDia = itemView.findViewById(R.id.txtDia);
            txtMes = itemView.findViewById(R.id.txtMes);
            txtRutina = itemView.findViewById(R.id.txtRutina);
            txtDuracion = itemView.findViewById(R.id.txtDuracion);
            txtVolumen = itemView.findViewById(R.id.txtVolumen);
            txtMejora = itemView.findViewById(R.id.txtMejora);
            iconoTendencia = itemView.findViewById(R.id.iconoTendencia);
            badgeMejora = itemView.findViewById(R.id.badgeMejora);
            divider = itemView.findViewById(R.id.divider);
        }
    }
}