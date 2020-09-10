package com.example.examen_1b_univ_alien

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.kittinunf.fuel.httpPatch
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_formulario_crear_alien.*
import kotlinx.android.synthetic.main.activity_formulario_edicion_alien.*
import kotlinx.android.synthetic.main.activity_formulario_edicion_universo.*

class FormularioEdicionAlien : AppCompatActivity() {
    val urlPrincipal = "http://192.168.0.106:1337"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_edicion_alien)

        val alien= intent.getParcelableExtra<AlienHttp>("alienA")
        if(alien!=null){
            edit_editar_raza.setText(alien.razaAlien.toString())
            edit_editar_altura.setText(alien.alturaAlien.toString())
            edit_editar_peso.setText(alien.pesoAlien.toString())
            edit_editar_edad.setText(alien.edadAlien.toString())
            edit_editar_ostil.setText(alien.ostilidadAlien.toString())
            edit_editar_univers.setText(alien.nombreUniverso.toString())
        }

        btn_editar_AlienE
            .setOnClickListener({boton->
                actualizarAlien(alien)
            })

        btn_cancelar_editar_AlienE
            .setOnClickListener({boton->
                irListViewAliens()
            })
    }

    fun actualizarAlien(alien:AlienHttp) {
        val razaEditada=edit_editar_raza.getText().toString()
        val alturaEditada=edit_editar_altura.getText().toString().toFloat()
        val pesoEditada=edit_editar_peso.getText().toString().toDouble()
        val edadEditada=edit_editar_edad.getText().toString().toInt()
        val ostilidadEditada=edit_editar_ostil.getText().toString().toBoolean()
        val universoEditado=edit_editar_univers.getText().toString()

        val url = urlPrincipal + "/alien/"+alien.id
        val parametroUusuario: List<Pair<String, String>> = listOf( //lista de clave valores
            "razaAlien" to "${razaEditada}",
            "alturaAlien" to "${alturaEditada}",
            "pesoAlien" to "${pesoEditada}",
            "edadAlien" to "${edadEditada}",
            "ostilidadAlien" to "${ostilidadEditada}",
            "nombreUniverso" to "${universoEditado}"
        )
        url
            .httpPut(parametroUusuario)
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val error = result.getException()
                        Log.i("http-klaxon", "Nombre: ${error}")
                    }
                    is Result.Success -> {
                        val usuarioString = result.get()
                        Log.i("http-klaxon", "Nombre: ${usuarioString}")
                    }
                }
            }
        val intentException= Intent(
            this,
            ListViewHttpAlienActivity::class.java
        )
        limpiarCampos()
        startActivity(intentException)
    }


    fun limpiarCampos(){
        edit_editar_raza.setText(null)
        edit_editar_altura.setText(null)
        edit_editar_peso.setText(null)
        edit_editar_edad.setText(null)
        edit_editar_ostil.setText(null)
        edit_editar_univers.setText(null)
    }


    fun irListViewAliens(){
        val intentException= Intent(
            this,
            ListViewHttpAlienActivity::class.java
        )
        startActivity(intentException)
    }

}