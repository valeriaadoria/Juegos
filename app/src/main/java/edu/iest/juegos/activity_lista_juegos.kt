package edu.iest.juegos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.iest.juegos.adapter.VideojuegoAdapter
import edu.iest.juegos.models.FakerVideojuego

class activity_lista_juegos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_juegos)

        val juegos = FakerVideojuego().getVideogames()
        val recycler = findViewById<RecyclerView>(R.id.recyclerJuegos)

        val CANTIDAD_COLUMNAS = 2
        var administradorDeLayouts =  LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        administradorDeLayouts =  LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)

        administradorDeLayouts = GridLayoutManager(this,CANTIDAD_COLUMNAS)
        recycler.layoutManager = administradorDeLayouts
        recycler.adapter = VideojuegoAdapter(juegos, this)

    }
}