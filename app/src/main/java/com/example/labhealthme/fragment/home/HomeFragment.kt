package com.example.labhealthme.fragment.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.labhealthme.databinding.FragmentHomeBinding
import com.example.labhealthme.diagnose.DiagnoseActivity
import com.example.labhealthme.maps.MapsActivity

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.apply {
            cvHomeHospital.setOnClickListener {
                val intent = Intent(activity, MapsActivity::class.java)
                activity?.startActivity(intent)
            }
            cvHomeDiagnose.setOnClickListener {
                val intent = Intent(activity, DiagnoseActivity::class.java)
                activity?.startActivity(intent)
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}