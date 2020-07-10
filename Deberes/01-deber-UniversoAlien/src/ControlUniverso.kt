import java.io.File
import java.nio.file.Files.write
import java.nio.file.StandardOpenOption
import java.io.BufferedReader

class ControlUniverso {

    //FUNCION PARA LA CREACION DE UNIVERSOS

    fun creacionUniversos(
            nombreUniverso: String,
            antiguedadUniverso: Int,
            tamanioUniverso: Float,
            minTemperatura: Double,
            universoPrimario: Boolean
    ) {
        val universo1 = Universo(nombreUniverso,
                antiguedadUniverso,
                tamanioUniverso,
                minTemperatura,
                universoPrimario
        )
        //--> append
        val outString = universo1.toString()
        val archivo = File("archivos\\universo")
        write(archivo.toPath(), outString.toByteArray(), StandardOpenOption.APPEND)
        println("Universo Creado")
        leerDelArchivoUniverso()
    }

    //FUNCION PARA BUSCAR UNIVERSOS

    fun buscarUniverso(nombreUniverso: String): List<String>? {
        var vector1: List<String>
        var vectorResult: List<String> = listOf("", "", "", "", "")
        var cont = 0

        val bufferedReader: BufferedReader = File("archivos\\universo").bufferedReader()
        val lineas = mutableListOf<String>()
        bufferedReader.useLines { lines -> lines.forEach { lineas.add(it) } }

        for (i: Int in lineas.indices) {
            vector1 = lineas[i].split(",") //reorna un ArrayList
            if (vector1[0] == nombreUniverso) {
                vectorResult = vector1
                println("universo encontrado")
            } else {
                cont = cont + 1
            }
        }
        if (cont == lineas.size) {
            println("universo no existente")
            vectorResult = emptyList()
        }
        return vectorResult;
    }

    //FUNCION PARA MODIFICAR UNIVERSOS

    fun modificrUniverso(tipo: String,nombreUniver: String) {
        var vector1: MutableList<String> = mutableListOf()
        var vectorResult: List<String> = listOf("", "", "", "", "")
        val tipoDato = tipo.split(":")
        var cont = 0
        val indice: Int
        var lineaReEscrita: String
        var lineasNuevasUni: ArrayList<String> = arrayListOf()


        if (tipoDato[0] == "nombre del Universo") {
            indice = 0
        } else if (tipoDato[0] == "antiguedad del Universo") {
            indice = 1
        } else if (tipoDato[0] == "tamanio del Universo") {
            indice = 2
        } else if (tipoDato[0] == "min Temperatura") {
            indice = 3
        } else {
            indice = 4
        }

        val bufferedReader: BufferedReader = File("archivos\\universo").bufferedReader()
        val lineas = mutableListOf<String>()
        bufferedReader.useLines { lines -> lines.forEach { lineas.add(it) } }

        for (i: Int in lineas.indices) {
            vector1 = lineas[i].split(",") as MutableList<String>//reorna un ArrayList
            if(vector1[0]==nombreUniver){
                for (j: Int in vector1.indices) {
                    if (j==indice) {
                        vector1[j] = tipoDato[1]
                        if (indice == 5) {
                            vector1[j] = tipoDato[1] + "\n"
                            println("universo encontrado")
                        }
                        println("universo encontrado")
                    }
                }
            } else {
                cont = cont + 1
                //print(cont)
            }
            lineaReEscrita = vector1.joinToString(separator = ",")+"\n"
            lineasNuevasUni.add(lineaReEscrita)
        }
        if(cont==lineas.size){
            println("Universo no encontrado")
        }
        for (iter: Int in lineasNuevasUni.indices) {
            if(iter==0){
                File("archivos\\universo").bufferedWriter().use { out -> out.write(lineasNuevasUni[0])}
            }else{
                val archivo = File("archivos\\universo")
                write(archivo.toPath(), lineasNuevasUni[iter].toByteArray(), StandardOpenOption.APPEND)
            }
        }
    }

//FUNCION PARA ELIMINAR UNIVERSOS

    fun eliminarUniverso(nombreUniver: String){

        var vector1: MutableList<String> = mutableListOf()
        val vector2: MutableList<String> = mutableListOf("","","","","")
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

        val bufferedReader: BufferedReader = File("archivos\\universo").bufferedReader()
        val lineas = mutableListOf<String>()
        bufferedReader.useLines { lines -> lines.forEach { lineas.add(it) } }

        for (i: Int in lineas.indices) {
            vector1 = lineas[i].split(",") as MutableList<String>//reorna un ArrayList
            if(vector1[0]==nombreUniver){
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
                //print(cont)
            }
            lineaReEscrita = vector1.joinToString(separator = ",")+"\n"

            if(lineaReEscrita!=",,,,"+"\n"){
                lineasNuevasUni.add(lineaReEscrita)
            }

        }
        if(cont==lineas.size){
            println("Universo no encontrado")
        }
        for (iter: Int in lineasNuevasUni.indices) {
            if(iter==0){
                File("archivos\\universo").bufferedWriter().use { out -> out.write(lineasNuevasUni[0])}
            }else{
                val archivo = File("archivos\\universo")
                write(archivo.toPath(), lineasNuevasUni[iter].toByteArray(), StandardOpenOption.APPEND)
            }
        }
        //destruir aliensa de este universo
        val controlAlien =ControlAlien()
        controlAlien.eliminarAlienUniverso(nombreUniver)
    }

//VISUALIZAR UNIVERSO

    fun leerDelArchivoUniverso() {
        //retorna string
        //val inputStream: InputStream = File("archivos\\universo").inputStream()
        //val inputString = inputStream.bufferedReader().use { it.readText() }

        val bufferedReader: BufferedReader = File("archivos\\universo").bufferedReader()
        val lineas = mutableListOf<String>()
        bufferedReader.useLines { lines -> lines.forEach { lineas.add(it) } }
        lineas.forEach { println(" $it") }
        //println(lineas) // muestra en consolaTodo el archivo
        //println(lineas.size)
        //println("${lineas::class.simpleName}")
        //println("${lineas::class.qualifiedName}")
    }

}