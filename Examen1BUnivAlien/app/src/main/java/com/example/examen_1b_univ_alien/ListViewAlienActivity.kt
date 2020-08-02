package com.example.examen_1b_univ_alien

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_list_view_alien.*

class ListViewAlienActivity : AppCompatActivity() {
    //var valorRaza=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_alien)

        if(ServicBDDMemoria.listaAlien.isEmpty()){
            ServicBDDMemoria.ListaAliensLlena()
        }

        val ListaAlienigenas=ServicBDDMemoria.listaAlien
        var adaptador=ArrayAdapter(
            this,//contexto
            android.R.layout.simple_list_item_1,//nombre layout
            ListaAlienigenas//lista
        )

        btn_crear_alien
            .setOnClickListener { boton->
                irFormularioAliens()
            }

        btn_buscra_alien
            .setOnClickListener { boton->
                val listaUnicoAlien = arrayListOf<Alien>()
                val raza=edt_text_alien.getText().toString()
                val aln=ServicBDDMemoria.BuscarUnAlienRaza(raza)
                listaUnicoAlien.add(aln)
                adaptador=ArrayAdapter(
                    this,//contexto
                    android.R.layout.simple_list_item_1,//nombre layout
                    listaUnicoAlien//lista
                )
                adaptador.notifyDataSetChanged()
                lv_aliens.adapter=adaptador
            }

        var pos = 0
        lv_aliens.adapter=adaptador
        lv_aliens
            .onItemClickListener= AdapterView.OnItemClickListener{
                parent, view, position, id ->
            pos=position
            Log.i("List","position $pos")
        }

        btn_editar_alien
            .setOnClickListener({boton->
                Log.i("List","position $pos")
                busquedaEnviarParametrosA(pos)
                //irFormularioEditarAliens()
            })


        btn_eliminar_alien
            .setOnClickListener({boton->
                Log.i("List","position $pos")
                val confir=showDialogAlertSimple(pos)
            })

        btn_refrescarU
            .setOnClickListener({boton->
                irMenuPrincipal()
            })

        val razaA=intent.extras?.getString("razaA","")
        val alturaA=intent.extras?.getFloat("alturaA")
        val pesoA=intent.extras?.getDouble("pesoA")
        val edadA=intent.extras?.getInt("edadA")
        val ostilidadA=intent.extras?.getBoolean("ostilidadA")
        val universoA=intent.extras?.getString("universoA")

        //validacion  hacer
        if(razaA==null || razaA==""){
            Log.i("List-view","paraCrarAlien $razaA")
        }else{
            ServicBDDMemoria.añadirCrearAlienigena(razaA!!,alturaA!!,pesoA!!,edadA!!,ostilidadA!!,universoA!!)
            adaptador.notifyDataSetChanged()
            Log.i("intents","valores:$razaA,$alturaA,$pesoA,$edadA,$ostilidadA,$universoA")
        }

        val razaAEditado=intent.extras?.getString("razaAEdit","")
        val alturaAEditado=intent.extras?.getFloat("alturaAEdit")
        val pesoAEditado=intent.extras?.getDouble("pesoAEdit")
        val edadAEditado=intent.extras?.getInt("edadAEdit")
        val ostilidadAEditado=intent.extras?.getBoolean("ostilidadAEdit")
        val universoAEditado=intent.extras?.getString("universoAEdit")

        if (razaAEditado==""||razaAEditado==null){
            //funcion para editar la list
            Log.i("List-view","paraCrarAlien $razaAEditado")
        }else{
            val alienEditado = Alien(razaAEditado!!,alturaAEditado!!,pesoAEditado!!,edadAEditado!!,ostilidadAEditado!!,universoAEditado!!)
            ServicBDDMemoria.EditarAlien(pos,alienEditado)
            Log.i("List","editadad $ListaAlienigenas")
            adaptador.notifyDataSetChanged()

        }
        val nombreUniversoBorrado=intent.extras?.getString("nombreUniversoBorrado","")

        if (nombreUniversoBorrado==""||nombreUniversoBorrado==null){
            //funcion para editar la list
            Log.i("List","unversoresivido $nombreUniversoBorrado")
        }else{
            Log.i("List","unversoresivido $ListaAlienigenas")
            Log.i("List","unversoresivido $nombreUniversoBorrado")
            //borraralien por nombre universo
            ServicBDDMemoria.eliminarAlienNumbreUnivrs(nombreUniversoBorrado,ListaAlienigenas)
            adaptador.notifyDataSetChanged()
        }





    }

    fun busquedaEnviarParametrosA(pos:Int){
        val alienBI=ServicBDDMemoria.BuscarUnAlienIndice(pos)

        val intentException= Intent(
            this,
            FormularioEdicionAlien::class.java
        )
        val valorRaza = alienBI.razaAlien
        val valorAltura = alienBI.alturaAlien
        val valorPeso = alienBI.pesoAlien
        val valorEdad = alienBI.edadAlien
        val valorOstilidad = alienBI.ostilidadAlien
        val valorUniverso = alienBI.nombreUnivers

        intentException.putExtra("razaAl",valorRaza)
        intentException.putExtra("alturaAl",valorAltura)
        intentException.putExtra("pesoAl",valorPeso)
        intentException.putExtra("edadAl",valorEdad)
        intentException.putExtra("ostilidadAl",valorOstilidad)
        intentException.putExtra("universoAl",valorUniverso)

        startActivity(intentException)

        Log.i("List-view","position $valorRaza,$valorEdad,$valorOstilidad,$valorAltura,$valorUniverso,$valorPeso")
    }



    fun irFormularioAliens(){
        val intentException= Intent(
            this,
            FormularioCrearAlien::class.java
        )
        //this.startActivity(intentException) metodo dentro de la clase
        startActivity(intentException)
    }

    fun irFormularioEditarAliens(){
        val intentException= Intent(
            this,
            FormularioEdicionAlien::class.java
        )
        //this.startActivity(intentException) metodo dentro de la clase
        startActivity(intentException)
    }

    fun showDialogAlertSimple(pos:Int) {
        var vandera=false
        AlertDialog.Builder(this)
            .setTitle("Confirmar eliminación")
            .setMessage("Seguro desea eliminar este Alienigena?")
            .setPositiveButton(android.R.string.ok,
                DialogInterface.OnClickListener { dialog, which ->
                    //botón OK pulsado
                    val indiceBorra=pos
                        ServicBDDMemoria.eliminarAlien(indiceBorra)
                    vandera=true
                    this.startActivity(intent)
                })
            .setNegativeButton(android.R.string.cancel,
                DialogInterface.OnClickListener { dialog, which ->
                    //botón cancel pulsado
                    vandera=false
                    Log.i("List","position $vandera")
                })
            .show()
    }

    fun irMenuPrincipal(){
        val intentException= Intent(
            this,
            MainActivity::class.java
        )
        //this.startActivity(intentException) metodo dentro de la clase
        startActivity(intentException)
    }



}
