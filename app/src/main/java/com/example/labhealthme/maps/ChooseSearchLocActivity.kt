package com.example.labhealthme.maps

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labhealthme.databinding.ActivityChooseSearchLocBinding
import com.example.labhealthme.doctor.DoctorActivity
import com.example.labhealthme.hospital.Hospital
import com.example.labhealthme.hospital.HospitalVerticalAdapter
import com.example.labhealthme.hospital.HospitalsData

class ChooseSearchLocActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChooseSearchLocBinding
    private var listHospital: ArrayList<Hospital> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseSearchLocBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvHospitalsVertical.setHasFixedSize(true)
        listHospital.addAll(HospitalsData.listData)
        showRecyclerList()
    }

    private fun moveToDoctor(idxListDoctor: Int) {
        val moveIntent = Intent(this, DoctorActivity::class.java)
        moveIntent.putExtra(
            DoctorActivity.EXTRA_IDX_DOCTOR,
            idxListDoctor
        )
        startActivity(moveIntent)
    }

    private fun showRecyclerList() {
        val listHospitalVerticalAdapter = HospitalVerticalAdapter(listHospital)
        binding.rvHospitalsVertical.apply {
            layoutManager = LinearLayoutManager(this@ChooseSearchLocActivity)
            adapter = listHospitalVerticalAdapter
        }

        listHospitalVerticalAdapter.setOnItemClickCallback(object :
            HospitalVerticalAdapter.OnItemClickCallback {
            override fun onItemClicked(item: Hospital, position: Int) {
                moveToDoctor(position)
            }
        })
    }
}
