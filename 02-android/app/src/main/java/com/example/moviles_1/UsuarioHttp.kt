package com.example.moviles_1

import com.beust.klaxon.Converter
import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonValue
import com.beust.klaxon.Klaxon
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
    var Pokemons :ArrayList<PokemonHttp> ? = null
){


    companion object {
        val myConverter = object: Converter {
            override fun canConvert(cls: Class<*>) = cls == UsuarioHttp::class.java

            override fun toJson(value: Any): String {
                val usuario = value as UsuarioHttp

                return """
                  { 
                    "createdAt": ${usuario.createdAt},
                    "updatedAt": ${usuario.updatedAt},
                    "id": ${usuario.id}, 
                    "cedula": "${usuario.cedula}",
                    "nombre": "${usuario.nombre}",
                    "correo": "${usuario.correo}",
                    "estdoCivil": "${usuario.estdoCivil}",
                    "password": "${usuario.password}",
                    "pokemons": ${Klaxon().toJsonString(usuario.Pokemons as List<*>)}
                   }
                    
                    }
                """.trimMargin()
            }

            override fun fromJson(jv: JsonValue) : UsuarioHttp {

                return UsuarioHttp(
                    jv.obj?.get("createdAt") as Long,
                    jv.obj?.get("updatedAt") as Long,
                    jv.objInt("id"),
                    jv.objString("cedula"),
                    jv.objString("nombre"),
                    jv.objString("correo"),
                    jv.objString("estadoCivil"),
                    jv.objString("password"),
                    Klaxon().parseFromJsonArray<PokemonHttp>(jv.obj?.get("pokemons") as JsonArray<*>) as ArrayList<PokemonHttp>
                )
            }
        }
    }

    var fechaCreacion : Date
    var fechaActualizacion : Date
    init {
        fechaCreacion= Date(createdAt)
        fechaActualizacion= Date(updatedAt)
    }

    override fun toString(): String {

        if(Pokemons!=null) {
            return "Usuario-Http (id=$id," +
                    " createdAt=$createdAt," +
                    " updatedAt=$updatedAt," +
                    " cedula='$cedula'," +
                    " nombre='$nombre'," +
                    " correo='$correo'," +
                    " estadoCivil='$estdoCivil'," +
                    " password='$password'," +
                    " fechaCreacion=$fechaCreacion," +
                    " fechaActualizacion=$fechaActualizacion)" + ("pokemons=$Pokemons")
        }
        else {
        }
            return "Usuario-Http (id=$id," +
                    " createdAt=$createdAt," +
                    " updatedAt=$updatedAt," +
                    " cedula='$cedula'," +
                    " nombre='$nombre'," +
                    " correo='$correo'," +
                    " estadoCivil='$estdoCivil'," +
                    " password='$password'," +
                    " fechaCreacion=$fechaCreacion," +
                    " fechaActualizacion=$fechaActualizacion)" + ("")
    }
}