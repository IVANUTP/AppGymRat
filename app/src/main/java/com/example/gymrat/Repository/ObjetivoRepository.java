package com.example.gymrat.Repository;

import com.example.gymrat.Api.ObjetivoApi;
import com.example.gymrat.Models.Objetivo;
import com.example.gymrat.Services.RetrofitClient;

import java.util.List;

import retrofit2.Call;

public class ObjetivoRepository {

    private final ObjetivoApi api;

    public ObjetivoRepository() {
        api = RetrofitClient.getClient().create(ObjetivoApi.class);
    }

    public Call<List<Objetivo>> obtenerObjetivos() {
        return api.obtenerObjetivos();
    }

}