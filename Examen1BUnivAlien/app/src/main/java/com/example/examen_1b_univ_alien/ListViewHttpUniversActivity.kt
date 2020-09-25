package com.example.examen_1b_univ_alien

import android.app.PendingIntent.getActivity
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_list_view_http_univers.*

class ListViewHttpUniversActivity : AppCompatActivity() {
    lateinit var listaUniversos:ArrayList<UniversoHttp>
    lateinit var adaptador :ArrayAdapter<UniversoHttp>
    val urlPrincipal = "http://192.168.0.102:1337"
    var posicion:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_http_univers)

        listaUniversos=arrayListOf()
        adaptador=ArrayAdapter(
            this,//contexto
            android.R.layout.simple_list_item_1,//nombre layout
            listaUniversos//lista
        )
        lv_universoHttp.adapter=adaptador
        lv_universoHttp
            .onItemClickListener= AdapterView.OnItemClickListener{
                parent, view, position, id ->
            Log.i("List","position $position")
            posicion=position
        }
        obtenerUniversos()

        btn_creaUniHttp
            .setOnClickListener{boton->
                irFormularioUniversos()
            }

        btn_buscarUniHttp
            .setOnClickListener{botn->
                val nombreUniversoHttp=edt_universoHttp.getText().toString()
                buscarUniversoHttp(nombreUniversoHttp)
            }

        btn_actualiUniHttp
            .setOnClickListener{ boton->
                val universoB=listaUniversos.get(posicion)
                Log.i("http-klaxon", "Universo Select:  ${universoB}")
                val intentException= Intent(
                    this,
                    FormularioEdicionUniverso::class.java
                )
                intentException.putExtra("universoA",universoB)
                startActivity(intentException)
            }
        btn_eliminUniHttp
            .setOnClickListener{boton->
                val universoB=listaUniversos.get(posicion)
                Log.i("http-klaxon", "Universo Select:  ${universoB}")
                //eliminarUniversoHttp(universoB.id)
                showDialogAlertSimple(universoB.id)
            }

        btn_mostrar_hijos
            .setOnClickListener {
                val universoB=listaUniversos.get(posicion)
                Log.i("http-klaxon", "Universo Select:  ${universoB}")
                val intentException= Intent(
                    this,
                    MapsActivity::class.java
                )
                intentException.putExtra("universoA",universoB)
                startActivity(intentException)

            }
    }

    fun obtenerUniversos() {
        val url = urlPrincipal + "/universo"
        url
            .httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Success -> {
                        val data = result.get()
                        Log.i("http-klaxon", "Data: ${data}")
                        val universos=Klaxon()
                            .parseArray<UniversoHttp>(data)
                        if(universos!=null){
                            universos.forEach{
                                Log.i("http-klaxon", "Nombre: ${it.nombreUniverso}  tamaño: ${it.tamanioUniverso}")
                                listaUniversos.add(it)
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

    fun buscarUniversoHttp(nombreUni:String){
        adaptador.clear()
        val url = urlPrincipal + "/universo?nombreUniverso="+nombreUni
        url
            .httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Success -> {
                        val data = result.get()
                        //Log.i("http-klaxon", "Data: ${data}")
                        val universos=Klaxon()
                            .parseArray<UniversoHttp>(data)
                        if(universos!=null){
                            universos.forEach{
                                //Log.i("http-klaxon", "Nombre: ${it.nombreUniverso}  tamaño: ${it.tamanioUniverso}")
                                listaUniversos.add(it)
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

    fun eliminarUniversoHttp(identificador:Int){
        val url = urlPrincipal + "/universo/"+identificador
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
            ListViewHttpUniversActivity::class.java
        )
        adaptador.notifyDataSetChanged()
        startActivity(intentException)
    }


    fun irFormularioUniversos(){
        val intentException= Intent(
            this,
            FormularioCrearUniverso::class.java
        )
        //this.startActivity(intentException) metodo dentro de la clase
        startActivity(intentException)
    }

    fun showDialogAlertSimple(pos:Int) {
        var vandera=false
        AlertDialog.Builder(this)
            .setTitle("Confirmar eliminación")
            .setMessage("Seguro desea eliminar este Universo?")
            .setPositiveButton(android.R.string.ok,
                DialogInterface.OnClickListener { dialog, which ->
                    //botón OK pulsado**
                    //val indiceBorra=pos
                    //ServicBDDMemoria.eliminarAlien(indiceBorra)
                    //vandera=true
                    eliminarUniversoHttp(pos)
                    this.startActivity(intent)
                })
            .setNegativeButton(android.R.string.cancel,
                DialogInterface.OnClickListener { dialog, which ->
                    //botón cancel pulsado**
                    vandera=false
                    Log.i("List","position $vandera")
                })
            .show()
    }

}


