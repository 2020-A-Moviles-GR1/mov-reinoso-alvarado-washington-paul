package com.example.examen_1b_univ_alien

import android.os.Bundle
import android.util.Log
import android.widget.AdapterView

class ServicBDDMemoria {

    companion object {
        val listaAlien = arrayListOf<Alien>()

        fun ListaAliensLlena() {
            this.listaAlien.add(Alien("Kitsune", 1.9F, 30.7, 21, false, "universo-B-32"))
            this.listaAlien.add(Alien("Omicroniano", 2.23F, 50.4, 25, true, "universo-A-554"))
            this.listaAlien.add(Alien("Lican", 1.9F, 30.7, 21, false, "universo-B-32"))
            this.listaAlien.add(Alien("Draconiano", 2.23F, 50.4, 25, true, "universo-A-554"))
            this.listaAlien.add(Alien("Kish", 1.9F, 30.7, 21, false, "universo-B-32"))
        }

        fun añadirCrearAlienigena(razaAln:String,
                                  altura:Float,
                                  peso:Double,
                                  edad:Int,
                                  ostilidad:Boolean,
                                  universo:String
                                  ){
            this.listaAlien.add(Alien(razaAln, altura, peso, edad, ostilidad, universo))
        }

        fun BuscarUnAlienIndice(indice:Int) : Alien{
            val j=0
            var alien1 = Alien("",0.0F,0.0,0,false,"")
            for (j in 0..this.listaAlien.size){
                if(j==indice){
                   alien1=this.listaAlien.get(j)
                }
            }
            return alien1
        }

        fun BuscarUnAlienRaza(raza:String) : Alien{
            var alien1 = Alien("",0.0F,0.0,0,false,"")
            for (a in this.listaAlien){
                if(a.razaAlien==raza){
                    alien1=this.listaAlien.get(this.listaAlien.indexOf(a))
                }
            }
            return alien1
        }
        fun EditarAlien(pos:Int,alien:Alien){
            //var i=0
            for (i in this.listaAlien.indices){
                //val razai=this.listaAlien[i].razaAlien
                if(i==pos){
                    this.listaAlien[i]=alien
                }
            }
        }

        fun eliminarAlien(pos:Int){
            this.listaAlien.removeAt(pos)
        }

    }
}