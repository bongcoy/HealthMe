package com.example.labhealthme.doctor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.labhealthme.R
import com.example.labhealthme.databinding.ActivityDoctorBinding

class DoctorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDoctorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}