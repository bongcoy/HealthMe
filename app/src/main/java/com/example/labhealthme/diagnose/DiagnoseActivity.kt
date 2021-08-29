package com.example.labhealthme.diagnose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import com.example.labhealthme.R
import com.example.labhealthme.databinding.ActivityDiagnoseBinding

class DiagnoseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDiagnoseBinding
    private val TAG = "DIAGNOSE ACT"
    private var rawGejala = "Null"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiagnoseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCekGejala.setOnClickListener {
            rawGejala = binding.etGejala.text.toString()
            Log.d(TAG,rawGejala)
        }
    }
}