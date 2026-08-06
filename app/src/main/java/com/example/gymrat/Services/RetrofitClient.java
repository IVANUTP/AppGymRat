package com.example.gymrat.Services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    // Si usas el emulador de Android
    private static final String BASE_URL = "http://10.0.2.2:8585/";

    // Si usas un celular físico, cambia por la IP de tu PC
    // private static final String BASE_URL = "http://192.168.1.100:8585/";

    private static Retrofit retrofit;

    public static Retrofit getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}