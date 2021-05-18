package com.example.sample.ui.doctors

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.evaph.core.base.BaseActivity
import com.example.sample.databinding.ActivityDoctorsListBinding
import com.example.sample.ui.adapter.DoctorsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DoctorsListActivity : BaseActivity<ActivityDoctorsListBinding,DoctorsViewModel>() {
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctors_list)
    }*/
    lateinit var doctorsAdapter:DoctorsAdapter

    override fun initBinding(): ActivityDoctorsListBinding {
        return ActivityDoctorsListBinding.inflate(layoutInflater)
    }

    override fun initViewModel() {
        viewModel = ViewModelProvider(this)[DoctorsViewModel::class.java]
    }

    override fun onActivityCreated() {
       doctorsAdapter = DoctorsAdapter(listOf())
        binding.rvDoctors.apply {
            adapter=doctorsAdapter
        }
        showLoading()
        viewModel.getDoctors().observe(this,{
            doctorsAdapter.list = it.doctorData.doctor
            doctorsAdapter.notifyDataSetChanged()
            hideLoading()
        })

        }
}