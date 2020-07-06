import java.io.File
import java.nio.file.Files.write
import java.nio.file.StandardOpenOption
import java.io.BufferedReader

class ControlAlien {

    //FUNCION PARA LA CREACION DE ALIENS

    fun creacionAliens(
            razaAlien:String,
            alturaAlien:Float,
            pesoAlien:Double,
            edadAlien:Int,
            ostilidadAlien:Boolean,
            nombreUnivers:String
    ) {
        val alien1 = Alien(
                razaAlien,
                alturaAlien,
                pesoAlien,
                edadAlien,
                ostilidadAlien,
                nombreUnivers)

        //--> append
        val outString = alien1.toString()
        val archivo = File("archivos\\aliens")
        write(archivo.toPath(), outString.toByteArray(), StandardOpenOption.APPEND)
        leerDelArchivoAliens()
    }

    //FUNCION PARA BUSCAR ALIENS

    fun buscarAlien(raza: String): List<String>? {
        var vector1: List<String>
        var vectorResult: List<String> = listOf("", "", "", "", "","")
        var cont = 0

        val bufferedReader: BufferedReader = File("archivos\\aliens").bufferedReader()
        val lineas = mutableListOf<String>()
        bufferedReader.useLines { lines -> lines.forEach { lineas.add(it) } }

        for (i: Int in lineas.indices) {
            vector1 = lineas[i].split(",") //reorna un ArrayList
            if (vector1[0] == raza) {
                vectorResult = vector1
                println("alien encontrado")
            } else {
                cont = cont + 1
            }
        }
        if (cont == lineas.size) {
            println("alien no existente")
            vectorResult = emptyList()
        }
        return vectorResult;
    }

    //FUNCION PARA MODIFICAR UNIVERSOS

    fun modificrAlien(tipo: String,raza: String) {
        var vector1: MutableList<String> = mutableListOf()
        var vectorResult: List<String> = listOf("", "", "", "", "")
        val tipoDato = tipo.split(":")
        var cont = 0
        val indice: Int
        var lineaReEscrita: String
        var lineasNuevasUni: ArrayList<String> = arrayListOf()


        if (tipoDato[0] == "raza alienigena") {
            indice = 0
        } else if (tipoDato[0] == "altura alienigena") {
            indice = 1
        } else if (tipoDato[0] == "peso alienigena") {
            indice = 2
        }else if (tipoDato[0] == "edad alienigena") {
            indice = 3
        } else if (tipoDato[0] == "ostilidad") {
            indice = 4
        } else {
            indice = 5
        }

        val bufferedReader: BufferedReader = File("archivos\\aliens").bufferedReader()
        val lineas = mutableListOf<String>()
        bufferedReader.useLines { lines -> lines.forEach { lineas.add(it) } }

        for (i: Int in lineas.indices) {
            vector1 = lineas[i].split(",") as MutableList<String>//reorna un ArrayList
            if(vector1[0]==raza){
                for (j: Int in vector1.indices) {
                    if (j==indice) {
                        vector1[j] = tipoDato[1]
                        if (indice == 6) {
                            vector1[j] = tipoDato[1] + "\n"
                            println("alien encontrado")
                        }
                        println("alien encontrado")
                    }
                }
            } else {
                cont = cont + 1
                print(cont)
            }
            lineaReEscrita = vector1.joinToString(separator = ",")+"\n"
            lineasNuevasUni.add(lineaReEscrita)
        }
        if(cont==lineas.size){
            println("Alien no encontrado")
        }
        for (iter: Int in lineasNuevasUni.indices) {
            if(iter==0){
                File("archivos\\aliens").bufferedWriter().use { out -> out.write(lineasNuevasUni[0])}
            }else{
                val archivo = File("archivos\\aliens")
                write(archivo.toPath(), lineasNuevasUni[iter].toByteArray(), StandardOpenOption.APPEND)
            }
        }
    }

//FUNCION PARA ELIMINAR ALIENS

    fun eliminarAlien(raza: String){

        var vector1: MutableList<String> = mutableListOf()
        val vector2: MutableList<String> = mutableListOf("","","","","","")
        //var vectorResult: List<String> = listOf("", "", "", "", "")
        //val tipoDato = tipo.split(":")
        var cont = 0
        val indice: Int
        var lineaReEscrita: String
        var lineasNuevasUni: ArrayList<String> = arrayListOf()


        /*if (tipoDato[0] == "nombre del Universo") {
            indice = 0
        } else if (tipoDato[0] == "antiguedad del Universo") {
            indice = 1
        } else if (tipoDato[0] == "tamanio del Universo") {
            indice = 2
        } else if (tipoDato[0] == "min Temperatura") {
            indice = 3
        } else {
            indice = 4
        }*/

        val bufferedReader: BufferedReader = File("archivos\\aliens").bufferedReader()
        val lineas = mutableListOf<String>()
        bufferedReader.useLines { lines -> lines.forEach { lineas.add(it) } }

        for (i: Int in lineas.indices) {
            vector1 = lineas[i].split(",") as MutableList<String>//reorna un ArrayList
            if(vector1[0]==raza){
                vector1=vector2
                /*for (j: Int in vector1.indices) {
                    if (j==indice) {
                        vector1[j] = tipoDato[1]
                        if (indice == 5) {
                            vector1[j] = tipoDato[1] + "\n"
                            println("universo encontrado")
                        }
                        println("universo encontrado")
                    }
                }*/
            } else {
                cont = cont + 1
                print(cont)
            }
            lineaReEscrita = vector1.joinToString(separator = ",")+"\n"

            if(lineaReEscrita!=",,,,,"+"\n"){
                lineasNuevasUni.add(lineaReEscrita)
            }

        }
        if(cont==lineas.size){
            println("Alien no encontrado")
        }
        for (iter: Int in lineasNuevasUni.indices) {
            if(iter==0){
                File("archivos\\aliens").bufferedWriter().use { out -> out.write(lineasNuevasUni[0])}
            }else{
                val archivo = File("archivos\\aliens")
                write(archivo.toPath(), lineasNuevasUni[iter].toByteArray(), StandardOpenOption.APPEND)
            }
        }
    }

// ELIMINAR ALIEN POR SU UNIVERSO

    fun eliminarAlienUniverso(nombUniverso: String){

        var vector1: MutableList<String> = mutableListOf()
        val vector2: MutableList<String> = mutableListOf("","","","","","")
        //var vectorResult: List<String> = listOf("", "", "", "", "")
        //val tipoDato = tipo.split(":")
        var cont = 0
        val indice: Int
        var lineaReEscrita: String
        var lineasNuevasUni: ArrayList<String> = arrayListOf()

        /*if (tipoDato[0] == "nombre del Universo") {
            indice = 0
        } else if (tipoDato[0] == "antiguedad del Universo") {
            indice = 1
        } else if (tipoDato[0] == "tamanio del Universo") {
            indice = 2
        } else if (tipoDato[0] == "min Temperatura") {
            indice = 3
        } else {
            indice = 4
        }*/

        val bufferedReader: BufferedReader = File("archivos\\aliens").bufferedReader()
        val lineas = mutableListOf<String>()
        bufferedReader.useLines { lines -> lines.forEach { lineas.add(it) } }

        for (i: Int in lineas.indices) {
            vector1 = lineas[i].split(",") as MutableList<String>//reorna un ArrayList
            if(vector1[5]==nombUniverso){
                vector1=vector2
                /*for (j: Int in vector1.indices) {
                    if (j==indice) {
                        vector1[j] = tipoDato[1]
                        if (indice == 5) {
                            vector1[j] = tipoDato[1] + "\n"
                            println("universo encontrado")
                        }
                        println("universo encontrado")
                    }
                }*/
            } else {
                cont = cont + 1
                print(cont)
            }
            lineaReEscrita = vector1.joinToString(separator = ",")+"\n"
            print(lineaReEscrita)
            if(lineaReEscrita!=",,,,,"+"\n"){
                lineasNuevasUni.add(lineaReEscrita)
            }

        }
        if(cont==lineas.size){
            println("universo no encontrado")
        }
        for (iter: Int in lineasNuevasUni.indices) {
            if(iter==0){
                File("archivos\\aliens").bufferedWriter().use { out -> out.write(lineasNuevasUni[0])}
            }else{
                val archivo = File("archivos\\aliens")
                write(archivo.toPath(), lineasNuevasUni[iter].toByteArray(), StandardOpenOption.APPEND)
            }
        }
    }

//VISUALIZAR ALIENS

    fun leerDelArchivoAliens() {
        //retorna string
        //val inputStream: InputStream = File("archivos\\universo").inputStream()
        //val inputString = inputStream.bufferedReader().use { it.readText() }

        val bufferedReader: BufferedReader = File("archivos\\aliens").bufferedReader()
        val lineas = mutableListOf<String>()
        bufferedReader.useLines { lines -> lines.forEach { lineas.add(it) } }
        lineas.forEach { println(" $it") }
        //println(lineas) // muestra en consolaTodo el archivo
        //println(lineas.size)
        //println("${lineas::class.simpleName}")
        //println("${lineas::class.qualifiedName}")
    }



}