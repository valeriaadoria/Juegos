package edu.iest.juegos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var  nombre : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombre = findViewById(R.id.etNombre)

        val bnGuardar= findViewById<Button>(R.id.bnGuardar)
        bnGuardar.setOnClickListener{
            val nombre = nombre.text.toString()
            val i = Intent(this, juego::class.java)
            i.putExtra("nombre", nombre)
            startActivity(i)
        }
    }
}