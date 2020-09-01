package com.example.moviles_1

import android.media.Session2Command
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import kotlinx.android.synthetic.main.activity_http.*
import com.github.kittinunf.result.Result

class HttpActivity : AppCompatActivity() {
    val urlPrincipal = "http://192.168.0.104:1337"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http)

        btn_obtener
            .setOnClickListener({
                obtenerUsuarios()
            })

        btn_crear
            .setOnClickListener({
                crearUsuario()
            })

    }


    fun crearUsuario(){
        val url=urlPrincipal + "/Usuario"

        val parametroUusuario : List<Pair<String,String>> = listOf( //lista de clave valores
            "cedula" to "1777279766",
            "nombre" to "Fran",
            "correo" to "fran.ruiz@epn.edu.ec",
            "estdoCivil" to "Casado",
            "password" to "A123456789b"
        )
        url
            .httpPost(parametroUusuario)
            .responseString{request, response, result ->
                when (result){
                    is Result.Failure->{
                        val error = result.getException()
                        Log.i("http-klaxon", "Nombre: ${error}")
                    }
                    is Result.Success->{
                        val usuarioString=result.get()
                        Log.i("http-klaxon", "Nombre: ${usuarioString}")
                    }
                }
            }

    }


    fun obtenerUsuarios() {
        val pokemonString ="""
            {
            "createdAt": 1597678853356,
            "updatedAt": 1597678879582,
            "id": 2,
            "nombre": "pikachu",
            "usuario": 1,
            "batalla": 1
          }
          """.trimIndent()

        val pokemonInstancia= Klaxon()
            .parse<PokemonHttp>(pokemonString)

        if(pokemonInstancia!=null){
            Log.i("http-klaxon", "Nombre: ${pokemonInstancia.nombre}")
            Log.i("http-klaxon", "FechaCreacion: ${pokemonInstancia.fechaCreacion}")
        }

        val url = urlPrincipal + "/Usuario"
        url
            .httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Success -> {
                        val data = result.get()
                        Log.i("http-klaxon", "Data: ${data}")

                        val usuarios=Klaxon()
                            .parseArray<UsuarioHttp>(data)
                        if(usuarios!=null){
                            usuarios.forEach{
                                Log.i("http-klaxon", "Nombre: ${it.nombre}  estadoCivil ${it.estdoCivil}")

                                if(it.Pokemons.size>0){
                                it.Pokemons.forEach{
                                    Log.i("http-klaxon", "Nombre: ${it.nombre}")
                                   }
                                }
                            }
                        }
                    }

                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http-klaxon", "Error: ${ex.message}")
                    }
                }
            }
    }

}