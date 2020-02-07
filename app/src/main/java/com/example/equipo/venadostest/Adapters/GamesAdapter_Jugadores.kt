package com.example.equipo.venadostest.Adapters

import android.app.Dialog
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.InputFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.equipo.venadostest.Models.Models.players.dataPlayers
import com.example.equipo.venadostest.R
import com.example.equipo.venadostest.fromUrl
import kotlinx.android.synthetic.main.contenido_recycler_players.view.*
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.ficha_tecnica.view.*


class GamesAdapter_Jugadores (val context: Context?, val players: List<dataPlayers>) : RecyclerView.Adapter<GamesAdapter_Jugadores.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = players[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            layoutInflater.inflate(
                R.layout.contenido_recycler_players,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return players.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        fun bind(dataplayers: dataPlayers) {

            itemView.imagen.fromUrl(dataplayers.image.toString())
            itemView.nombre_jugador.text=dataplayers.name+" "+dataplayers.first_surname
            itemView.posicion_jugador.text=dataplayers.position.toString()

            itemView.imagen.setOnClickListener {

                val dialog = Dialog(itemView.context)
                dialog .requestWindowFeature(Window.FEATURE_NO_TITLE)
                dialog .setCancelable(false)
                dialog .setContentView(R.layout.ficha_tecnica)
                val foto_jugador = dialog .findViewById(R.id.foto_jugador) as ImageView
                val nombre_jugador = dialog .findViewById(R.id.nombre) as TextView
                val posicion_jugador = dialog .findViewById(R.id.posicion) as TextView
                val fecha_nac = dialog .findViewById(R.id.fecha_nac) as TextView
                val lugar_nac = dialog .findViewById(R.id.lugar_nac) as TextView
                val peso = dialog .findViewById(R.id.peso) as TextView
                val altura = dialog .findViewById(R.id.altura) as TextView
                val equipo_anterior = dialog .findViewById(R.id.equipo_anterior) as TextView
                val regresar = dialog.findViewById(R.id.regresar) as Button

                foto_jugador.fromUrl(dataplayers.image.toString())
                nombre_jugador.text = dataplayers.name+" "+dataplayers.first_surname+" "+dataplayers.second_surname
                posicion_jugador.text = dataplayers.position

                fecha_nac.text = dataplayers.birthday?.split("T")!![0]
                lugar_nac.text = dataplayers.birth_place
                peso.text=dataplayers.weight.toString()
                altura.text = dataplayers.height.toString()
                equipo_anterior.text = dataplayers.last_team

                dialog.show()

                regresar.setOnClickListener {
                    dialog.dismiss()
                }



            }



        }

    }


}