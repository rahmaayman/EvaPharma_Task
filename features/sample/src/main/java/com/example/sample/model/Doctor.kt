package com.example.sample.model

import com.google.gson.annotations.SerializedName

data class Doctor(
    @SerializedName("id") val id : Int,
    @SerializedName("doctor_name") val doctor_name : String,
    @SerializedName("specialist") val specialist : String,
    @SerializedName("img") val img : String,
    @SerializedName("fees") val fees : Int,
    @SerializedName("followup") val followup : Int,
    @SerializedName("accept_promocode") val accept_promocode : Boolean,
    @SerializedName("available_from") val available_from : String
)