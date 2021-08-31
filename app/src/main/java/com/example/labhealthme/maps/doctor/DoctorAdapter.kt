package com.example.labhealthme.maps.doctor

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.labhealthme.databinding.ItemDoctorBinding

class DoctorAdapter(private val listDoctor: ArrayList<Doctor>) :
    RecyclerView.Adapter<DoctorAdapter.ListViewViewHolder>() {
    private lateinit var binding: ItemDoctorBinding
    inner class ListViewViewHolder(binding: ItemDoctorBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewViewHolder {
        binding = ItemDoctorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewViewHolder, position: Int) {
        val doctor = listDoctor[position]
        Glide.with(holder.itemView.context)
            .load(doctor.photo)
            .into(binding.ivDoctorPhoto)
        binding.apply {
            tvDoctorName.text = doctor.name
        }
        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                listDoctor[holder.adapterPosition].name + " terpilih",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int = listDoctor.size


}