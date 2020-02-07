package com.example.equipo.venadostest

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.equipo.venadostest.Adapters.ViewPagerAdapter
import com.example.equipo.venadostest.Fragments.Estadisticas
import com.example.equipo.venadostest.Fragments.Jugadores
import com.example.equipo.venadostest.Fragments.ascensoMX
import com.example.equipo.venadostest.Fragments.copaMX
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.contenido_recycler_players.*
import kotlinx.android.synthetic.main.content_home.*

class Home : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var viewPager:ViewPager?=null
    var tabLayout:TabLayout?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)
        viewPager=findViewById(R.id.viewpager)
        tabLayout=findViewById(R.id.tabs)
        configurarViewPager()
        tabLayout?.setupWithViewPager(viewPager)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)



    }
    //Se crean y se configuran los fragmentos que mostrarán los datos de los partidos en el menú home, copa mx y ascenso mx respectivamente.
    fun configurarViewPager(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(copaMX(),"COPA MX")
        adapter.addFragment(ascensoMX(),"ASCENSO MX")
        viewPager?.adapter = adapter

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    @RequiresApi(29)
    @SuppressLint("ResourceType")
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.home -> {
                val intent = Intent(this,Home::class.java)
                startActivity(intent)

            }
            R.id.estadisticas -> {
                tabs.visibility=View.GONE
                escudo.visibility=View.GONE

                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.contenedor, Estadisticas())
                    .commit()
            }
            R.id.jugadores -> {
                tabs.visibility=View.GONE
                escudo.visibility=View.GONE

                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.contenedor,Jugadores())
                    .commit()
               // val intent = Intent(this,Jugadores2::class.java)
               // startActivity(intent)


            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
