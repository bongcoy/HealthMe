package com.example.labhealthme.diagnose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.labhealthme.R
import com.example.labhealthme.databinding.ActivityDiagnoseBinding

class DiagnoseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDiagnoseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiagnoseBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}