package com.example.equipo.venadostest.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.equipo.venadostest.Adapters.GamesAdapter_ascMX
import com.example.equipo.venadostest.Models.Models.games.Data
import com.example.equipo.venadostest.Models.Models.Datos_Games
import com.example.equipo.venadostest.Models.Models.games.Games
import com.example.equipo.venadostest.R
import com.example.equipo.venadostest.RetrofitService_games
import kotlinx.android.synthetic.main.fragment_copa_mx.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ascensoMX.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ascensoMX.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ascensoMX : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var layoutManager: LinearLayoutManager
    lateinit var dataList : Data
    lateinit var gamesList:List<Games>
    var gamesListFinal:ArrayList<Games> = ArrayList()
    lateinit var gamesAdapterASCMX: GamesAdapter_ascMX
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        obtenerDatos("games")
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ascenso_mx, container, false)
        swipeRefreshLayout.setOnRefreshListener(){
            obtenerDatos("games")
        }

    }
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://venados.dacodes.mx/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    private fun obtenerDatos(query: String) {
        doAsync {

            val call = getRetrofit().create(RetrofitService_games::class.java).getDataGames("$query").execute()
            val todo = call.body() as Datos_Games
            Log.d("TAG",todo.toString())
            uiThread {
                if(todo.success == true) {
                    initCharacter(todo)
                }



            }
        }
    }
    private fun initCharacter(listDatosGames2: Datos_Games) {
        if (listDatosGames2.success == true){
            dataList=listDatosGames2.data
            gamesList = dataList.games!!
            for (item in gamesList ){
                if (item.league.equals("Ascenso MX")){
                    gamesListFinal.add(item)
                }
            }
        }



        gamesAdapterASCMX = GamesAdapter_ascMX(gamesListFinal)
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = gamesAdapterASCMX
        swipeRefreshLayout.isRefreshing = false


    }


}
