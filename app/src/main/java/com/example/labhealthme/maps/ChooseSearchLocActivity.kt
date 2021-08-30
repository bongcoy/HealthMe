package com.example.labhealthme.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.labhealthme.R
import com.example.labhealthme.databinding.ActivityChooseSearchLocBinding

class ChooseSearchLocActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChooseSearchLocBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseSearchLocBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}