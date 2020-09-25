package com.example.examen_1b_univ_alien

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class AlienHttp (
    val createdAt : Long,
    val updatedAt: Long,
    val id: Int,
    val razaAlien : String?,
    val alturaAlien: Double,
    val pesoAlien: Double,
    val edadAlien: Int,
    val ostilidadAlien: Boolean,
    val nombreUniverso : String?,
    val latitud : String?,
    val longitud : String?,
    val url : String?


    ):Parcelable{

    var fechaCreacion : Date
    var fechaActualizacion : Date

    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readLong(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {

    }

    init {
        fechaCreacion= Date(createdAt)
        fechaActualizacion= Date(updatedAt)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(createdAt)
        parcel.writeLong(updatedAt)
        parcel.writeInt(id)
        parcel.writeString(razaAlien)
        parcel.writeDouble(alturaAlien)
        parcel.writeDouble(pesoAlien)
        parcel.writeInt(edadAlien)
        parcel.writeByte(if (ostilidadAlien) 1 else 0)
        parcel.writeString(nombreUniverso)
        parcel.writeString(latitud)
        parcel.writeString(longitud)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AlienHttp> {
        override fun createFromParcel(parcel: Parcel): AlienHttp {
            return AlienHttp(parcel)
        }

        override fun newArray(size: Int): Array<AlienHttp?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString ():String{
        return "${razaAlien}, ${alturaAlien}, ${pesoAlien}, ${edadAlien}, ${ostilidadAlien}, ${nombreUniverso}"
    }
}