package edu.iest.juegos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.iest.juegos.adapter.VideojuegoAdapter
import edu.iest.juegos.models.FakerVideojuego

class activity_lista_juegos : AppCompatActivity() {
    private lateinit var FAB: FloatingActionButton
    private var CantColum: Int =1


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.pantalla, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val juegos = FakerVideojuego().getVideogames()
        val recycler = findViewById<RecyclerView>(R.id.recyclerJuegos)
        var administradorDeLayouts = GridLayoutManager(this,CantColum)
        recycler.layoutManager = administradorDeLayouts
        recycler.adapter = VideojuegoAdapter(juegos, this)

        if (item.itemId == R.id.vertical) {
            var administradorDeLayouts =  LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            recycler.layoutManager = administradorDeLayouts
            recycler.adapter = VideojuegoAdapter(juegos, this)
        }
        if (item.itemId == R.id.horizontal) {
            var administradorDeLayouts =  LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            recycler.layoutManager = administradorDeLayouts
            recycler.adapter = VideojuegoAdapter(juegos, this)
        }
        if (item.itemId == R.id.doscolum) {
            CantColum=2
            var administradorDeLayouts = GridLayoutManager(this,CantColum)
            recycler.layoutManager = administradorDeLayouts
            recycler.adapter = VideojuegoAdapter(juegos, this)
        }

        if (item.itemId == R.id.trescolum) {
            CantColum=3
            var administradorDeLayouts = GridLayoutManager(this,CantColum)
            recycler.layoutManager = administradorDeLayouts
            recycler.adapter = VideojuegoAdapter(juegos, this)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_juegos)

        val juegos = FakerVideojuego().getVideogames()
        val recycler = findViewById<RecyclerView>(R.id.recyclerJuegos)

        var administradorDeLayouts = GridLayoutManager(this,CantColum)
        recycler.layoutManager = administradorDeLayouts
        recycler.adapter = VideojuegoAdapter(juegos, this)

        FAB= findViewById(R.id.fab)

        FAB.setOnClickListener {
            val i = Intent(this, preferencias::class.java)
            startActivity(i)
        }

    }



}