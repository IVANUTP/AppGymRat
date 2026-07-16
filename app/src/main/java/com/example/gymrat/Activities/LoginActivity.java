package com.example.gymrat.Activities;

<<<<<<< HEAD
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
=======
import android.os.Build;
import android.os.Bundle;
>>>>>>> 6efa31edf0083443c77a5059605931784a1f614a

import androidx.appcompat.app.AppCompatActivity;

import com.example.gymrat.R;
<<<<<<< HEAD
import com.google.android.material.button.MaterialButton;
=======
>>>>>>> 6efa31edf0083443c77a5059605931784a1f614a

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

<<<<<<< HEAD
        TextView txtRegistro = findViewById(R.id.txtRegistro);
        MaterialButton btnLogin = findViewById(R.id.btnLogin);

        txtRegistro.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish(); // así no puede regresar al login con el botón "atrás"
        });

=======
>>>>>>> 6efa31edf0083443c77a5059605931784a1f614a
    }
}