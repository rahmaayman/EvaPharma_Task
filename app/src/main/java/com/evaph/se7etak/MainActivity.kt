package com.evaph.se7etak

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.evaph.core.base.AnyViewModel
import com.evaph.core.base.BaseActivity
import com.evaph.se7etak.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
        startActivity(Intent("com.example.sample.sample.ui.main.open").setPackage(this.packageName))
        finish()
    }
}

