package edu.iest.juegos.models

import edu.iest.juegos.R

class FakerVideojuego {
    fun getVideogames() : ArrayList<Videojuego>{
        val videogames : ArrayList<Videojuego>
        videogames = arrayListOf<Videojuego>()

        val videojuego = Videojuego(1, "Mario Bros",1600F, "Nintendo", "E+",R.drawable.mario)
        videogames.add(videojuego)
        videogames.add(Videojuego(2, "Tales of the Abbys",1600F, "PS2", "R",R.drawable.abyss))
        videogames.add(Videojuego(3, "Resident Evil 4 Remaster",1600F, "PS5","R", R.drawable.game04))
        videogames.add(Videojuego(4, "Minecraft",1600F, "PC", "E+",R.drawable.minecraft))
        videogames.add(Videojuego(5, "Halo",1600F, "XBOX","T", R.drawable.halo))
        videogames.add(Videojuego(6, "SackBoy",1600F, "PS4","E+", R.drawable.sackboy))
        videogames.add(Videojuego(7, "Overwatch",1600F, "XBOX N","T", R.drawable.overwatch))
        return videogames
    }
}