package com.example.examen_1b_univ_alien

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_formulario_crear_alien.*
import kotlinx.android.synthetic.main.activity_formulario_crear_universo.*

class FormularioCrearUniverso : AppCompatActivity() {
    val urlPrincipal = "http://192.168.0.102:1337"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_crear_universo)

        btn_crear_Unv
            .setOnClickListener({
                crearUniverso(obtenerValoresObj())
            })

        btn_cancelar_Unv
            .setOnClickListener({
                irListViewUniverso()
            })
    }

    /*Funciones*/

    fun obtenerValoresObj():UniversoHttp{
        val valorNombre = edt_nombre.getText().toString()
        val valorAntiguedad = edt_antiguedad.getText().toString().toInt()
        val valorTamanio2 = edt_tamanio.getText().toString().toDouble()
        val valorTemperatura = edt_temperatura.getText().toString().toDouble()
        val valorPrimario = edt_primario.getText().toString().toBoolean()

        val createdAt=12345325346
        val updatedAt=12345234234
        val id=0

        val uni=UniversoHttp(
            createdAt,
            updatedAt,
            id,
            valorNombre,
            valorAntiguedad,
            valorTamanio2,
            valorTemperatura,
            valorPrimario
        )
        return uni
    }

    fun crearUniverso(univ:UniversoHttp){
        val url = urlPrincipal + "/universo"

        val parametroUusuario : List<Pair<String,String>> = listOf( //lista de clave valores
            "nombreUniverso" to "${univ.nombreUniverso}",
            "antiguedadUniverso" to "${univ.antiguedadUniverso}",
            "tamanioUniverso" to "${univ.tamanioUniverso}",
            "minTemperatura" to "${univ.minTemperatura}",
            "universoPrimario" to "${univ.universoPrimario}"
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
            ListViewHttpUniversActivity::class.java
        )
        //intentException.putExtra("universoObj",uni)
        limpiarCampos()
        startActivity(intentException)
    }

    fun limpiarCampos(){
        edt_nombre.setText(null)
        edt_antiguedad.setText(null)
        edt_tamanio.setText(null)
        edt_temperatura.setText(null)
        edt_primario.setText(null)
    }

    fun irListViewUniverso(){
        val intentException= Intent(
            this,
            ListViewHttpUniversActivity::class.java
        )
        startActivity(intentException)
    }
}