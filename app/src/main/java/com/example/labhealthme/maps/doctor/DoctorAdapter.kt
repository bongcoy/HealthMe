package com.example.labhealthme.maps.doctor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.labhealthme.databinding.ItemDoctorBinding

class DoctorAdapter(private val listDoctor: ArrayList<Doctor>) :
    RecyclerView.Adapter<DoctorAdapter.ListViewViewHolder>() {
    inner class ListViewViewHolder(binding: ItemDoctorBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewViewHolder {
        val binding = ItemDoctorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = listDoctor.size


}