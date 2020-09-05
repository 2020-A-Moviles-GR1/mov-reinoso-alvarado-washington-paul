package com.example.examen_1b_univ_alien

import java.util.*

class UniversoHttp (

    val createdAt : Long,
    val updatedAt: Long,
    val id: Int,
    val nombreUniverso : String,
    val antiguedadUniverso: Int,
    val tamanioUniverso: Double,
    val minTemperatura: Double,
    val universoPrimario: Boolean

){

    var fechaCreacion : Date
    var fechaActualizacion : Date
    init {
        fechaCreacion= Date(createdAt)
        fechaActualizacion= Date(updatedAt)
    }
}