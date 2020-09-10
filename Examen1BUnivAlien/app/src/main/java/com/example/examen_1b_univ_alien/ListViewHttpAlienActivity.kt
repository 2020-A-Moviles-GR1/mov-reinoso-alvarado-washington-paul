package com.example.examen_1b_univ_alien

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_list_view_http_alien.*
import kotlinx.android.synthetic.main.activity_list_view_http_univers.*

class ListViewHttpAlienActivity : AppCompatActivity() {
    lateinit var listaAliens:ArrayList<AlienHttp>
    lateinit var adaptador : ArrayAdapter<AlienHttp>
    val urlPrincipal = "http://192.168.0.106:1337"
    var posicion:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_http_alien)

        listaAliens = arrayListOf()
        adaptador = ArrayAdapter(
            this,//contexto
            android.R.layout.simple_list_item_1,//nombre layout
            listaAliens//lista
        )
        lv_aliensHttp.adapter = adaptador
        lv_aliensHttp
            .onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Log.i("List", "position $position")
            posicion = position
        }
        obtenerAliens()

        btn_creaAlienHttp
            .setOnClickListener{boton->
                irFormularioAliens()
            }

        btn_buscarAlienHttp
            .setOnClickListener{botn->
            val nombreRazaHttp=edt_alienHttp.getText().toString()
            buscarAlienHttp(nombreRazaHttp)
        }

        btn_actualizarAlienHttp
            .setOnClickListener{
                val alienB=listaAliens.get(posicion)
                Log.i("http-klaxon", "Universo Select:  ${alienB}")
                val intentException= Intent(
                    this,
                    FormularioEdicionAlien::class.java
                )
                intentException.putExtra("alienA",alienB)
                startActivity(intentException)
        }
        btn_eliminarAlienHttp
            .setOnClickListener{boton->
                val alienB=listaAliens.get(posicion)
                Log.i("http-klaxon", "Universo Select:  ${alienB}")
                eliminarAlien(alienB.id)
            }



    }
    // funciones

    fun obtenerAliens() {
        val url = urlPrincipal + "/alien"
        url
            .httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Success -> {
                        val data = result.get()
                        Log.i("http-klaxon", "Data: ${data}")
                        val aliens= Klaxon()
                            .parseArray<AlienHttp>(data)
                        if(aliens!=null){
                            aliens.forEach{
                                Log.i("http-klaxon", "Nombre: ${it.nombreUniverso}  tamaño: ${it.razaAlien}")
                                listaAliens.add(it)
                            }
                            runOnUiThread(Runnable {
                                adaptador.notifyDataSetChanged()
                            })
                        }
                    }
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http-klaxon", "Error: ${ex.message}")
                    }
                }
            }
    }

    fun buscarAlienHttp(nombreRaza:String){
        adaptador.clear()
        val url = urlPrincipal + "/alien?razaAlien="+nombreRaza
        url
            .httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Success -> {
                        val data = result.get()
                        //Log.i("http-klaxon", "Data: ${data}")
                        val aliens=Klaxon()
                            .parseArray<AlienHttp>(data)
                        if(aliens!=null){
                            aliens.forEach{
                                //Log.i("http-klaxon", "Nombre: ${it.nombreUniverso}  tamaño: ${it.tamanioUniverso}")
                                listaAliens.add(it)
                            }
                            runOnUiThread(Runnable {
                                adaptador.notifyDataSetChanged()
                            })
                        }
                    }
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http-klaxon", "Error: ${ex.message}")
                    }
                }
            }
    }

    fun eliminarAlien(identificador:Int){
        val url = urlPrincipal + "/alien/"+identificador
        url
            .httpDelete()
            .responseString { request, response, result ->
                when (result) {
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
            ListViewHttpAlienActivity::class.java
        )
        adaptador.notifyDataSetChanged()
        startActivity(intentException)
    }


    fun irFormularioAliens(){
        val intentException= Intent(
            this,
            FormularioCrearAlien::class.java
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
                    //botón OK pulsado**
                    //val indiceBorra=pos
                    //ServicBDDMemoria.eliminarAlien(indiceBorra)
                    //vandera=true
                    this.startActivity(intent)
                })
            .setNegativeButton(android.R.string.cancel,
                DialogInterface.OnClickListener { dialog, which ->
                    //botón cancel pulsado**
                    //vandera=false
                    //Log.i("List","position $vandera")
                })
            .show()
    }


}