package com.example.sample.model.response

import com.example.sample.model.Employee
import com.google.gson.annotations.SerializedName

data class EmployeeResponse(
    @SerializedName("data") val data: List<Employee>
    )
