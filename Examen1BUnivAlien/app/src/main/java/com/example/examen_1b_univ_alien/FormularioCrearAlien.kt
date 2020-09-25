package com.example.examen_1b_univ_alien

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_formulario_crear_alien.*
import kotlinx.android.synthetic.main.activity_formulario_edicion_alien.*

class FormularioCrearAlien : AppCompatActivity() {
    val urlPrincipal = "http://192.168.0.102:1337"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_crear_alien)

    btn_crear_Aln
        .setOnClickListener({
            //obtenerValores()
            crearAlien(obtenerValoresObj())
        })

    btn_cancelar_creacion
        .setOnClickListener({
            irListViewAliens()
        })
    }

    fun obtenerValoresObj():AlienHttp{
        val valorRaza = edt_raza.getText().toString()
        val valorAltura = edt_altura.getText().toString().toDouble()
        val valorPeso = edt_peso.getText().toString().toDouble()
        val valorEdad = edt_edad.getText().toString().toInt()
        val valorOstilidad = edt_ostilidad.getText().toString().toBoolean()
        val valorUniverso = edt_universo.getText().toString()
        val latitud =edt_latitud.getText().toString()
        val longitud =edt_longitud.getText().toString()
        val url =edt_url.getText().toString()

        val createdAt=12345325346
        val updatedAt=12345234234
        val id=0


        val alien=AlienHttp(
            createdAt,
            updatedAt,
            id,
            valorRaza,
            valorAltura,
            valorPeso,
            valorEdad,
            valorOstilidad,
            valorUniverso,
            latitud,
            longitud,
            url
        )
        return alien
    }

    fun crearAlien(alien:AlienHttp){
        val url = urlPrincipal + "/alien"

        val parametroUusuario : List<Pair<String,String>> = listOf( //lista de clave valores
            "razaAlien" to "${alien.razaAlien}",
            "alturaAlien" to "${alien.alturaAlien}",
            "pesoAlien" to "${alien.pesoAlien}",
            "edadAlien" to "${alien.edadAlien}",
            "ostilidadAlien" to "${alien.ostilidadAlien}",
            "nombreUniverso" to "${alien.nombreUniverso}",
            "latitud" to "${alien.latitud}",
            "longitud" to "${alien.longitud}",
            "url" to "${alien.url}"
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

        val intentException= Intent(
            this,
            ListViewHttpAlienActivity::class.java
        )
        //intentException.putExtra("universoObj",uni)
        limpiarCampos()
        startActivity(intentException)
    }

    fun irListViewAliens(){
        val intentException= Intent(
            this,
            ListViewAlienActivity::class.java
        )
        startActivity(intentException)
    }

    fun limpiarCampos(){
        edt_raza.setText(null)
        edt_altura.setText(null)
        edt_peso.setText(null)
        edt_edad.setText(null)
        edt_ostilidad.setText(null)
        edt_universo.setText(null)
    }

}