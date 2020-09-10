package com.example.examen_1b_univ_alien

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_formulario_edicion_alien.*
import kotlinx.android.synthetic.main.activity_formulario_edicion_universo.*

class FormularioEdicionUniverso : AppCompatActivity() {
    val urlPrincipal = "http://192.168.0.106:1337"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_edicion_universo)

        val universo= intent.getParcelableExtra<UniversoHttp>("universoA")
        if(universo!=null){
            edit_editar_nombre.setText(universo.nombreUniverso.toString())
            edit_editar_tamanio.setText(universo.tamanioUniverso.toString())
            edit_editar_temperatura.setText(universo.minTemperatura.toString())
            edit_editar_antiguedad.setText(universo.antiguedadUniverso.toString())
            edit_editar_primario.setText(universo.universoPrimario.toString())
        }

        btn_editar_UniversoE
            .setOnClickListener({boton->
                actualizarUniverso(universo)
            })

        btn_cancelar_editar_UniversoE
            .setOnClickListener({boton->
                irListViewUniverso()
            })
    }

    fun actualizarUniverso(univ:UniversoHttp) {
        val nombreEditada=edit_editar_nombre.getText().toString()
        val tamanioEditada=edit_editar_tamanio.getText().toString().toDouble()
        val temperaturaEditada=edit_editar_temperatura.getText().toString().toDouble()
        val antiguedadEditada=edit_editar_antiguedad.getText().toString().toInt()
        val primarioEditada=edit_editar_primario.getText().toString().toBoolean()

        val url = urlPrincipal + "/universo/"+univ.id
        val parametroUusuario: List<Pair<String, String>> = listOf( //lista de clave valores
            "nombreUniverso" to "${nombreEditada}",
            "antiguedadUniverso" to "${antiguedadEditada}",
            "tamanioUniverso" to "${tamanioEditada}",
            "minTemperatura" to "${temperaturaEditada}",
            "universoPrimario" to "${primarioEditada}"
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
            ListViewHttpUniversActivity::class.java
        )
        limpiarCampos()
        startActivity(intentException)
    }


    fun limpiarCampos(){
        edit_editar_nombre.setText(null)
        edit_editar_tamanio.setText(null)
        edit_editar_temperatura.setText(null)
        edit_editar_antiguedad.setText(null)
        edit_editar_primario.setText(null)
    }

    fun irListViewUniverso(){
        val intentException= Intent(
            this,
            ListViewHttpUniversActivity::class.java
        )
        startActivity(intentException)
    }
}