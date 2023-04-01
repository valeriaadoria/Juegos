package edu.iest.juegos

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {
    private lateinit var tvBienvenido: TextView
    private lateinit var etNombre: EditText
    private lateinit var etEdad: EditText
    private lateinit var etAltura: EditText
    private lateinit var etPresupuesto: EditText
    private lateinit var bnGuardar: Button
    private lateinit var switchPreferencias: SwitchCompat
    private val NOMBRE_KEY = "nombre"
    private val EDAD_KEY = "edad"
    private val ALTURA_KEY = "altura"
    private val PRESUPUESTO_KEY = "presupuesto"
    private val SWITCH_KEY = "'switch_estado'"
    private val NOMBRE_INSTANCIA = "nombre_instancia"
    private var nombre: String = ""
    private var edad: Int = 0
    private var altura: Float = 0.0F
    private var presupuesto: Float = 0.0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("PREFERENCIAS", "onCreate")
        setContentView(R.layout.activity_main)

        var actionBar: ActionBar?
        actionBar = supportActionBar
        var colorDrawable: ColorDrawable
        colorDrawable = ColorDrawable(Color.parseColor("#FF018786"))
        actionBar!!.setBackgroundDrawable(colorDrawable)

        inicializarVistas()

        Log.d("PREFERENCIAS",savedInstanceState?.getString(NOMBRE_KEY).toString())
        Log.d("PREFERENCIAS",savedInstanceState?.getString(EDAD_KEY).toString())
        Log.d("PREFERENCIAS",savedInstanceState?.getString(ALTURA_KEY).toString())
        Log.d("PREFERENCIAS",savedInstanceState?.getString(PRESUPUESTO_KEY).toString())

    /*    etNombre = findViewById(R.id.etNombre)

        val bnGuardar= findViewById<Button>(R.id.bnGuardar)
        bnGuardar.setOnClickListener{
            val nombre = etNombre.text.toString()
            val i = Intent(this, juego::class.java)
            i.putExtra("nombre", nombre)
            startActivity(i)


    }*/
    }
    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("PREFERENCIAS", "onSaveInstanceState")
        outState.putString(NOMBRE_KEY, nombre )
        outState.putString(EDAD_KEY, edad.toString())
        outState.putString(ALTURA_KEY, altura.toString())
        outState.putString(PRESUPUESTO_KEY, presupuesto.toString())

        outState.run {
            putString(NOMBRE_KEY, nombre)
            putString(EDAD_KEY, edad.toString())
            putString(ALTURA_KEY, altura.toString())
            putString(PRESUPUESTO_KEY, presupuesto.toString())
        }
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState)

    }


    override fun onResume() {
        Log.d("PREFERENCIAS","onResume")
        if(TextUtils.isEmpty(nombre)){
            val miSharedPreferences = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
            nombre=miSharedPreferences.getString(NOMBRE_KEY,"").toString()
        }
        tvBienvenido.text =nombre
        super.onResume()
    }

    override fun onStart() {
        Log.d("PREFERENCIAS","onStart")
        super.onStart()
    }

    override fun onPause() {
        Log.d("PREFERENCIAS","onPause")
        super.onPause()
    }

    override fun onDestroy() {
        Log.d("PREFERENCIAS","onDestroy")
        super.onDestroy()
    }

    private fun cambiarTextoBienvenida(nombre: String, edad: Int) {
        if (!TextUtils.isEmpty(nombre)) {
            tvBienvenido.text = "Bienvenido " + nombre + " " +edad
        }
    }

    private fun inicializarVistas() {
        tvBienvenido = findViewById(R.id.tvBienvenido)
        etNombre = findViewById(R.id.etNombre)
        etEdad = findViewById(R.id.etEdad)
        bnGuardar = findViewById(R.id.bnGuardar)
        switchPreferencias = findViewById(R.id.switchPreferencias)

     /*   if(switchPreferencias.isChecked){
            //esta activado
            nombre= "VAleria"
        }else{
            nombre= "VAleria"
        }
        */

        bnGuardar.setOnClickListener {
            nombre = etNombre.text.toString()
            edad = etEdad.text.toString().toInt()
            cambiarTextoBienvenida(nombre,edad)
            val miSharedPreferences = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
            val editor = miSharedPreferences.edit()
            editor.putString(NOMBRE_KEY, nombre)
            editor.apply()
           // val i = Intent(this, activity_lista_juegos::class.java)

        //    startActivity(i)
        }
    }


}