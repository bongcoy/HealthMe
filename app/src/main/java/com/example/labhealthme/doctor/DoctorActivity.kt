package com.example.labhealthme.doctor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labhealthme.databinding.ActivityDoctorBinding
import com.example.labhealthme.hospital.Hospital
import com.example.labhealthme.hospital.HospitalVerticalAdapter
import com.example.labhealthme.hospital.HospitalsData

class DoctorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDoctorBinding
    private var listDoctor: ArrayList<Doctor> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val idxDoctor =
            intent.getIntExtra(EXTRA_IDX_DOCTOR,0)

        binding.rvDoctors.setHasFixedSize(true)
        listDoctor.addAll(HospitalsData.listData[idxDoctor].doctors)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        val doctorAdapter = DoctorAdapter(listDoctor)
        binding.rvDoctors.apply {
            layoutManager = LinearLayoutManager(this@DoctorActivity)
            adapter = doctorAdapter
        }
    }

    companion object {
        const val EXTRA_IDX_DOCTOR = "extra_idx_doctor"
    }
}