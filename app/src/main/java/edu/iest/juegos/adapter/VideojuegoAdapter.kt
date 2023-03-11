package edu.iest.juegos.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.iest.juegos.R
import edu.iest.juegos.models.Videojuego

class VideojuegoAdapter(videojuegos: ArrayList<Videojuego>, context: Context) : RecyclerView.Adapter<VideojuegoAdapter.ContenedorDeVista>(){
    var inner_videojuegos: ArrayList<Videojuego> = videojuegos
    var inner_context: Context = context

    inner class ContenedorDeVista(view: View) :
    RecyclerView.ViewHolder(view)   {
        //Aqui haremos el inflate de layout
        //Aqui haremos la asignacion de objetos
        val tvNombre : TextView
        val tvPrecio : TextView
        val tvConsola : TextView
        val ivFoto : ImageView
        val bnCompra : Button


        init{
            //Define click listener for the ViewHolder´s view
            tvNombre = view.findViewById(R.id.nombre)
            tvPrecio = view.findViewById(R.id.precio)
            ivFoto = view.findViewById(R.id.iMario)
            tvConsola = view.findViewById(R.id.consola)
            bnCompra = view.findViewById(R.id.bnComprar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContenedorDeVista {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ContenedorDeVista, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
