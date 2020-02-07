package com.example.equipo.venadostest


import com.example.equipo.venadostest.Models.Models.Datos_Games
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Url
//Función de la librería Retrofit, que mediante el método get obtiene los datos de una url en formato json
interface RetrofitService_games {
    @Headers("Accept: application/json")
    @GET
    fun getDataGames(@Url games:String): Call<Datos_Games>

}