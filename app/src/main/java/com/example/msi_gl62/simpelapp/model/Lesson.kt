package com.example.msi_gl62.simpelapp.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Lesson(var type: String? = null,
    var name: String? = null,
    var image: String? = null,
    var price: String? = null,
    var vdo: String? = null,
    var pdf: String? = null,
    var detail: String? = null) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(type)
        writeString(name)
        writeString(image)
        writeString(price)
        writeString(vdo)
        writeString(pdf)
        writeString(detail)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Lesson> = object : Parcelable.Creator<Lesson> {
            override fun createFromParcel(source: Parcel): Lesson = Lesson(source)
            override fun newArray(size: Int): Array<Lesson?> = arrayOfNulls(size)
        }
    }
}

data class ListLesson(@SerializedName("data") var results: List<Lesson>? = null)