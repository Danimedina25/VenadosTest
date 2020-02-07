package com.example.equipo.venadostest.Models.Models

import com.example.equipo.venadostest.Models.Models.players.Data
import com.google.gson.annotations.SerializedName

data class Datos_Players (@SerializedName("success") var success:Boolean, @SerializedName("data") var data: Data)



