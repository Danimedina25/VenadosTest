package com.example.equipo.venadostest.Adapters

import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.equipo.venadostest.Models.Models.games.Games
import com.example.equipo.venadostest.Models.Models.statistics.Statistics
import com.example.equipo.venadostest.R
import com.example.equipo.venadostest.fromUrl
import kotlinx.android.synthetic.main.contenido_recycler_games.view.*


class GamesAdapter_statistics (val statistics: List<Statistics>) : RecyclerView.Adapter<GamesAdapter_statistics.ViewHolder>() {

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = statistics[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            layoutInflater.inflate(
                R.layout.contenido_recycler_statistics,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return statistics.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        @RequiresApi(Build.VERSION_CODES.P)
        fun bind(datastatistics: Statistics) {



        }
    }


}