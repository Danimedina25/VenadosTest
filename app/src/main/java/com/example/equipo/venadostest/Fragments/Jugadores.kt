package com.example.equipo.venadostest.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.equipo.venadostest.Adapters.GamesAdapter_Jugadores
import com.example.equipo.venadostest.Models.Models.players.Data
import com.example.equipo.venadostest.Models.Models.players.dataPlayers
import com.example.equipo.venadostest.Models.Models.players.dataTeam
import com.example.equipo.venadostest.R
import com.example.equipo.venadostest.RetrofitService_players
import com.example.equipo.venadostest.Models.Models.Datos_Players
import kotlinx.android.synthetic.main.fragment_jugadores.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Jugadores.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Jugadores.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class Jugadores : Fragment() {
    // TODO: Rename and change types of parameters

    lateinit var layoutManager: LinearLayoutManager
    lateinit var dataList : Data
    lateinit var dataTeam : dataTeam
    lateinit var playersList:List<dataPlayers>
    val playerListfinal:ArrayList<dataPlayers> = ArrayList()
    lateinit var gamesAdapter_Jugadores: GamesAdapter_Jugadores
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        obtenerDatos("players")

        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jugadores, container, false)

    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://venados.dacodes.mx/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    private fun obtenerDatos(query: String) {
        doAsync {

            val call = getRetrofit().create(RetrofitService_players::class.java).getDataPlayers("$query").execute()
            val todo = call.body() as Datos_Players
            Log.d("TAG",todo.toString())
            uiThread {
                if(todo.success == true) {
                    initCharacter(todo)
                }

            }
        }
    }
    private fun initCharacter(listDatosPlayers: Datos_Players) {
        if (listDatosPlayers.success == true){
            dataList=listDatosPlayers.data
            dataTeam = dataList.team!!

          playersList = dataTeam.defenses!!+dataTeam.centers!!+dataTeam.forwards!!+dataTeam.goalkeepers!!


        }



        gamesAdapter_Jugadores = GamesAdapter_Jugadores(context, playersList)
        rv_players.setHasFixedSize(true)
        rv_players.layoutManager = GridLayoutManager(context,3)
        rv_players.adapter = gamesAdapter_Jugadores



    }
}


