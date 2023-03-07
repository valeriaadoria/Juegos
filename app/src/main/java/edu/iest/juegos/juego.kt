package edu.iest.juegos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class juego : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)
        val nombre= intent.getStringExtra("nombre")
        Log.d("Datos","Nombre: $nombre")
    }
}