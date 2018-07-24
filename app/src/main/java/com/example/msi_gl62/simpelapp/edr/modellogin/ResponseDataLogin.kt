package com.example.msi_gl62.simpelapp.edr.modellogin

import com.google.gson.annotations.SerializedName

class ResponseDataLogin(
    @SerializedName("error_msg") val error_msg:String?,
    @SerializedName("status_id") val status_id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("teacher_id") val teacher_id: String?,
    @SerializedName("surname") val surname: String?,
    @SerializedName("term_id") val term_id: String?
    )

