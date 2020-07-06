import java.io.File
import java.nio.file.Files.write
import java.nio.file.StandardOpenOption
import java.io.BufferedReader

fun main ( args:Array<String> ){
    //var menu=Menu()
    //menu.opcionesMenu()
    var menu1=MenuAlien()
    menu1.opcionesMenu()
}










/*
fun escribirElArchivoWrite(){
    //--> write
    //val outString = "Kotlin Doc\nEscribiendo un archivo con bufferedWriter.\n"
    val outString = ""
    File("archivos\\universo").bufferedWriter().use { out -> out.write(outString) }
}
*/
/*
fun escribeArchivoAppend(){
    //--> append
    val outString = "Kotlin Doc numero 2\nEscribiendo un archivo con writeText II esta\nvez ><\n"
    val archivo = File("archivos\\universo")
    write(archivo.toPath(), outString.toByteArray(), StandardOpenOption.APPEND)
}
*/
class Main {
    //val controlU=ControlUniverso()
    //val controAlien=ControlAlien()
    //controlU.creacionUniversos("universo-AB-62",89700,1225.19F,40.0,false)
    //controlU.creacionUniversos("universo-M-82",4500,2325.19F,50.5,true)
    //controlU.creacionUniversos("universo-M-81",1500,2325.19F,50.5,true)
    //val res=controlU.buscarUniverso("universo-AB-62")
    //println(res)
    //controlU.modificrUniverso("min Temperatura:9800.4","universo-AB-62")
    //controlU.eliminarUniverso("universo-M-82")

    //controAlien.creacionAliens("Cerberus",3.23F,44.2,22,true,"universo-Z-88")
    //controAlien.creacionAliens("Licano",3.66F,44.2,22,false,"universo-M-82")
    //controAlien.creacionAliens("Lisovik",2.45F,44.2,22,true,"universo-M-82")
    //val alien=controAlien.buscarAlien("Licano")
    //println(alien)
    //controAlien.modificrAlien("ostilidad:true","Lisovik")
    //controAlien.eliminarAlien("Lisovik")
}