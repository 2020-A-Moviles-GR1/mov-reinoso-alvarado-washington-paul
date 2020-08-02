package com.example.examen_1b_univ_alien

class Universo(
    var nombreUniverso: String,
    var antiguedadUniverso: Int,
    var tamanioUniverso: Float,
    var minTemperatura: Double,
    var universoPrimario:Boolean
){
    //funciones de la clase aqui
    override fun toString ():String{
        return "${nombreUniverso},${antiguedadUniverso},${tamanioUniverso},${minTemperatura},${universoPrimario}\n"
    }

}