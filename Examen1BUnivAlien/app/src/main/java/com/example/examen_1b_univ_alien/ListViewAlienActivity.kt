package com.example.examen_1b_univ_alien

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_view_alien.*

class ListViewAlienActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_alien)

        val ListaAlienigenas=ServicBDDMemoria.ListaAliensLlena()
        val adaptador=ArrayAdapter(
            this,//contexto
            android.R.layout.simple_list_item_1,//nombre layout
            ListaAlienigenas//lista
        )

        lv_aliens.adapter=adaptador
        lv_aliens
            .onItemClickListener= AdapterView.OnItemClickListener{
                parent, view, position, id ->
            Log.i("List-view","position $position")
            Log.i("List-view","parent $parent")
            Log.i("List-view","id $id")
            Log.i("List-view","view $view")
        }

        /*btn_aniadir_entrendor
            .setOnClickListener{
                anadirEntrenador(adaptador,listaEntrenadores)

            }*/
    }
    //si quisiera mantener los datos usaria un constrain de servicioBDDMemoria
    /*fun anadirEntrenador(adaptador: ArrayAdapter<Entrenador>, listEntrenadores:ArrayList<Entrenador>){
        listEntrenadores.add(
            Entrenador("Nuevo","Entrenador")
        )
        adaptador.notifyDataSetChanged()
    }*/

}
