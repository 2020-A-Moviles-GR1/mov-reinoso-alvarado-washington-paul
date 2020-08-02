package com.example.examen_1b_univ_alien

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_formulario_crear_alien.*
import kotlinx.android.synthetic.main.activity_formulario_edicion_alien.*

class FormularioCrearAlien : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_crear_alien)

    btn_crear_Aln
        .setOnClickListener({
            obtenerValores()
        })

    btn_cancelar_creacion
        .setOnClickListener({
            irListViewAliens()
        })
    }

    fun obtenerValores(){

        val intentException= Intent(
            this,
            ListViewAlienActivity::class.java
        )

        val valorRaza = edt_raza.getText().toString()
        val valorAltura = edt_altura.getText().toString().toFloat()
        val valorPeso = edt_peso.getText().toString().toDouble()
        val valorEdad = edt_edad.getText().toString().toInt()
        val valorOstilidad = edt_ostilidad.getText().toString().toBoolean()
        val valorUniverso = edt_universo.getText().toString()

        intentException.putExtra("razaA",valorRaza)
        intentException.putExtra("alturaA",valorAltura)
        intentException.putExtra("pesoA",valorPeso)
        intentException.putExtra("edadA",valorEdad)
        intentException.putExtra("ostilidadA",valorOstilidad)
        intentException.putExtra("universoA",valorUniverso)
        limpiarCampos()
        startActivity(intentException)

        Log.i("List-view","position $valorRaza,$valorEdad,$valorOstilidad,$valorAltura,$valorUniverso,$valorPeso")

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