import java.util.*

fun main (args:Array<String>  ){
print("hola mundo")
    
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
    val nombreProfesor="Vicente Eguez"
    val sueldo =12.20
    val apellidoProfesor: Char ='a'
    //instanciar clase
    val fechaNacimiento= Date() //new Date()

    if (sueldo==12.20){

    }else{

    }
    when (sueldo){ //es como un swtch
         12.20 -> println("sueldo normal")
        -12.20 -> println("sueldo negtivo")
          else -> println(" no se reconoce el sueldo")

    }

    val esSueldoMayorAlEstablecido = if(sueldo==12.20) true else false //if else rapidamente
    //expresion ? X : Y

}
//FUNCIONES
//ver errores alt+Enter
//si la funcion no devuelve nada no debemos poner nada

    fun imprimirMensaje() : Unit{ //unit = void

    }
fun imprimirMensaje1(){ //unit = void
    calcularSueldo(1000.00,14.40,calculoEspecial = null)
    calcularSueldo(
            16.00,14.00,null
    )
    calcularSueldo(sueldo = 12.00)

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






class Main {
}