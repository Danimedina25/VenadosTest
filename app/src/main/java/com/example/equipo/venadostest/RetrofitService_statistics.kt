package com.example.equipo.venadostest


import com.example.equipo.venadostest.Models.Models.Datos_Statistics
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Url

interface RetrofitService_statistics {
    @Headers("Accept: application/json")
    @GET
    fun getDataGames(@Url statistics:String): Call<Datos_Statistics>

}