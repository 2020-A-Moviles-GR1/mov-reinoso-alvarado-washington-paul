package com.example.moviles_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_ciclo_vida1.*

class CicloVida1 : AppCompatActivity() {

    var numeroActual =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciclo_vida1)
        Log.i("Activity","OnCreate")
        //obtendremos los valores de la memoria
        numeroActual=ServicionBDDMemoria.numero
        if(numeroActual!=0){
            tv_numero.text=numeroActual.toString()
        }
        btn_anadir
            .setOnClickListener{
                sumarUnValor()
            }
    }

    fun sumarUnValor(){
        numeroActual=numeroActual+1
        ServicionBDDMemoria.anadirNumero() //para que tambien se añada un numero en el servicio
        tv_numero.text=numeroActual.toString()

    }

    override fun onStart() {
        super.onStart()
        Log.i("Activity","OnStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Activity","OnRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Activity","OnResume")
    }


    override fun onPause() {
        super.onPause()
        Log.i("Activity","OnPause")
    }


    override fun onStop() {
        super.onStop()
        Log.i("Activity","OnStop")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.i("Activity","OnDestroy")
    }

    override fun onSaveInstanceState(
        outState: Bundle
    ) {
        Log.i("Activity","onSaveInstanceState")
        outState?.run {
            putInt("numeroActualGuardado",numeroActual)
        }
        super.onSaveInstanceState(outState)
    }

    /*override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
    textView.text = savedInstanceState?.getString(TEXT_VIEW_KEY)
}   */

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle
    ) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("Activity","onRestoreInstanceState")
        val valoreRecuperdo = savedInstanceState
            ?.getInt("numeroActualGuardado")
        if(
           valoreRecuperdo!=null){
            this.numeroActual=valoreRecuperdo
            tv_numero.text=this.numeroActual.toString()
        }
    }

}