package com.example.sample.ui.doctors

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.evaph.core.base.BaseViewModel
import com.example.sample.model.response.DoctorResponse
import com.example.sample.repo.DoctorsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DoctorsViewModel @Inject constructor(private val doctorsRepo: DoctorsRepo) :BaseViewModel() {
    fun getDoctors(): LiveData<DoctorResponse> {
        val mutableLiveData = MutableLiveData<DoctorResponse>()
        viewModelScope.launchCatching(
            block = {
                val response = doctorsRepo.getDoctors()
                mutableLiveData.value = response
                //Log.i("rahma","res"+response.doctor.toString())
            }, onError = ::handleError
        )
        //Log.i("rahma",mutableLiveData.value?.doctor.toString())
        return mutableLiveData;
    }
}