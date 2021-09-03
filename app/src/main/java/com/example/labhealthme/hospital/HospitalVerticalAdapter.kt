package com.example.labhealthme.hospital

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.labhealthme.databinding.ItemHospitalVerticalBinding

class HospitalVerticalAdapter(private val listHospital: MutableList<Hospital>) :
    RecyclerView.Adapter<HospitalVerticalAdapter.ListViewViewHolder>() {
    private lateinit var binding: ItemHospitalVerticalBinding
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(item: Hospital, position: Int)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewViewHolder(binding: ItemHospitalVerticalBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewViewHolder {
        binding =
            ItemHospitalVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewViewHolder, position: Int) {
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
            Toast.makeText(
                holder.itemView.context,
                listHospital[holder.adapterPosition].name + " terpilih",
                Toast.LENGTH_SHORT
            ).show()
            onItemClickCallback.onItemClicked(listHospital[holder.adapterPosition],holder.adapterPosition)
        }
    }

    override fun getItemCount(): Int = listHospital.size

}