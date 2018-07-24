package com.example.msi_gl62.simpelapp.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class TestModel(var userId: String? = null) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(userId)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<TestModel> = object : Parcelable.Creator<TestModel> {
            override fun createFromParcel(source: Parcel): TestModel = TestModel(source)
            override fun newArray(size: Int): Array<TestModel?> = arrayOfNulls(size)
        }
    }
}

data class ListTestModel(@SerializedName("userId") var results2: List<TestModel>? = null)

