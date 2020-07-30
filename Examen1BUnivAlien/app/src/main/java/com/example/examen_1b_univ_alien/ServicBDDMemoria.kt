package com.example.examen_1b_univ_alien

import android.os.Bundle
import android.util.Log
import android.widget.AdapterView

class ServicBDDMemoria {

    companion object {

        fun ListaAliensLlena() : ArrayList<Alien> {

            val listaAlien = arrayListOf<Alien>()
            listaAlien.add(Alien("Omicroniano", 2.23F, 50.4, 25, true, "universo-A-554"))
            listaAlien.add(Alien("Kitsune", 1.9F, 30.7, 21, false, "universo-B-32"))
            listaAlien.add(Alien("Omicroniano", 2.23F, 50.4, 25, true, "universo-A-554"))
            listaAlien.add(Alien("Kitsune", 1.9F, 30.7, 21, false, "universo-B-32"))
            listaAlien.add(Alien("Omicroniano", 2.23F, 50.4, 25, true, "universo-A-554"))
            listaAlien.add(Alien("Kitsune", 1.9F, 30.7, 21, false, "universo-B-32"))
            listaAlien.add(Alien("Omicroniano", 2.23F, 50.4, 25, true, "universo-A-554"))
            listaAlien.add(Alien("Kitsune", 1.9F, 30.7, 21, false, "universo-B-32"))
            listaAlien.add(Alien("Omicroniano", 2.23F, 50.4, 25, true, "universo-A-554"))
            listaAlien.add(Alien("Kitsune", 1.9F, 30.7, 21, false, "universo-B-32"))
        return listaAlien
        }
    }
}