class Alien(
        var razaAlien:String,
        var alturaAlien:Float,
        var pesoAlien:Double,
        var edadAlien:Int,
        var ostilidadAlien:Boolean,
        var nombreUnivers:String

){

    //funciones de la clase aqui
    override fun toString ():String{
        return "${razaAlien},${alturaAlien},${pesoAlien},${edadAlien},${ostilidadAlien},${nombreUnivers}\n"
    }

}