package com.example.sample.ui.employee

import androidx.lifecycle.ViewModelProvider
import com.evaph.core.base.BaseActivity
import com.example.sample.databinding.ActivityNewEmployeeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewEmployeeActivity : BaseActivity<ActivityNewEmployeeBinding, EmployeeViewModel>() {
    override fun initBinding(): ActivityNewEmployeeBinding {
        return ActivityNewEmployeeBinding.inflate(layoutInflater)
    }

    override fun initViewModel() {
        viewModel = ViewModelProvider(this)[EmployeeViewModel::class.java]
    }

    override fun onActivityCreated() {
        binding.btnSubmit.setOnClickListener {
            if (validate()) {
                showLoading()
                viewModel.createEmployee(
                    binding.etName.text.toString(),
                    binding.etSalary.text.toString(),
                    binding.etAge.text.toString()
                ).observe(this,{
                    hideLoading()
                    showSuccessMsg("Employee created")
                    finish()
                })
            }
        }
    }

    fun validate(): Boolean {
        if (binding.etName.text!!.isEmpty() || binding.etAge.text!!.isEmpty() || binding.etSalary.text!!.isEmpty()) {
            showErrorMsg("please fill all data")
            return false
        }
        return true
    }
}