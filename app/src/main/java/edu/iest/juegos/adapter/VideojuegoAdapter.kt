package edu.iest.juegos.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.iest.juegos.R
import edu.iest.juegos.models.Videojuego

class VideojuegoAdapter(videojuegos: ArrayList<Videojuego>, context: Context) : RecyclerView.Adapter<VideojuegoAdapter.ContenedorDeVista>(){
    var innerVideojuegos: ArrayList<Videojuego> = videojuegos
    var innerContext: Context = context

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
        val view= LayoutInflater.from(parent.context).inflate(R.layout.activity_juego,parent,false)
        return ContenedorDeVista(view)
    }

    override fun onBindViewHolder(holder: ContenedorDeVista, position: Int) {
        val videojuego: Videojuego = innerVideojuegos.get(position)
        holder.tvNombre.text = videojuego.nombre
        holder.tvConsola.text = videojuego.consola
        holder.tvPrecio.text = videojuego.precio.toString()
        holder.ivFoto.setImageResource(videojuego.imagen)
    }

    override fun getItemCount(): Int {
        return innerVideojuegos.size
    }

}
