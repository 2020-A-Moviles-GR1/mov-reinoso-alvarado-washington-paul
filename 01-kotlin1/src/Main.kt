import java.security.PrivateKey
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
fun imprimirMensaje1() { //unit = void
    calcularSueldo(1000.00, 14.40, calculoEspecial = null)
    calcularSueldo(tasa = 10.00, sueldo = 120.00, calculoEspecial = null)
    calcularSueldo(
            16.00,
            14.00,
            null
    )
    calcularSueldo(sueldo = 12.00)
    val arregloConstante: Array<Int> = arrayOf(1, 2, 3)  //no se puede añadir elementos
    val arregloCumpleaños: ArrayList<Int> = arrayListOf(17, 18, 30, 31, 32, 33, 20)  //se puede añadir y eliminar elementos
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

    val respuestaArregloFE = arregloCumpleaños
            .forEach { valorIteracion: Int ->   //ejemplo no sirve
                //           println("valor iteracion "+ valorIteracion)
                //           println("valor con -1 = ${valorIteracion * - 1}")
            }
    println(respuestaArregloFE)
    arregloCumpleaños
            .forEach(
                    { valorIteracion: Int ->
                        //    println("valor iteracion "+ valorIteracion)
                    }
            )
    arregloCumpleaños
            .forEachIndexed { index: Int, i: Int ->
                //     println("valor de iteracion"+ index)
            }

    val respuestaMap = arregloCumpleaños
            .map { ietracion1: Int ->
                ietracion1 * -1
            }
    //println(respuestaMap)
    //println(arregloCumpleaños)


    val respuestaMapDos = arregloCumpleaños
            .map { ietracion1: Int ->
                val nuevoValor = ietracion1 * -1
                val otroValor = ietracion1 * 2
                return@map otroValor.toString()
            }
    //println(respuestaMap)
    //println(respuestaMapDos)
    //println(arregloCumpleaños)

    val respuestaFilter = arregloCumpleaños
            .filter { iteracion: Int ->
                val esMayor23 = iteracion > 25
                return@filter esMayor23
            }

    arregloCumpleaños
            .filter { iteracion: Int ->
                iteracion > 23
            }

    //println(arregloCumpleaños)
    //println(respuestaFilter)

    val respuestaFilterMayordeedad = arregloCumpleaños
            .filter { iteracion: Int ->
                val esMayor23 = iteracion < 18
                return@filter esMayor23 //arregglo que cumple la condicion
            }

    println(respuestaFilterMayordeedad)
    //operador que encuentra al menos una ocurrencia
    // ANY-> OR
    // ALL-> AND
    // AND-TUE todo lo demas falos
    // OR todo es falso lo demas era verdadero
    // 1)devolver un expreson (true/false)
    // 2)devuelve un booleamo

    val requestAny: Boolean = arregloCumpleaños.any { iterador: Int ->
        return@any iterador < 18
    }
    println(requestAny)

    val requestAll: Boolean = arregloCumpleaños.all { iterador: Int ->
        return@all iterador > 15
    }
    println(requestAll)

    // Operacion no solo sumas y restas sino aplicar formulas
    // Reduce
    //1) devuelve el acumulado
    //2) debemos decirle en que valor empezar
    //Existen
    //arregloCumpleaños.reduceRight
    //arregloCumpleaños.FoldRight

    val respuestaReduce = arregloCumpleaños //acumulador es un auxiliar=0
            .reduce { acumulador, iterador ->
                return@reduce (acumulador + iterador) / arregloCumpleaños.size
            }
    println(respuestaReduce)

// Podemos simepre poner los parentesis antes de las llaves,
// pero si usamos un mas de un parametro usamos los parentecis

    val respuestaFold = arregloCumpleaños //acumulador es un auxiliar=100
            .fold( //le digo donde empezar
                    100,{ acumulador, iterador ->
                return@fold acumulador - iterador
            }
            )
    println(respuestaFold)

    // forEach -> nada
    // map -> Arreglo
    // filter -> Arreglo
    // all -> Booleano
    // any -> Booleano
    // reduce -> valor
    // fold -> valor
    

    // simular como bajaria nuestra vida en un juego
    // reducir el daño 20%
    // no hce daño >18
    // si el operador retorna lo mismo se puede concatenar
    val juego = arregloCumpleaños
            .map { iterador ->
                iterador*0.8
            }
            .filter { iterador ->
                iterador > 18
            }
            .fold(100.00,{
                acumunlador, iterador ->
                return@fold acumunlador - iterador
            }
            )//.also { println() }
    println(juego)

    val nuevoNumeroUno = SumarDosNumerosDos(1,1)
    val nuevoNumeroDos = SumarDosNumerosDos(null,1)
    val nuevoNumeroTre = SumarDosNumerosDos(1,null)
    val nuevoNumeroCuatro = SumarDosNumerosDos(null,null)
    println(SumarDosNumerosDos.arregloNumeros)
    SumarDosNumerosDos.agregarNumero(1)
    println(SumarDosNumerosDos.arregloNumeros)
    SumarDosNumerosDos.eliminarNumero(0)
    println(SumarDosNumerosDos.arregloNumeros)

    val  nombre : String?=null
    imprimirNombre("Paul")

}


fun imprimirNombre(nombre :String?){
    println(nombre?.length)
    println(nombre?.toInt())
    println(nombre?.toDouble())

    val numeroCaracteres: Int ? = nombre?.length
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
// Clases Abstractas

abstract class NumerosJava {  // val nuevosNumeros = Numeros(1,2)
    protected val numeroUno: Int
    protected val numeroDos: Int

    constructor(uno: Int, dos: Int) {
        numeroUno = uno
        numeroDos = dos
    }
}

abstract class Numeros( // val nuevosNumeros = Numeros(1,2)
         var numeroUno: Int,
         var numeroDos: Int
) {
}

class Suma(
        uno: Int,
        dos: Int
) : Numeros(uno, dos) {//herencia
    fun sumar():Int{
        // this.uno
        return this.numeroUno + this.numeroDos
    }
}

class SumaDos(
        public var uno: Int,
        public var dos: Int
) : Numeros(uno, dos) {
    fun sumar():Int{
        this.uno
        this.dos
        return this.numeroUno + this.numeroDos
    }
}


//Si quremos mas de un costructor!! NO deben ser excatamente iguales o nos dran errores
// Para esto cambiamos los parametros que queremos ?
class SumarDosNumerosDos(
        uno: Int,
        dos: Int
) : Numeros(uno, dos) {
    init { //SEMPRE QUE SE EJECUTA UN COSTRUCTOR EJECUTA PRIMERO EL INIT
        println("Hola INIT")
    }

    constructor(uno: Int?, dos: Int) : this(
            if (uno == null) 0 else uno,
            dos
    ) { //aqui despues de recibir los parametros ya podemos escribir nuestro codigo
        println("Hola 1")
    }

    constructor(uno: Int, dos: Int?) : this(
            uno,
            if (dos == null) 0 else dos
    ) {
        println("Hola 2")
    }

    constructor(uno: Int?, dos: Int?) : this(
            if (uno == null) 0 else uno,
            if (dos == null) 0 else dos
    ) {
        println("Hola 3")
    }
    companion object {//para toda declaracion estatica
        val arregloNumeros = arrayListOf(1,2,3,4)
        fun agregarNumero(nuevoNumero:Int){
            this.arregloNumeros.add(nuevoNumero)
        }
        fun eliminarNumero(posicionNumero:Int){
            this.arregloNumeros.removeAt(posicionNumero)
        }

    }


}


