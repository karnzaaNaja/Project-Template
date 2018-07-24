package com.example.msi_gl62.simpelapp.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Teacher(var type: String? = null,
    var name: String? = null,
    var image: String? = null,
    var tell: String? = null,
    var ad: String? = null,
    var office_Time: String? = null) : Parcelable {
    constructor(source: Parcel) : this(
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
        writeString(tell)
        writeString(ad)
        writeString(office_Time)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Teacher> = object : Parcelable.Creator<Teacher> {
            override fun createFromParcel(source: Parcel): Teacher = Teacher(source)
            override fun newArray(size: Int): Array<Teacher?> = arrayOfNulls(size)
        }
    }
}

data class ListTeacher(@SerializedName("data") var results: List<Teacher>? = null)