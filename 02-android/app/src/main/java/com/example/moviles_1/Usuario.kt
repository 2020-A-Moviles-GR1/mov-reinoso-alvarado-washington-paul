package com.example.moviles_1

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class Usuario (
    var nombre: String?,
    var edad :Int,
    var fechaDeNacimiento : Date,
    var sueldo :Double
):Parcelable{
    //Deserializa (lee)
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readSerializable() as Date,
        parcel.readDouble()
    ) {
    }
    //Seriliza(Escribe)
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeInt(edad)
        parcel.writeSerializable(fechaDeNacimiento)
        parcel.writeDouble(sueldo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Usuario> {
        override fun createFromParcel(parcel: Parcel): Usuario {
            return Usuario(parcel)
        }

        override fun newArray(size: Int): Array<Usuario?> {
            return arrayOfNulls(size)
        }
    }


}