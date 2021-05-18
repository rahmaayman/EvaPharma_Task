package com.example.sample.ui

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.evaph.core.base.AnyViewModel
import com.evaph.core.base.BaseActivity
import com.example.sample.R
import com.example.sample.databinding.ActivityMainBinding
import com.example.sample.ui.doctors.DoctorsListActivity
import com.example.sample.ui.home.HomeActivity

class MainActivity : BaseActivity<ActivityMainBinding, AnyViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun initBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initViewModel() {
        viewModel = ViewModelProvider(this)[AnyViewModel::class.java]

    }

    override fun onActivityCreated() {
        // TODO Navigate to your code from here
        startActivity(Intent(this, DoctorsListActivity::class.java))
    }
}