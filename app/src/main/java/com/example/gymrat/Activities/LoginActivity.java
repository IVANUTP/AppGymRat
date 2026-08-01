package com.example.gymrat.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.gymrat.R;
import com.google.android.material.button.MaterialButton;


public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        TextView txtRegistro = findViewById(R.id.txtRegistro);
        MaterialButton btnLogin = findViewById(R.id.btnLogin);



        // Ir a registro
        txtRegistro.setOnClickListener(v -> {

            Intent intent = new Intent(
                    LoginActivity.this,
                    RegisterActivity.class
            );

            startActivity(intent);

        });



        // Entrar a la app
        btnLogin.setOnClickListener(v -> {

            Intent intent = new Intent(
                    LoginActivity.this,
                    HomeActivity.class
            );

            startActivity(intent);

            finish();

        });


    }

}