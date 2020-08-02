package com.example.examen_1b_univ_alien

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_formulario_crear_alien.*
import kotlinx.android.synthetic.main.activity_formulario_crear_universo.*

class FormularioCrearUniverso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_crear_universo)

        btn_crear_Unv
            .setOnClickListener({
                obtenerValores()
            })

        btn_cancelar_Unv
            .setOnClickListener({
                irListViewUniverso()
            })
    }

    fun obtenerValores(){

        val intentException= Intent(
            this,
            ListViewUniversoActivity::class.java
        )

        val valorNombre = edt_nombre.getText().toString()
        val valorAntiguedad = edt_antiguedad.getText().toString().toInt()
        val valorTamanio = edt_tamanio.getText().toString().toFloat()
        val valorTemperatura = edt_temperatura.getText().toString().toDouble()
        val valorPrimario = edt_primario.getText().toString().toBoolean()

        intentException.putExtra("nombreU",valorNombre)
        intentException.putExtra("antiguedadU",valorAntiguedad)
        intentException.putExtra("tamanioU",valorTamanio)
        intentException.putExtra("temperaturaU",valorTemperatura)
        intentException.putExtra("primarioU",valorPrimario)

        limpiarCampos()
        startActivity(intentException)
        //Log.i("List-view","position $valorRaza,$valorEdad,$valorOstilidad,$valorAltura,$valorUniverso,$valorPeso")

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
            ListViewUniversoActivity::class.java
        )
        startActivity(intentException)
    }






}