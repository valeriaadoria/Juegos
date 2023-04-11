package edu.iest.juegos

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class preferencias : AppCompatActivity() {
    private val NOMBRE_KEY = "nombre"
    private val EDAD_KEY = "edad"
    private val ALTURA_KEY = "altura"
    private val PRESUPUESTO_KEY = "presupuesto"
    private val SWITCH_KEY = "'switch_estado'"
    private val NOMBRE_INSTANCIA = "nombre_instancia"
    private var nombre: String = ""
    private var edad: String = ""
    private var altura: String = ""
    private var presupuesto: String = ""

    private lateinit var tvname: TextView
    private lateinit var tvage: TextView
    private lateinit var tvheigh: TextView
    private lateinit var tvbudget: TextView
    private lateinit var bnback: Button

    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferencias)

        tvname=findViewById(R.id.name)
        tvage=findViewById(R.id.age)
        tvheigh=findViewById(R.id.heigh)
        tvbudget=findViewById(R.id.budget)

        val miSharedPreferences = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
        nombre=miSharedPreferences.getString(NOMBRE_KEY,"valeria").toString()
        tvname.text="Nombre: "+ nombre
        edad=miSharedPreferences.getString(EDAD_KEY,"21").toString()
        tvage.text="Edad: " + edad
        altura=miSharedPreferences.getString(ALTURA_KEY,"21").toString()
        tvheigh.text= "Estatura: " + altura
        presupuesto=miSharedPreferences.getString(PRESUPUESTO_KEY,"21").toString()
        tvbudget.text="$ " + presupuesto

        bnback = findViewById(R.id.back)

        bnback.setOnClickListener{
            val i = Intent(this, activity_lista_juegos::class.java)
            startActivity(i)
        }



    }
}