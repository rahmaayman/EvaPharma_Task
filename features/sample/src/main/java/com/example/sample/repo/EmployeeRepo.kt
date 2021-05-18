package com.example.sample.repo

import com.evaph.core.base.BaseRepo
import com.example.sample.model.Employee
import com.example.sample.model.response.EmployeeResponse
import com.example.sample.network.Endpoints
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class EmployeeRepo @Inject constructor() : BaseRepo() {

    suspend fun getEmployees() = withContext(Dispatchers.IO){
        networkManager.getRequest(
            api = Endpoints.EMPLOYEE,
            parseClass = EmployeeResponse::class.java
        )
    }

    suspend fun createEmployee(param :Map<String, Any>)= withContext(Dispatchers.IO){
        networkManager.postRequest(
            api= Endpoints.CREATE_EMPLOYEE,
            body = param,
            parseClass = Employee::class.java
        )
    }

}