package com.example.examen_1b_univ_alien

import android.widget.AdapterView

class ServicBDDMemoria {

    companion object {

        // Gestion de Universo

        val listaAlien = arrayListOf<Alien>()
        val listaUniverso = arrayListOf<Universo>()

        fun ListaAliensLlena() {
            this.listaAlien.add(Alien("Kitsune", 1.9F, 30.7, 21, false, "universo-B-32"))
            this.listaAlien.add(Alien("Omicroniano", 2.23F, 50.4, 25, true, "universo-A-554"))
            this.listaAlien.add(Alien("Lican", 1.9F, 30.7, 21, false, "universo-ZM-32"))
            this.listaAlien.add(Alien("Draconiano", 2.23F, 50.4, 25, true, "universo-A-554"))
            this.listaAlien.add(Alien("Kish", 1.9F, 30.7, 21, false, "universo-ZM-32"))
        }

        fun añadirCrearAlienigena(
            razaAln: String,
            altura: Float,
            peso: Double,
            edad: Int,
            ostilidad: Boolean,
            universo: String
        ) {
            this.listaAlien.add(Alien(razaAln, altura, peso, edad, ostilidad, universo))
        }

        fun BuscarUnAlienIndice(indice: Int): Alien {
            val j = 0
            var alien1 = Alien("", 0.0F, 0.0, 0, false, "")
            for (j in 0..this.listaAlien.size) {
                if (j == indice) {
                    alien1 = this.listaAlien.get(j)
                }
            }
            return alien1
        }

        fun BuscarUnAlienRaza(raza: String): Alien {
            var alien1 = Alien("", 0.0F, 0.0, 0, false, "")
            for (a in this.listaAlien) {
                if (a.razaAlien == raza) {
                    alien1 = this.listaAlien.get(this.listaAlien.indexOf(a))
                }
            }
            return alien1
        }


        fun EditarAlien(pos: Int, alien: Alien) {
            //var i=0
            for (i in this.listaAlien.indices) {
                //val razai=this.listaAlien[i].razaAlien
                if (i == pos) {
                    this.listaAlien[i] = alien
                }
            }
        }

        fun eliminarAlien(pos: Int) {
            this.listaAlien.removeAt(pos)
        }

        fun eliminarAlienNumbreUnivrs(nombreUniB: String,alienL:ArrayList<Alien>) {
            var alienR = Alien("", 0.0F, 0.0, 0, false, "")
            //for(i in this.listaAlien.indices){
            //    if(this.listaAlien[i].nombreUnivers==nombreUniB){
            //        this.listaAlien.removeAt(i)
            //    }
            //}
            for (alienR in alienL) {
                if (alienR.nombreUnivers == nombreUniB) {
                    this.listaAlien.remove(alienR)
                }
            }
        }

        // Gestion de Universo

        fun ListaUniversoLlena() {

            this.listaUniverso.add(Universo("universo-A-554", 76000, 234332.433F, 273.2, true))
            this.listaUniverso.add(Universo("universo-ZM-32", 5000, 288332.4F, 211.21, false))
            this.listaUniverso.add(Universo("universo-M-182", 8349, 56332.0F, 22.9, false))
            this.listaUniverso.add(Universo("universo-G-29", 9049, 70332.24F, 12.2, true))
            this.listaUniverso.add(Universo("universo-N-56", 4549, 23332.19F, 52.5, false))
            this.listaUniverso.add(Universo("universo-P-37", 7345, 18032.3F, 82.8, true))
        }


        fun añadirCrearUneverso(
            nombreUniverso: String,
            antiguedadUniverso: Int,
            tamanioUniverso: Float,
            minTemperatura: Double,
            universoPrimario: Boolean
        ) {
            this.listaUniverso.add(
                Universo(
                    nombreUniverso,
                    antiguedadUniverso,
                    tamanioUniverso,
                    minTemperatura,
                    universoPrimario
                )
            )
        }

        fun BuscarUnUniversoIndice(indice: Int): Universo {
            val j = 0
            var univ1 = Universo("", 0, 0.0F, 0.0, false)
            for (j in 0..this.listaUniverso.size) {
                if (j == indice) {
                    univ1 = this.listaUniverso.get(j)
                }
            }
            return univ1
        }

        fun BuscarUnUniversoNombre(nombreU: String): Universo {
            var univ1 = Universo("", 0, 0.0F, 0.0, false)
            for (a in this.listaUniverso) {
                if (a.nombreUniverso == nombreU) {
                    univ1 = this.listaUniverso.get(this.listaUniverso.indexOf(a))
                }
            }
            return univ1
        }

        fun EditarUniverso(pos: Int, universo: Universo) {
            //var i=0
            for (i in this.listaUniverso.indices) {
                //val razai=this.listaAlien[i].razaAlien
                if (i == pos) {
                    this.listaUniverso[i] = universo
                }
            }
        }

        fun eliminarUniverso(pos: Int) :String{
            var nombreUniverso=""
            for (i in this.listaUniverso.indices) {
                //val razai=this.listaAlien[i].razaAlien
                if (i == pos) {
                    nombreUniverso = this.listaUniverso[i].nombreUniverso
                }
            }
            this.listaUniverso.removeAt(pos)
            return nombreUniverso
        }
    }
}