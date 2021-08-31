package com.example.labhealthme.doctor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.labhealthme.databinding.ActivityDoctorBinding

class DoctorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDoctorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listDoctor =
            intent.getParcelableArrayListExtra<Doctor>(EXTRA_LIST_DOCTOR) as ArrayList<Doctor>

    }

    companion object {
        const val EXTRA_LIST_DOCTOR = "extra_list_doctor"
    }
}