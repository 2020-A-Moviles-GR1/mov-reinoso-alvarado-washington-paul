package com.example.moviles_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

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


        btn_intent_respuesta
            .setOnClickListener({boton->
                //this.irCicloVida()
                irIntentConRespuesta()
            })

        btn_intent_implicito
            .setOnClickListener({boton->
                enviarIntentConRespuesta()
            })

        btn_resp_propia
            .setOnClickListener({boton->
                enviarIntentConRespuestPropia()
            })

        btn_http
            .setOnClickListener({boton->
                abrirActividadHttp()
            })

        btn_recycler
            .setOnClickListener({boton->
                abrirRecyclerView()
            })

        btn_mapa
            .setOnClickListener{
                abrirMapa()
            }
    }
    fun abrirMapa(){
        val intentException=Intent(
            this,
            MapsActivity::class.java
        )
        //this.startActivity(intentException) metodo dentro de la clase
        startActivity(intentException)
    }

    fun abrirRecyclerView(){
        val intentException=Intent(
            this,
            RecyclerVIewActivity::class.java
        )
        //this.startActivity(intentException) metodo dentro de la clase
        startActivity(intentException)
    }


    fun abrirActividadHttp(){
        val intentException=Intent(
            this,
            HttpActivity::class.java
        )
        //this.startActivity(intentException) metodo dentro de la clase
        startActivity(intentException)
    }

    fun enviarIntentConRespuestPropia(){
        val intentException=Intent(
            this,
            IntentEnviaParametrosActivity::class.java
        )
        startActivityForResult(intentException,305)
    }

    fun enviarIntentConRespuesta(){
        val intentConRespuesta=Intent(
            Intent.ACTION_PICK,
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        )
        //this.startActivityForResult(intent,codigDeRespuesta)
        //304 lo pusimos nosotros no es ningun numero especial
        startActivityForResult(intentConRespuesta,304)

    }

    //override paraobtener los datos que queremos

    override fun onActivityResult(
        requestCode: Int, //numero que nosotros envimos 304
        resultCode: Int, //valor diferente devuelto cuando selecionamos o no, algun elemento
        data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (resultCode){
            RESULT_OK->{
                Log.i("resultado","OK")
                when (requestCode){
                    304->{//contactos
                        val uri = data?.data
                        if (uri != null) {
                            val cursor = contentResolver.query(
                                uri,
                                null,
                                null,
                                null,
                                null,
                                null
                            )
                            cursor?.moveToFirst()
                            val indiceTelefono = cursor?.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.NUMBER
                            )
                            val telefono = cursor?.getString(indiceTelefono!!)//EL(!!)especifica que si recibiremos algo
                            cursor?.close()
                            Log.i("resultado", "Telefono: ${telefono}")
                        }
                    }
                    305->{
                       if(data!=null){
                           val nombre=data.getStringExtra("nombre")
                           val edad=data.getIntExtra("edad",0)
                           Log.i("resultado", "nombre: ${nombre} edad: ${edad}")

                       }
                    }
                }
            }
            RESULT_CANCELED->{
                Log.i("resultado","=(")
            }
        }
    }



    fun irIntentConRespuesta(){
        val intentException=Intent(
            this,
            IntentEnviaParametrosActivity::class.java
        )
        //agregando parametro (primitivo entero)
        intentException.putExtra("numero",2)
        val paul=Usuario(
            "Paul",
            15,
            Date(),
            1.0
        )
        val kiara = Mascota(
            "Kiara",
            paul
        )
        val aregloMascotas= arrayListOf<Mascota>(kiara)
        intentException.putExtra("Kiara",kiara)
        intentException.putExtra("arregloMascotas",aregloMascotas)

        startActivity(intentException)
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