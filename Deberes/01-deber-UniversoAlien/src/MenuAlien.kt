class MenuAlien {

    fun imprimirEncavezado(){
        println("MENU ALIENIGENA")
        println("1. Crear nuevo Alien")
        println("2. Buscar un Alien")
        println("3. Modificar un Alien")
        println("4. Eliminar un Alien")
        println("5. Mostrar Aliens")
        println("6. Salir")
    }

    fun opcionesMenu() {

        var opcion: Int
        var salir = false
        while (!salir) {
            imprimirEncavezado()
            println("Selecciones una opcion : ")
            opcion = readLine()?.toInt() as Int

            when (opcion) {
                1 -> creacionAlienigena()
                2 -> buscaAlienigena()
                3 -> modificarAlienigena()
                4 -> eliminarAlienigena()
                5 -> mostraAliens()
                6 -> salir = true
                else -> {
                    print("No corresponde a ningúna entrada")
                }
            }
        }

    }

    fun creacionAlienigena(){

        var razaAlien:String
        var alturaAlien:Float
        var pesoAlien:Double
        var edadAlien:Int
        var ostilidadAlien:Boolean
        var nombreUnivers:String

        println("Crea un nuevo alien!!")
        println("Ingresa la raza del alien : ")
        razaAlien = readLine()?.toString() as String

        println("Ingresa la altura del alien :")
        alturaAlien = readLine()?.toFloat() as Float

        println("Ingresa el peso del alien :")
        pesoAlien = readLine()?.toDouble() as Double

        println("Ingresa la edad del alien :")
        edadAlien = readLine()?.toInt() as Int

        println("El alien es ostil:")
        ostilidadAlien = readLine()?.toBoolean() as Boolean

        println("Ingresa el universo del alienigena : ")
        nombreUnivers = readLine()?.toString() as String


        val controlAlien=ControlAlien()
        controlAlien.creacionAliens(razaAlien,alturaAlien,pesoAlien,edadAlien,ostilidadAlien,nombreUnivers)

    }

    fun buscaAlienigena(){
        var razaAlien: String
        println("Busca un Alienigena")
        println("Ingresa la raz del alien : ")
        razaAlien = readLine()?.toString() as String
        val controlAlien=ControlAlien()
        val ali=controlAlien.buscarAlien(razaAlien)
        println(ali)
    }

    fun modificarAlienigena(){
        var razaAlien: String
        var modificacion: String

        println("Modifica un Alienigena")
        println("Usa el siguiente formato de ingreso!!! :")

        println("raza alienigena:Leshi")
        println("altura alienigena:1.45")
        println("peso alienigena:44.2")
        println("edad alienigena:22")
        println("ostilidad:true")
        println("nombre universo:universo-M-85")

        println("Ingresa la modificacion: ")
        modificacion = readLine()?.toString() as String

        println("Ingresa la raza del alien a modificar: ")
        razaAlien = readLine()?.toString() as String
        val controlAlien=ControlAlien()
        controlAlien.modificrAlien(modificacion,razaAlien)
    }


    fun eliminarAlienigena(){
        var razaAlien: String
        println("Destruye un alien")
        //println("Cuidado tambien destruiras a los aliens que vivan en ahi !!!")
        println("Ingresa la raza del alien a eliminar: ")
        razaAlien = readLine()?.toString() as String
        val controlAlien=ControlAlien()
        controlAlien.eliminarAlien(razaAlien)
    }

    fun mostraAliens(){
        val controlAlien=ControlAlien()
        controlAlien.leerDelArchivoAliens()
    }


}