package com.example.labhealthme.maps.hospital

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.labhealthme.databinding.ItemHospitalBinding

class HospitalAdapter(private val listHospital: ArrayList<Hospital>) :
    RecyclerView.Adapter<HospitalAdapter.CardViewViewHolder>() {

    inner class CardViewViewHolder(binding: ItemHospitalBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val binding =
            ItemHospitalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = listHospital.size

}