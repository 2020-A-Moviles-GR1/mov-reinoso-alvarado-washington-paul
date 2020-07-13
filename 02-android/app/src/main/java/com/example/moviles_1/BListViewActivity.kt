package com.example.moviles_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_b_list_view.*

class BListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_list_view)
        //arreglo de entrenadores
        val listaEntrenadores = arrayListOf<Entrenador>()

        listaEntrenadores.add(Entrenador("Paul","Reinoso"))
        listaEntrenadores.add(Entrenador("Francisco","Sanchez"))
        listaEntrenadores.add(Entrenador("Alex","herrera"))
        listaEntrenadores.add(Entrenador("Estevan","andaluz"))
        listaEntrenadores.add(Entrenador("Nicolas","carvajal"))
        listaEntrenadores.add(Entrenador("Karlita","Revelo"))
        listaEntrenadores.add(Entrenador("Nico","Ontaneda"))

        //
        val adaptador=ArrayAdapter(

            this,//contexto
            android.R.layout.simple_list_item_1,//nombre layout
            listaEntrenadores//lista
        )
        lv_numeros.adapter=adaptador
        lv_numeros
            .onItemClickListener=AdapterView.OnItemClickListener{
                parent, view, position, id ->
            Log.i("List-view","position $position")
        }
    }
}