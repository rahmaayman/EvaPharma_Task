
package com.example.sample.ui.employee
import androidx.lifecycle.ViewModelProvider
import com.evaph.core.base.BaseActivity
import com.example.sample.databinding.ActivityEmployeeListBinding
import com.example.sample.ui.adapter.EmployeeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EmployeeListActivity : BaseActivity<ActivityEmployeeListBinding, EmployeeViewModel>() {
    override fun initBinding(): ActivityEmployeeListBinding {
        return ActivityEmployeeListBinding.inflate(layoutInflater)
    }

    override fun initViewModel() {
        viewModel = ViewModelProvider(this)[EmployeeViewModel::class.java]
    }

    override fun onActivityCreated() {
        binding.btnCallApi.setOnClickListener {
            showLoading()
            viewModel.getEmployee().observe(this, {
                binding.rvEmployee.adapter = EmployeeAdapter(it.data)
                hideLoading()
            }
            )
        }
    }


}


