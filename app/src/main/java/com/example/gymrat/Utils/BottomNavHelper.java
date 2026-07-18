package com.example.gymrat.Utils;

import android.app.Activity;
import android.content.Intent;

import com.example.gymrat.Activities.EntrenamientoActivity;
import com.example.gymrat.Activities.HomeActivity;
import com.example.gymrat.Activities.PerfilActivity;
import com.example.gymrat.Activities.ProgresoActivity;
import com.example.gymrat.Activities.RutinasActivity;
import com.example.gymrat.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavHelper {

    public static void setupBottomNav(Activity activity,
                                      BottomNavigationView navigation,
                                      int selectedItemId) {

        navigation.setSelectedItemId(selectedItemId);

        navigation.setOnItemSelectedListener(item -> {

            int id = item.getItemId();

            if (id == selectedItemId) {
                return true;
            }

            Intent intent = null;

            if (id == R.id.nav_home) {
                intent = new Intent(activity, HomeActivity.class);
            } else if (id == R.id.nav_rutinas) {
                intent = new Intent(activity, RutinasActivity.class);
            } else if (id == R.id.nav_entrenar) {
                intent = new Intent(activity, EntrenamientoActivity.class);
            } else if (id == R.id.nav_progreso) {
                intent = new Intent(activity, ProgresoActivity.class);
            } else if (id == R.id.nav_perfil) {
                intent = new Intent(activity, PerfilActivity.class);
            }

            if (intent != null) {
                activity.startActivity(intent);
                activity.overridePendingTransition(0, 0);
                activity.finish();
                return true;
            }

            return false;
        });
    }
}
