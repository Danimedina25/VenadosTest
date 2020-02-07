package com.example.equipo.venadostest

import android.widget.ImageView
import com.squareup.picasso.Picasso
//Función que utiliza a la librería Picasso, para mostrar en un ImageView de un layout, la imagen descargada de una url
fun ImageView.fromUrl(url:String){
    Picasso.get().load(url).into(this)
}
