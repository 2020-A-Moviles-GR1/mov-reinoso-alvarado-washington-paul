package com.example.examen_1b_univ_alien

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_list_view_alien.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    btn_menu_aliens
        .setOnClickListener({ boton->
            irListViewAliens()
        })

    }

    fun irListViewAliens(){
        val intentException= Intent(
            this,
            ListViewAlienActivity::class.java
        )
        //this.startActivity(intentException) metodo dentro de la clase
        startActivity(intentException)
    }


}