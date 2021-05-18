package com.example.sample.ui.employee

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.evaph.core.base.BaseViewModel
import com.example.sample.model.Employee
import com.example.sample.model.response.EmployeeResponse
import com.example.sample.repo.EmployeeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EmployeeViewModel @Inject constructor(private val employeeRepo: EmployeeRepo) :
    BaseViewModel() {

    fun getEmployee(): LiveData<EmployeeResponse> {
        val mutableLiveData = MutableLiveData<EmployeeResponse>()
        viewModelScope.launchCatching(
            block = {
                val response = employeeRepo.getEmployees()
                mutableLiveData.value = response
            }, onError = ::handleError
        )
        return mutableLiveData;
    }

    fun createEmployee(name: String, salary: String, age: String): LiveData<Employee> {
        val mutableLiveData = MutableLiveData<Employee>()
        viewModelScope.launchCatching(
            block = {
                val response = employeeRepo.createEmployee(
                    hashMapOf(
                        "name" to name,
                        "salary" to salary,
                        "age" to age,
                    )
                )
                mutableLiveData.value = response
            }, onError = ::handleError
        )
        return mutableLiveData
    }

}