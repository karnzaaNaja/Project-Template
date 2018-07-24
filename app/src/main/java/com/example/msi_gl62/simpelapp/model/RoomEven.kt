package com.example.msi_gl62.simpelapp.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class RoomEven(var detail: String? = null,
    var image: String? = null,
    var join: String? = null,
    var lat: Double? = null,
    var lon: Double? = null,
    var name: String? = null,
    var tail: String? = null,
    var tell: String? = null,
    var time: String? = null) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readValue(Double::class.java.classLoader) as Double?,
        source.readValue(Double::class.java.classLoader) as Double?,
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(detail)
        writeString(image)
        writeString(join)
        writeValue(lat)
        writeValue(lon)
        writeString(name)
        writeString(tail)
        writeString(tell)
        writeString(time)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<RoomEven> = object : Parcelable.Creator<RoomEven> {
            override fun createFromParcel(source: Parcel): RoomEven = RoomEven(source)
            override fun newArray(size: Int): Array<RoomEven?> = arrayOfNulls(size)
        }
    }
}
data class ListRoomEven(@SerializedName("data") var results: List<RoomEven>? = null)