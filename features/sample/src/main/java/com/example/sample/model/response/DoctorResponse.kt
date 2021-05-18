package com.example.sample.model.response

import com.example.sample.model.DoctorData
import com.google.gson.annotations.SerializedName

data class DoctorResponse (
    @SerializedName("Message") val message : String,
    @SerializedName("ErrorList") val errorList : List<String>,
    @SerializedName("Data") val doctorData : DoctorData
)