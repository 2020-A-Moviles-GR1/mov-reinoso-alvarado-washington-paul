import java.util.*
import kotlin.collections.ArrayList

fun main (args:Array<String>  ){
println("hola mundo")
    
    // Ejemplo java
    // Int edad = 31
    // Mutables
    var edadProfesor =31 // no especificamos tipo de dato
                         // ; no es necesario
    //Duck Typing
    //var edadCachorro; X -> necesito el tipo de dato
    var edadCachorro : Int
    edadCachorro=3
    edadProfesor=32
    edadCachorro=4
    // Inmutables
    val numeroCuenta=123456     //Este tipo de variable no puede ser reasignada
    // numeroCuenta=123
    
    //tipo variables
    val sueldo =12.20
    val nombreProfesor="Vicente Eguez"
    val apellidoProfesor: Char ='a'
    //instanciar clase
    val fechaNacimiento= Date() //new Date()

    if (sueldo == 12.20){
        println("-");
    }else{
    }

    when (sueldo){ //es como un swtch
         12.20 -> println("sueldo normal")
        -12.20 -> println("sueldo negtivo")
          else -> println(" no se reconoce el sueldo")
    }

    val esSueldoMayorAlEstablecido = if(sueldo==12.20) true else false //if else rapidamente
    //expresion ? X : Y
    imprimirMensaje1()

}
//FUNCIONES
//ver errores alt+Enter
//si la funcion no devuelve nada no debemos poner nada

    fun imprimirMensaje() : Int { //unit = void
    return 10;
    }
fun imprimirMensaje1(){ //unit = void
    calcularSueldo(1000.00,14.40,calculoEspecial = null)
    calcularSueldo( tasa= 10.00, sueldo=120.00,calculoEspecial = null)
    calcularSueldo(
            16.00,
            14.00,
            null
    )
    calcularSueldo(sueldo = 12.00)
    val arregloConstante: Array<Int> = arrayOf(1,2,3)  //no se puede añadir elementos
    val arregloCumpleaños: ArrayList<Int> = arrayListOf(30,31,32,33,20)  //se puede añadir y eliminar elementos
    println(arregloCumpleaños)
    arregloCumpleaños.add(24)
    println(arregloCumpleaños)
    arregloCumpleaños.remove(30)
    println(arregloCumpleaños)

//sintasys de funciones pra iteracion
    arregloCumpleaños
            .forEach {
            //    println("valores" + it) //la variable It que ofrece el ide es iterada
            }

    val respuestaArregloFE= arregloCumpleaños
            .forEach{valorIteracion:Int->   //ejemplo no sirve
             //           println("valor iteracion "+ valorIteracion)
             //           println("valor con -1 = ${valorIteracion * - 1}")
                    }
    println(respuestaArregloFE)
    arregloCumpleaños
            .forEach(
                    {valorIteracion:Int->
                    //    println("valor iteracion "+ valorIteracion)
                    }
            )
    arregloCumpleaños
            .forEachIndexed { index:Int, i:Int ->
           //     println("valor de iteracion"+ index)
            }

    val respuestaMap = arregloCumpleaños
            .map { ietracion1 : Int->
                ietracion1*-1
            }
    //println(respuestaMap)
    //println(arregloCumpleaños)


    val respuestaMapDos = arregloCumpleaños
            .map { ietracion1 : Int->
                val nuevoValor = ietracion1*-1
                val otroValor = ietracion1*2
                return@map otroValor.toString()
            }
    //println(respuestaMap)
    //println(respuestaMapDos)
    //println(arregloCumpleaños)

    val respuestaFilter=arregloCumpleaños
            .filter { iteracion : Int->
                val esMayor23 = iteracion >25
                return@filter esMayor23
            }

    arregloCumpleaños
            .filter { iteracion : Int->
                iteracion > 23
            }

    println(arregloCumpleaños)
    println(respuestaFilter)

}



// funcion devolviendo valor

fun calcularSueldo(
        sueldo: Double,//requerido
        tasa:Double =12.00, //valores por defecto!!
        
        //calculoEspecial:Int?//pueden ser nulo
        calculoEspecial:Int?=null//pueden ser nulo y no necesito enviarlo puedo obviarlo!
): Double{
    if (calculoEspecial!=null){
        return sueldo*tasa*calculoEspecial;//;opcionles
    }else{
        return sueldo*tasa
    }

}

fun calcularSueldoEsp(
        sueldo: Double,//requerido
        tasa:Double =12.00, //valores por defecto!!

        //calculoEspecial:Int?//pueden ser nulo
        calculoEspecial:Int?=null//pueden ser nulo y no necesito enviarlo puedo obviarlo!
): Double?{ //--->puedo retornar o no
    if (calculoEspecial!=null){
        return sueldo*tasa*calculoEspecial;//;opcionles
    }else{
        return sueldo*tasa
    }

}






