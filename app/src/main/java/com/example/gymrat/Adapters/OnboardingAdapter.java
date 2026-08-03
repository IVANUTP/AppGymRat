package com.example.gymrat.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymrat.Models.OnboardingSlide;
import com.example.gymrat.R;

import java.util.List;

public class OnboardingAdapter extends RecyclerView.Adapter<OnboardingAdapter.ViewHolder> {

    private final List<OnboardingSlide> slides;

    public OnboardingAdapter(List<OnboardingSlide> slides) {
        this.slides = slides;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_onboarding_slide, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OnboardingSlide slide = slides.get(position);
        holder.txtTitulo.setText(slide.getTitulo());
        holder.txtDescripcion.setText(slide.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return slides.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitulo;
        TextView txtDescripcion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitulo = itemView.findViewById(R.id.txtTituloSlide);
            txtDescripcion = itemView.findViewById(R.id.txtDescripcionSlide);
        }
    }
}