package com.example.examen_1b_univ_alien
import android.os.Parcel
import android.os.Parcelable
import java.util.*

class UniversoHttp (
    val createdAt : Long,
    val updatedAt: Long,
    val id: Int,
    val nombreUniverso : String?,
    val antiguedadUniverso: Int,
    val tamanioUniverso: Double,
    val minTemperatura: Double,
    val universoPrimario: Boolean
):Parcelable{
    var fechaCreacion : Date
    var fechaActualizacion : Date

    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readLong(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readByte() != 0.toByte()
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
        parcel.writeString(nombreUniverso)
        parcel.writeInt(antiguedadUniverso)
        parcel.writeDouble(tamanioUniverso)
        parcel.writeDouble(minTemperatura)
        parcel.writeByte(if (universoPrimario) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UniversoHttp> {
        override fun createFromParcel(parcel: Parcel): UniversoHttp {
            return UniversoHttp(parcel)
        }

        override fun newArray(size: Int): Array<UniversoHttp?> {
            return arrayOfNulls(size)
        }
    }
}
// video para intent con objeto parcelable
//https://web.microsoftstream.com/video/9806b4b8-90b6-4ac2-957b-a0a0b2b37573