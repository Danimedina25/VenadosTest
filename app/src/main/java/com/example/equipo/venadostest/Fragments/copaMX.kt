package com.example.equipo.venadostest.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.equipo.venadostest.Adapters.GamesAdapter_copaMX
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
 * [copaMX.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [copaMX.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class copaMX : Fragment() {
    // TODO: Rename and change types of parameters

    lateinit var layoutManager: LinearLayoutManager
    lateinit var dataList : Data
    lateinit var gamesList:List<Games>
    var gamesListFinal:ArrayList<Games> = ArrayList()
    lateinit var gamesAdapterCopaMX: GamesAdapter_copaMX

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//Se llama a la función que obtiene los datos de los partidos de copa MX y los manda al recyclerview para mostraros en pantalla
        obtenerDatos("games")


        arguments?.let {


        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_copa_mx, container, false)
        swipeRefreshLayout.setOnRefreshListener(){
            obtenerDatos("games")
        }

    }

//Función que utiliza a la librería Retrofit, para hacer la petición a la url y descargar los datos
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://venados.dacodes.mx/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

// Función que obtiene los datos, haciendo uso de la función getRetrofit
    private fun obtenerDatos(query: String) {

        doAsync {

            val call = getRetrofit().create(RetrofitService_games::class.java).getDataGames("$query").execute()
            val todo = call.body() as Datos_Games
            uiThread {
                if(todo.success == true) {
                    enviarAdaptador(todo)


                }



            }
        }
    }
    private fun enviarAdaptador(listDatosGames2: Datos_Games) {
        if (listDatosGames2.success == true){
            dataList=listDatosGames2.data
            gamesList = dataList.games!!

            for (item in gamesList ){
                if (item.league.equals("Copa MX")){
                    gamesListFinal.add(item)
                }
            }
        }



        gamesAdapterCopaMX = GamesAdapter_copaMX(gamesListFinal)
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = gamesAdapterCopaMX
        swipeRefreshLayout.isRefreshing = false




    }



}



