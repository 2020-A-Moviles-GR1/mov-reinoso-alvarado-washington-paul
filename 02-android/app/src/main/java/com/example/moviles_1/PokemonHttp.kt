package com.example.moviles_1
import com.beust.klaxon.Converter
import com.beust.klaxon.JsonObject
import com.beust.klaxon.JsonValue
import com.beust.klaxon.Klaxon
import java.util.*

class PokemonHttp (
    var createdAt:Long,
    var updatedAt:Long,
    var id:Int,
    var nombre:String,
    var usuario: Any?

){
    companion object {

        val myConverter = object: Converter {

            override fun canConvert(cls: Class<*>) = cls == PokemonHttp::class.java

            override fun toJson(value: Any): String {

                val pokemon = value as PokemonHttp
                var usuario: Any?

                if(pokemon.usuario is Int){
                    usuario = pokemon.usuario
                }else if(pokemon.usuario is UsuarioHttp){
                    usuario = Klaxon().toJsonString(pokemon.usuario as UsuarioHttp)
                }else{
                    throw Error("error")
                }

                return """
                  {
                    "id": ${pokemon.id},
                    "createdAt": ${pokemon.createdAt},
                    "updatedAt": ${pokemon.updatedAt},
                    "nombre": "${pokemon.nombre}",
                    "usuario": ${usuario}
                   }
                """.trimMargin()
            }

            override fun fromJson(jv: JsonValue) : PokemonHttp {

                if(jv.obj?.get("usuario") is JsonObject){

                    return PokemonHttp(
                        jv.obj?.get("createdAt") as Long,
                        jv.obj?.get("updatedAt") as Long,
                        jv.objInt("id"),
                        jv.objString("nombre"),
                        Klaxon().parseFromJsonObject<UsuarioHttp>(jv.obj?.get("usuario") as JsonObject)

                    )
                }else if(jv.obj?.get("usuario") is Int){
                    return PokemonHttp(
                        jv.obj?.get("createdAt") as Long,
                        jv.obj?.get("updatedAt") as Long,
                        jv.objInt("id"),
                        jv.objString("nombre"),
                        jv.objInt("usuario")
                    )
                }else{
                    throw Error("error")
                }

            }

        }

    }

    var fechaCreacion :Date
    var fechaActualizacion : Date
    init {
        fechaCreacion= Date(createdAt)
        fechaActualizacion=Date(updatedAt)
    }

    override fun toString(): String {
        return "Pokemon-Http (id=$id," +
                " createdAt=$createdAt," +
                " updatedAt=$updatedAt," +
                " nombre='$nombre'," +
                " usuario=$usuario," +
                " fechaCreacion=$fechaCreacion," +
                " fechaActualizacion=$fechaActualizacion)"
    }

}