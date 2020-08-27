package com.example.moviles_1

import java.util.*
import kotlin.collections.ArrayList

class UsuarioHttp (

    var createdAt:Long,
    var updatedAt:Long,
    var id:Int,
    var cedula:String,
    var nombre:String,
    var correo:String,
    var estdoCivil:String,
    var password:String,
    var Pokemons :ArrayList<PokemonHttp>
){
    var fechaCreacion : Date
    var fechaActualizacion : Date
    init {
        fechaCreacion= Date(createdAt)
        fechaActualizacion= Date(updatedAt)
    }

}