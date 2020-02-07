package com.example.equipo.venadostest.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.equipo.venadostest.Models.Models.games.Games
import com.example.equipo.venadostest.R
import com.example.equipo.venadostest.fromUrl
import kotlinx.android.synthetic.main.contenido_recycler_games.view.*


class GamesAdapter_ascMX (val games: List<Games>) : RecyclerView.Adapter<GamesAdapter_ascMX.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = games[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            layoutInflater.inflate(
                R.layout.contenido_recycler_games,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return games.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(datagames: Games) {
            if(datagames.league.equals("Ascenso MX")){
                itemView.contenido_recycler.visibility = View.VISIBLE
                if (datagames.datetime!!.split("-")[1]=="01"){
                    itemView.mes.text = "ENERO"
                }
                else if(datagames.datetime!!.split("-")[1]=="02"){
                    itemView.mes.text = "FEBRERO"
                }
                else if(datagames.datetime!!.split("-")[1]=="03"){
                    itemView.mes.text = "MARZO"
                }
                else if(datagames.datetime!!.split("-")[1]=="04"){
                    itemView.mes.text = "ABRIL"
                }
                else if(datagames.datetime!!.split("-")[1]=="05"){
                    itemView.mes.text = "MAYO"
                }
                else if(datagames.datetime!!.split("-")[1]=="06"){
                    itemView.mes.text = "JUNIO"
                }
                else if(datagames.datetime!!.split("-")[1]=="07"){
                    itemView.mes.text = "JULIO"
                }
                else if(datagames.datetime!!.split("-")[1]=="08"){
                    itemView.mes.text = "AGOSTO"
                }
                else if(datagames.datetime!!.split("-")[1]=="09"){
                    itemView.mes.text = "SEPTIEMBRE"
                }
                else if(datagames.datetime!!.split("-")[1]=="10"){
                    itemView.mes.text = "OCTUBRE"
                }
                else if(datagames.datetime!!.split("-")[1]=="11"){
                    itemView.mes.text = "NOVIEMBRE"
                }
                else if(datagames.datetime!!.split("-")[1]=="12"){
                    itemView.mes.text = "DICIEMBRE"
                }

                itemView.resultado_equipo1.text=datagames.home_score.toString()
                itemView.resultado_equipo2.text=datagames.away_score.toString()


                if (datagames.local==true){
                    itemView.equipo1.setBackgroundResource(R.drawable.escudo)
                    itemView.equipo2.fromUrl(datagames.opponent_image.toString())
                    itemView.nombre_equipo1.text = "Venados F.C."
                    itemView.nombre_equipo2.text=datagames.opponent
                }else if (datagames.local==false){
                    itemView.equipo2.setBackgroundResource(R.drawable.escudo)
                    itemView.equipo1.fromUrl(datagames.opponent_image.toString())
                    itemView.nombre_equipo2.text = "Venados F.C."
                    itemView.nombre_equipo1.text=datagames.opponent
                }

            }else if (datagames.league.equals("Copa MX")){
                itemView.contenido_recycler.visibility = View.GONE

            }



        }
    }


}