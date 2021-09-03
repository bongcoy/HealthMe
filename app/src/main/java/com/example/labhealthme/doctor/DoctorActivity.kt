package com.example.labhealthme.doctor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labhealthme.databinding.ActivityDoctorBinding
import com.example.labhealthme.hospital.HospitalsData

class DoctorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDoctorBinding
    private var listDoctor: ArrayList<Doctor> = arrayListOf()
    private var actTitle: String = "Pilih Dokter"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setActionBarTitle(actTitle)

        val hospitalName = intent.getStringExtra(EXTRA_TITLE)
        val idxDoctor =
            intent.getIntExtra(EXTRA_IDX_DOCTOR, 0)

        binding.tvHospitalName.text = hospitalName.toString()

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

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    companion object {
        const val EXTRA_IDX_DOCTOR = "extra_idx_doctor"
        const val EXTRA_TITLE = "extra_title"
    }
}