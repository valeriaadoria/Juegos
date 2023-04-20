package edu.iest.juegos.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import edu.iest.juegos.R
import edu.iest.juegos.activity_lista_juegos
import edu.iest.juegos.models.Videojuego

class VideojuegoAdapter(videojuegos: ArrayList<Videojuego>, context: Context) : RecyclerView.Adapter<VideojuegoAdapter.ContenedorDeVista>(){
    var innerVideojuegos: ArrayList<Videojuego> = videojuegos
    var innerContext: Context = context

    inner class ContenedorDeVista(view: View) :
    RecyclerView.ViewHolder(view), View.OnClickListener {
        //Aqui haremos el inflate de layout
        //Aqui haremos la asignacion de objetos
        val tvNombre : TextView
        val tvPrecio : TextView
        val tvConsola : TextView
        val tvClasif : TextView
        val ivFoto : ImageView
        val bnCompra : Button


        init{
            //Define click listener for the ViewHolder´s view
            tvNombre = view.findViewById(R.id.nombre)
            tvPrecio = view.findViewById(R.id.precio)
            tvClasif = view.findViewById(R.id.clasif)
            ivFoto = view.findViewById(R.id.iMario)
            tvConsola = view.findViewById(R.id.consola)
            bnCompra = view.findViewById(R.id.bnComprar)

            bnCompra.setOnClickListener(this)
        }


        override fun onClick(p0: View?) {

            val EDAD_KEY = "edad"
            var edad: Int = 0



            // Obtener el valor extra del Intent
        //    val edad2 = intent.getStringExtra("edad")
            // Hacer algo con el valor extra...

            if (adapterPosition>=0){
                val videojuego: Videojuego = innerVideojuegos.get(adapterPosition)
                videojuego.nombre
                videojuego.clasificacion
                videojuego.precio

                val clasif : String = videojuego.clasificacion

                val miSharedPreferences = innerContext.getSharedPreferences("PERSISTENCIA",
                    AppCompatActivity.MODE_PRIVATE
                )
                edad=miSharedPreferences.getString(EDAD_KEY,"21").toString().toInt()

                if (edad>=18){
                    //logica con el dato
                    Toast.makeText(innerContext, "Seleccionaste "+ videojuego.nombre, Toast.LENGTH_SHORT).show()
                    bnCompra.text="Adquirido"
                    bnCompra.isEnabled = false
                }
                if (edad<=5){
                    if(clasif=="E+"){
                        //logica con el dato
                        Toast.makeText(innerContext, "Seleccionaste "+ videojuego.nombre, Toast.LENGTH_SHORT).show()
                        bnCompra.text="Adquirido"
                        bnCompra.isEnabled = false
                    }else{
                        Toast.makeText(innerContext, "Intentalo con un juego de clasificacion E+ ", Toast.LENGTH_SHORT).show()
                    }
                }
                if (edad in 6..17){
                    if(clasif=="R"){
                        //logica con el dato
                        Toast.makeText(innerContext, "La clasificacion R es para mayores de edad ", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(innerContext, "Seleccionaste "+ videojuego.nombre, Toast.LENGTH_SHORT).show()
                        bnCompra.text="Adquirido"
                        bnCompra.isEnabled = false
                    }
                }

            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContenedorDeVista {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.activity_juego,parent,false)
        return ContenedorDeVista(view)
    }

    override fun onBindViewHolder(holder: ContenedorDeVista, position: Int) {
        val videojuego: Videojuego = innerVideojuegos.get(position)
        holder.tvNombre.text = videojuego.nombre
        holder.tvConsola.text = videojuego.consola
        holder.tvPrecio.text = videojuego.precio.toString()
        holder.tvClasif.text = videojuego.clasificacion
        holder.ivFoto.setImageResource(videojuego.imagen)
    }

    override fun getItemCount(): Int {
        return innerVideojuegos.size
    }

}
