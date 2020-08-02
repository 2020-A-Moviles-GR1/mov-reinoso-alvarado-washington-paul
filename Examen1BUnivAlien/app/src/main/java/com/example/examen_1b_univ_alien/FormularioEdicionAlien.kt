package com.example.examen_1b_univ_alien

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_formulario_crear_alien.*
import kotlinx.android.synthetic.main.activity_formulario_edicion_alien.*

class FormularioEdicionAlien : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_edicion_alien)

        val razaAl=intent.extras?.getString("razaAl","")
        val alturaAl=intent.extras?.getFloat("alturaAl",0.0F)
        val pesoAl=intent.extras?.getDouble("pesoAl",0.0)
        val edadAl=intent.extras?.getInt("edadAl",0)
        val ostilidadAl=intent.extras?.getBoolean("ostilidadAl",true)
        val universoAl=intent.extras?.getString("universoAl","")

        edit_editar_raza.setText(razaAl.toString())
        edit_editar_altura.setText(alturaAl.toString())
        edit_editar_peso.setText(pesoAl.toString())
        edit_editar_edad.setText(edadAl.toString())
        edit_editar_ostil.setText(ostilidadAl.toString())
        edit_editar_univers.setText(universoAl.toString())

        btn_editar_AlienE
            .setOnClickListener({boton->
                almacenarDatosEsdicion()
            })


    }

    fun almacenarDatosEsdicion(){

        val razaEditada=edit_editar_raza.getText().toString()
        val alturaEditada=edit_editar_altura.getText().toString().toFloat()
        val pesoEditada=edit_editar_peso.getText().toString().toDouble()
        val edadEditada=edit_editar_edad.getText().toString().toInt()
        val ostilidadEditada=edit_editar_ostil.getText().toString().toBoolean()
        val universoEditado=edit_editar_univers.getText().toString()

        val intentException= Intent(
            this,
            ListViewAlienActivity::class.java
        )

        intentException.putExtra("razaAEdit",razaEditada)
        intentException.putExtra("alturaAEdit",alturaEditada)
        intentException.putExtra("pesoAEdit",pesoEditada)
        intentException.putExtra("edadAEdit",edadEditada)
        intentException.putExtra("ostilidadAEdit",ostilidadEditada)
        intentException.putExtra("universoAEdit",universoEditado)
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

}