package com.example.sample.ui.home

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import com.evaph.core.base.AnyViewModel
import com.evaph.core.base.BaseActivity
import com.example.sample.databinding.ActivityHomeBinding
import com.example.sample.ui.employee.EmployeeListActivity
import com.example.sample.ui.employee.NewEmployeeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding, AnyViewModel>() {
    override fun initBinding(): ActivityHomeBinding {
        return ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun initViewModel() {
        viewModel = ViewModelProvider(this)[AnyViewModel::class.java]
    }

    override fun onActivityCreated() {
        binding.btnAddEmployee.setOnClickListener {
            startActivity(Intent(this, NewEmployeeActivity::class.java))
        }
        binding.btnGetEmployee.setOnClickListener {
            startActivity(Intent(this, EmployeeListActivity::class.java))
        }

    }
}