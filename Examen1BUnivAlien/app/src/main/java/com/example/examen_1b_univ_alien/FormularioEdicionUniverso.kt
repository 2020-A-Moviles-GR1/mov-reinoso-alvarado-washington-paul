package com.example.examen_1b_univ_alien

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_formulario_edicion_alien.*
import kotlinx.android.synthetic.main.activity_formulario_edicion_universo.*

class FormularioEdicionUniverso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_edicion_universo)

        val nombreUn=intent.extras?.getString("nombreUn","")
        val tamanioUn=intent.extras?.getFloat("tamanioUn",0.0F)
        val temperaturaUn=intent.extras?.getDouble("temperaturaUn",0.0)
        val antiguedadUn=intent.extras?.getInt("antiguedadUn",0)
        val primarioUn=intent.extras?.getBoolean("primarioUn",true)

        edit_editar_nombre.setText(nombreUn.toString())
        edit_editar_tamanio.setText(tamanioUn.toString())
        edit_editar_temperatura.setText(temperaturaUn.toString())
        edit_editar_antiguedad.setText(antiguedadUn.toString())
        edit_editar_primario.setText(primarioUn.toString())

        btn_editar_UniversoE
            .setOnClickListener({boton->
                almacenarDatosEsdicion()
            })

    }

    fun almacenarDatosEsdicion(){

        val nombreEditada=edit_editar_nombre.getText().toString()
        val tamanioEditada=edit_editar_tamanio.getText().toString().toFloat()
        val temperaturaEditada=edit_editar_temperatura.getText().toString().toDouble()
        val antiguedadEditada=edit_editar_antiguedad.getText().toString().toInt()
        val primarioEditada=edit_editar_primario.getText().toString().toBoolean()


        val intentException= Intent(
            this,
            ListViewUniversoActivity::class.java
        )
        intentException.putExtra("nombreUEdit",nombreEditada)
        intentException.putExtra("tamanioUEdit",tamanioEditada)
        intentException.putExtra("temperaturaUEdit",temperaturaEditada)
        intentException.putExtra("antiguedadUEdit",antiguedadEditada)
        intentException.putExtra("primarioUEdit",primarioEditada)

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

}