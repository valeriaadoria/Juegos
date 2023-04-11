package edu.iest.juegos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.iest.juegos.adapter.VideojuegoAdapter
import edu.iest.juegos.models.FakerVideojuego

class activity_lista_juegos : AppCompatActivity() {
    private lateinit var FAB: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_juegos)

        val juegos = FakerVideojuego().getVideogames()
        val recycler = findViewById<RecyclerView>(R.id.recyclerJuegos)

        val CANTIDAD_COLUMNAS = 1

        //VERTICAl
        //var administradorDeLayouts =  LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        /*horizontal
        administradorDeLayouts =  LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)*/

        var administradorDeLayouts = GridLayoutManager(this,CANTIDAD_COLUMNAS)
        recycler.layoutManager = administradorDeLayouts
        recycler.adapter = VideojuegoAdapter(juegos, this)

        FAB= findViewById(R.id.fab)

        FAB.setOnClickListener {
            val i = Intent(this, preferencias::class.java)
            startActivity(i)
        }

    }



}