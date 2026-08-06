package com.example.gymrat.Api;

import com.example.gymrat.Models.Objetivo;

import java.lang.annotation.Target;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ObjetivoApi {
    @GET("api/objetivos")
    Call<List<Objetivo>> obtenerObjetivos();

}
