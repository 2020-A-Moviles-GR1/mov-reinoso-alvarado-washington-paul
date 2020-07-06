class Menu {


    fun imprimirEncavezado(){
        println("MENU UNIVERSAL")
        println("1.Crear nuevo universo")
        println("2.Buscar un universo")
        println("3. Modificar un universo")
        println("4. Eliminar un universo")
        println("5. Mostrar universos")
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
            1 -> creacionUniversal()
            2 -> buscaUnivers()
            3 -> modificarUnivers()
            4 -> eliminarUnivers()
            5 -> mostraUniver()
            6 -> salir = true
                else -> {
                print("No corresponde a ningúna entrada")
                }
            }
        }



    }

    fun creacionUniversal(){
        var nombreUniverso: String
        var antiguedadUniverso: Int
        var tamanioUniverso: Float
        var minTemperatura: Double
        var universoPrimario:Boolean

        println("Crea un nuevo universo!!")
        println("Ingresa el nombre del universo : ")
        nombreUniverso = readLine()?.toString() as String

        println("Ingresa la antiguedad del universo :")
        antiguedadUniverso = readLine()?.toInt() as Int

        println("Ingresa el tamanio del universo :")
        tamanioUniverso = readLine()?.toFloat() as Float

        println("Ingresa la temperatura minima del universo :")
        minTemperatura = readLine()?.toDouble() as Double

        println("El universo es primario:")
        universoPrimario = readLine()?.toBoolean() as Boolean

        val controlU=ControlUniverso()
        controlU.creacionUniversos(nombreUniverso,antiguedadUniverso,tamanioUniverso,minTemperatura,universoPrimario)

    }

    fun buscaUnivers(){
        var nombreUniverso: String
        println("Busca tu universo")
        println("Ingresa el nombre del universo : ")
        nombreUniverso = readLine()?.toString() as String
        val controlU=ControlUniverso()
        val uni=controlU.buscarUniverso(nombreUniverso)
        println(uni)
    }

    fun modificarUnivers(){
        var nombreUniverso: String
        var modificacion: String
        println("Modifica tu Universo")
        println("Usa el siguiente formato de ingreso!!! :")
        println("nombre del Universo:universo-M-85")
        println("antiguedad del Universo:5000")
        println("tamanio del Universo:3425.19")
        println("min Temperatura:35.5")
        println("Universo primario:true")

        println("Ingresa la modificacion: ")
        modificacion = readLine()?.toString() as String

        println("Ingresa el nombre del universo a modificar: ")
        nombreUniverso = readLine()?.toString() as String
        val controlU=ControlUniverso()
        controlU.modificrUniverso(modificacion,nombreUniverso)
    }


    fun eliminarUnivers(){
        var nombreUniverso: String
        println("Destruye un universo")
        println("Cuidado tambien destruiras a los aliens que vivan en ahi !!!")
        println("Ingresa el nombre del universo a eliminar: ")
        nombreUniverso = readLine()?.toString() as String
        val controlU=ControlUniverso()
        controlU.eliminarUniverso(nombreUniverso)
    }

    fun mostraUniver(){
        val controlU=ControlUniverso()
        controlU.leerDelArchivoUniverso()
    }
}