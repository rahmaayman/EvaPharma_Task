package com.example.sample.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sample.databinding.ItemDoctorBinding
import com.example.sample.databinding.ItemEmployeeBinding
import com.example.sample.model.Doctor
import com.example.sample.model.Employee

class DoctorsAdapter (var list: List<Doctor>) :
    RecyclerView.Adapter<DoctorsAdapter.DoctorsViewHolder>() {

    inner class DoctorsViewHolder(private val binding: ItemDoctorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Doctor) {
            binding.doctorName.text = item.doctor_name
            binding.doctorSpecialist.text = item.specialist
            binding.fees.text = item.fees.toString() + "EGP"
            binding.followUp.text = item.followup.toString()+ "EGP"
            binding.avaliableTime.text = item.available_from.split("from ").get(1)
            if (item.accept_promocode){
                binding.acceptTxt.text = "Accept"
            }else{
                binding.acceptTxt.text = "Not Accept"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorsViewHolder {
        return DoctorsViewHolder(
            ItemDoctorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DoctorsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}