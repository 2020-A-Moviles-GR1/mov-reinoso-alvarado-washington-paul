package com.example.examen_1b_univ_alien

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_http.*

class HttpActivity : AppCompatActivity() {
    val urlPrincipal = "http://192.168.0.106:1337"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http)
        btn_obHttp
            .setOnClickListener({boton->
                obtenerUniversos()
            })

    }

    fun obtenerUniversos() {
      /*  val pokemonString ="""
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
            .parse<UniversoHttp>(universoString)

        if(pokemonInstancia!=null){
            Log.i("http-klaxon", "Nombre: ${pokemonInstancia.nombre}")
            Log.i("http-klaxon", "FechaCreacion: ${pokemonInstancia.fechaCreacion}")
        }*/

        val url = urlPrincipal + "/universo"
        url
            .httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Success -> {
                        val data = result.get()
                        Log.i("http-klaxon", "Data: ${data}")

                        val universos=Klaxon()
                            .parseArray<UniversoHttp>(data)

                        if(universos!=null){
                            universos.forEach{
                                Log.i("http-klaxon", "Nombre: ${it.nombreUniverso}  tamaño: ${it.tamanioUniverso}")
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