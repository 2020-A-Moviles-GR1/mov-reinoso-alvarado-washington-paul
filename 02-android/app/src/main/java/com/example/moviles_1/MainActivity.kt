package com.example.moviles_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_ciclo_vida
            .setOnClickListener({boton->
                //this.irCicloVida()
                irCicloVida()
        })


        btn_list_view
            .setOnClickListener({boton->
                irListView()
            })


    }

    fun irListView(){
        val intentException=Intent(
            this,
            BListViewActivity::class.java
        )
        //this.startActivity(intentException) metodo dentro de la clase
        startActivity(intentException)
    }


    fun irCicloVida(){
        val intentException=Intent(
            this,
            CicloVida1::class.java
        )
        //this.startActivity(intentException) metodo dentro de la clase
        startActivity(intentException)
    }



}