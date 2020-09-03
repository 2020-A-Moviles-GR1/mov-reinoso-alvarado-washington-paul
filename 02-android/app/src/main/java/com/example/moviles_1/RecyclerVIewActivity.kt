package com.example.moviles_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_recycler_v_iew.*

class RecyclerVIewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_v_iew)
        val listaUsuarios= arrayListOf<UsuarioHttp>()
        listaUsuarios.add(
            UsuarioHttp(
                12312312323123,
                12312312567823,
                6,
                "16283940594",
                "lucas",
                "lucas.ramirez@epn.edu.ec",
                "Soltero",
                "SuperM3gaS3gur4",
        arrayListOf<PokemonHttp>()
            )
        )
        listaUsuarios.add(
            UsuarioHttp(
                12312312323123,
                12312312678123,
                6,
                "15283940594",
                "Marco",
                "marco.reyes@epn.edu.ec",
                "Soltero",
                "SuperM3gaS3gur4",
                arrayListOf<PokemonHttp>()
            )
        )
        listaUsuarios.add(
            UsuarioHttp(
                12312312323123,
                12312345623123,
                6,
                "13283940594",
                "Fabricio",
                "fabricio.lopez@epn.edu.ec",
                "Soltero",
                "SuperM3gaS3gur4",
                arrayListOf<PokemonHttp>()
            )
        )
        inicirRecyclerView(
            listaUsuarios,
            this,
            rv_usuarios
        )
    }
    fun inicirRecyclerView(
        lista: List<UsuarioHttp>,
        actividad:RecyclerVIewActivity,
        recycler_view:androidx.recyclerview.widget.RecyclerView
    ){
        val adaptadorUsuario= RecyclerAdaptador(
            lista,
            actividad,
            recycler_view
        )
        rv_usuarios.adapter=adaptadorUsuario
        rv_usuarios.itemAnimator=androidx.recyclerview.widget.DefaultItemAnimator()
        rv_usuarios.layoutManager=androidx.recyclerview.widget.LinearLayoutManager(actividad)
        adaptadorUsuario.notifyDataSetChanged()
    }
}