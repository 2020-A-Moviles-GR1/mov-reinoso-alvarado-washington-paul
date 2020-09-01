package com.example.moviles_1
import android.view.View
import android.view.ViewGroup

// Para usar recyclerview necesitamos importar Android X y añadir la dependencia:
// implementartion ''

class RecyclerAdaptador(
    private val listaUsuarios: List<UsuarioHttp>,
//    private val contexto
    private val recyclerView: androidx.recyclerview.widget.RecyclerView
) : androidx.recyclerview.widget.RecyclerView.Adapter<RecyclerAdaptador.MyViewHolder>() {
    inner class MyViewHolder(view: View) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}