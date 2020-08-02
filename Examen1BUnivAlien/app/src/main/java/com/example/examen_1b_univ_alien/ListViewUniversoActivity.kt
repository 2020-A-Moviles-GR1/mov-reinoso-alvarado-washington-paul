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
import kotlinx.android.synthetic.main.activity_list_view_universo.*
import kotlinx.android.synthetic.main.activity_list_view_universo.btn_refrescarU

class ListViewUniversoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_universo)

        if(ServicBDDMemoria.listaUniverso.isEmpty()){
            ServicBDDMemoria.ListaUniversoLlena()
        }

        val ListaUniversos=ServicBDDMemoria.listaUniverso
        var adaptador= ArrayAdapter(
            this,//contexto
            android.R.layout.simple_list_item_1,//nombre layout
            ListaUniversos//lista
        )

        var pos = 0
        lv_universo.adapter=adaptador
        lv_universo
            .onItemClickListener= AdapterView.OnItemClickListener{
                parent, view, position, id ->
            pos=position
            Log.i("List","position $pos")
        }

        btn_crear_universo
            .setOnClickListener { boton->
                irFormularioUniversos()
            }

        val nombreU=intent.extras?.getString("nombreU","")
        val antiguedadU=intent.extras?.getInt("antiguedadU")
        val tamanioU=intent.extras?.getFloat("tamanioU")
        val temperaturaU=intent.extras?.getDouble("temperaturaU")
        val primarioU=intent.extras?.getBoolean("primarioU")

        //validacion  hacer
        if(nombreU==null || nombreU==""){
            Log.i("List-view","paraCrarAlien $nombreU")
        }else{
            ServicBDDMemoria.añadirCrearUneverso(nombreU!!,antiguedadU!!,tamanioU!!,temperaturaU!!,primarioU!!)
            adaptador.notifyDataSetChanged()
            //Log.i("intents","valores:$razaA,$alturaA,$pesoA,$edadA,$ostilidadA,$universoA")
        }

        btn_buscar_universo
            .setOnClickListener{boton->
                val listaUnicoUnivers = arrayListOf<Universo>()
                val nombre=edt_text_universo.getText().toString()
                val unv=ServicBDDMemoria.BuscarUnUniversoNombre(nombre)
                listaUnicoUnivers.add(unv)
                adaptador=ArrayAdapter(
                    this,//contexto
                    android.R.layout.simple_list_item_1,//nombre layout
                    listaUnicoUnivers//lista
                )
                adaptador.notifyDataSetChanged()
                lv_universo.adapter=adaptador
            }

        btn_refrescarU
            .setOnClickListener({boton->
                this.startActivity(intent)
            })

        btn_editar_universo
            .setOnClickListener({boton->
                //busquedaEnviarParametrosA(pos)
                busquedaEnviarParametrosU(pos)
            })


        btn_eliminar_universo
            .setOnClickListener({boton->
                Log.i("List","position $pos")
                showDialogAlertSimple(pos)
            })


        //recibe datos

        val nombreUEditado=intent.extras?.getString("nombreUEdit","")
        val tamanioUEditado=intent.extras?.getFloat("tamanioUEdit")
        val temperturaUEditado=intent.extras?.getDouble("temperaturaUEdit")
        val antiguedadUEditado=intent.extras?.getInt("antiguedadUEdit")
        val primarioUEditado=intent.extras?.getBoolean("primarioUEdit")

        if (nombreUEditado==""||nombreUEditado==null){
            //funcion para editar la list
            Log.i("List-view","paraCrarAlien $nombreUEditado")
        }else{
            val unversoEditado = Universo(nombreUEditado!!,antiguedadUEditado!!,tamanioUEditado!!,temperturaUEditado!!,primarioUEditado!!)
            ServicBDDMemoria.EditarUniverso(pos,unversoEditado)
            Log.i("List","editadad $ListaUniversos")
            adaptador.notifyDataSetChanged()

        }

    }

    fun irFormularioUniversos(){
        val intentException= Intent(
            this,
            FormularioCrearUniverso::class.java
        )
        //this.startActivity(intentException) metodo dentro de la clase
        startActivity(intentException)
    }


    fun busquedaEnviarParametrosU(pos:Int){
        val universoBI=ServicBDDMemoria.BuscarUnUniversoIndice(pos)

        val intentException= Intent(
            this,
            FormularioEdicionUniverso::class.java
        )

        val valorNombre = universoBI.nombreUniverso
        val valorAntiguedad = universoBI.antiguedadUniverso
        val valorTamanio = universoBI.tamanioUniverso
        val valorTemperatura = universoBI.minTemperatura
        val valorPrimario = universoBI.universoPrimario

        intentException.putExtra("nombreUn",valorNombre)
        intentException.putExtra("antiguedadUn",valorAntiguedad)
        intentException.putExtra("tamanioUn",valorTamanio)
        intentException.putExtra("temperaturaUn",valorTemperatura)
        intentException.putExtra("primarioUn",valorPrimario)


        startActivity(intentException)

        //Log.i("List-view","position $valorRaza,$valorEdad,$valorOstilidad,$valorAltura,$valorUniverso,$valorPeso")
    }

    fun showDialogAlertSimple(pos:Int){
        var vandera=false
        AlertDialog.Builder(this)
            .setTitle("Confirmar eliminación")
            .setMessage("Seguro desea eliminar este Universo?")
            .setPositiveButton(android.R.string.ok,
                DialogInterface.OnClickListener { dialog, which ->
                    //botón OK pulsado
                    Log.i("List","position $pos")
                    val indiceBorra=pos
                    //confirmacion deeliminacion
                    Log.i("List","position $indiceBorra")
                    //Log.i("List","position $ListaAlienigenas")
                    ServicBDDMemoria.eliminarUniverso(indiceBorra)
                    //adaptador.notifyDataSetChanged()
                    //Log.i("List","position $ListaAlienigenas")
                    vandera=true
                    Log.i("List","position $vandera")
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



}