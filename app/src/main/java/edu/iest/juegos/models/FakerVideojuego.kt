package edu.iest.juegos.models

import edu.iest.juegos.R

class FakerVideojuego {
    fun getVideogames() : ArrayList<Videojuego>{
        val videogames : ArrayList<Videojuego>
        videogames = arrayListOf<Videojuego>()

        val videojuego = Videojuego(1, "Mario Bros",1600F, "Nintendo", R.drawable.mario)
        videogames.add(videojuego)
        videogames.add(Videojuego(2, "Tales of the Abbys",1600F, "PS2", R.drawable.abyss))
        videogames.add(Videojuego(3, "Resident Evil 4 Remaster",1600F, "PS5", R.drawable.game04))
        videogames.add(Videojuego(4, "Minecraft",1600F, "PC", R.drawable.minecraft))
        videogames.add(Videojuego(5, "Halo",1600F, "XBOX", R.drawable.halo))
        videogames.add(Videojuego(6, "SackBoy",1600F, "PS4", R.drawable.sackboy))
        videogames.add(Videojuego(7, "Overwatch",1600F, "XBOX N", R.drawable.overwatch))
        return videogames
    }
}