package com.example.equipo.venadostest

import com.example.equipo.venadostest.Models.Models.Datos_Players
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Url

interface RetrofitService_players {
    @Headers("Accept: application/json")
    @GET
    fun getDataPlayers(@Url players:String): Call<Datos_Players>

}