package com.example.moviles_1
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

// Para usar recyclerview necesitamos importar Android X y añadir la dependencia:
// implementartion ''

class RecyclerAdaptador(
    private val listaUsuarios: List<UsuarioHttp>,
    private val contexto : RecyclerVIewActivity,
    private val recyclerView: androidx.recyclerview.widget.RecyclerView
) : androidx.recyclerview.widget.RecyclerView.Adapter<RecyclerAdaptador.MyViewHolder>() {
    inner class MyViewHolder(view: View) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        val nombreTextView:TextView
        val cedulaTextView:TextView
        val likesTextView: TextView
        val accionButton:Button
        var numeroLikes=0
        init {
            nombreTextView=view.findViewById(R.id.tv_nombre)
            cedulaTextView=view.findViewById(R.id.tv_cedula)
            accionButton= view.findViewById(R.id.btn_accion)
            likesTextView = view.findViewById(R.id.tv_likes)
            accionButton.setOnClickListener{
                anadirLike()
            }
        }

        fun anadirLike(){
            this.numeroLikes=this.numeroLikes+1
            likesTextView.text=this.numeroLikes.toString()
            contexto.anadirLikesEnActividad(1)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //TODO("Not yet implemented")
        //Definimos la interfaz a usar
        val itemView=LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.adptador_persona,
                parent,
                false
            )
        return MyViewHolder(itemView)
    }


    override fun getItemCount(): Int {
        //TODO("Not yet implemented")
        //definimos la lista a usar
        return  listaUsuarios.size


    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //TODO("Not yet implemented")
        //funcion a ejecutarce con cada item que tengamos (itera)
        //holder: MyViewHolder clase implememntada arriba
        // position: Int: la posicion
        val usuario = listaUsuarios[position]
        holder.nombreTextView.text=usuario.nombre
        holder.cedulaTextView.text=usuario.cedula
        holder.accionButton.text="Like${usuario.nombre}"

        holder.likesTextView.text="0"
    }
}