package com.example.labhealthme.maps.hospital

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.labhealthme.databinding.ItemHospitalBinding
import com.example.labhealthme.doctor.DoctorActivity

class HospitalAdapter(private val listHospital: ArrayList<Hospital>) :
    RecyclerView.Adapter<HospitalAdapter.CardViewViewHolder>() {
    private lateinit var binding: ItemHospitalBinding

    inner class CardViewViewHolder(binding: ItemHospitalBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        binding =
            ItemHospitalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val hospital = listHospital[position]
        Glide.with(holder.itemView.context)
            .load(hospital.photo)
            .into(binding.ivHospital)
        binding.apply {
            tvHospitalName.text = hospital.name
            "${hospital.distance.toString()}km".also { tvHospitalDistance.text = it }
            tvStatusAntrean.text = hospital.waitingStatus
        }
        holder.itemView.setOnClickListener {
            //TODO: Move to DoctorAct
            val moveIntent = Intent()
        }
    }

    override fun getItemCount(): Int = listHospital.size

}