package com.example.moviles_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent_envia_parametros.*

class IntentEnviaParametrosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_envia_parametros)
        //propiedad dentro de la clase intent
        //this.intent
        val numeroEncontrado =intent.getIntExtra("numero",0)

        //validacion  hacer
        if(numeroEncontrado!=0){
            Log.i("intents","el NUmero es: ${numeroEncontrado}")
        }

        val textoCompartido: String?= intent.getStringExtra(Intent.EXTRA_TEXT)
        if(textoCompartido!=null){
            Log.i("intents","el texto es: ${textoCompartido}")
        }


        //terminamos la actividad
        btn_devolver_respuesta
            .setOnClickListener{
                //this.finish()
                finish()
            }

        btn_resp_aceptar
            .setOnClickListener {
                val nombre = "Paul"
                val edad = 25
                val intentRespuesta = Intent()
                intentRespuesta.putExtra("nombre", nombre)
                intentRespuesta.putExtra("edad", edad)
                // this.setResult()
                setResult(
                    RESULT_OK,
                    intentRespuesta
                )
                // this.finish()
                finish()
            }
        btn_resp_cancelar
            .setOnClickListener {
                val intentCancelado = Intent()
                setResult(
                    Activity.RESULT_CANCELED,
                    intentCancelado
                )
                finish()
            }

    }
}