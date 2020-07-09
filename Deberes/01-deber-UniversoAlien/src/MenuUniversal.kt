import kotlin.system.measureNanoTime

class MenuUniversal {

    fun imprimirEncavezado(){
        println("*********MENU PRINCIPAL**********")
        println("1. Ingreso al menu Universal")
        println("2. Ingreso al menu Alienigena")
        println("3. Salir")
    }

    fun opcionesMenuFinal() {

        var opcion: Int
        var salir = false
        while (!salir) {
            imprimirEncavezado()
            println("Selecciones una opcion : ")
            opcion = readLine()?.toInt() as Int

            when (opcion) {
                1 -> llamadaAlMenuUnoUniverso()
                2 -> llamadaAlMenuUnoAlien()
                3 -> salir = true
                else -> {
                    print("No corresponde a ningúna entrada")
                }
            }
        }

    }


    fun llamadaAlMenuUnoUniverso(){

        val menu1=Menu()
        menu1.opcionesMenu()

    }

    fun llamadaAlMenuUnoAlien(){

        val menu1=MenuAlien()
        menu1.opcionesMenu()

    }





}