package com.example.labhealthme.hospital

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.labhealthme.databinding.ItemHospitalHorizontalBinding

class HospitalHorizontalAdapter(private val listHospital: ArrayList<Hospital>) :
    RecyclerView.Adapter<HospitalHorizontalAdapter.CardViewViewHolder>() {
    private lateinit var binding: ItemHospitalHorizontalBinding
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(item: Hospital)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class CardViewViewHolder(binding: ItemHospitalHorizontalBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        binding =
            ItemHospitalHorizontalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
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
            Toast.makeText(
                holder.itemView.context,
                listHospital[holder.adapterPosition].name + " terpilih",
                Toast.LENGTH_SHORT
            ).show()
            onItemClickCallback.onItemClicked(listHospital[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listHospital.size
}