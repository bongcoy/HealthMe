package com.example.labhealthme.hospital

import android.util.Log
import com.example.labhealthme.R
import com.example.labhealthme.doctor.Doctor
import com.example.labhealthme.doctor.DoctorsData

object HospitalsData {
    private val photos = intArrayOf(
        R.drawable.photo_hospitaldummy1,
        R.drawable.photo_hospitaldummy1,
        R.drawable.photo_hospitaldummy1,
        R.drawable.photo_hospitaldummy1,
        R.drawable.photo_hospitaldummy1,
        R.drawable.photo_hospitaldummy1,
        R.drawable.photo_hospitaldummy1,
        R.drawable.photo_hospitaldummy1,
        R.drawable.photo_hospitaldummy1,
        R.drawable.photo_hospitaldummy1
    )

    private val names = arrayOf(
        "Siloam Hospitals Mataram",
        "RSUD Provinsi NTB",
        "Harapan Keluarga Hospital",
        "RSUD Praya",
        "Biomedika Hospital",
        "Siti Hajar Islamic Hospital",
        "Rumah Sakit Risa Sentra Medika Lombok Timur",
        "RSUD Dr. R. Soedjono Selong",
        "Patut Patuh Patju Hospital",
        "Rumah Sakit Metro Medika Lombok"
    )

    private val distances = intArrayOf(
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10
    )

    private val status = arrayOf(
        "tidak penuh",
        "penuh",
        "penuh",
        "tidak penuh",
        "tidak penuh",
        "penuh",
        "tidak penuh",
        "penuh",
        "penuh",
        "tidak penuh"
    )

    private var listDoctors: Array<List<Doctor>> = arrayOf(
        DoctorsData.listData.slice(0..5),
        DoctorsData.listData.slice(6..9),
        DoctorsData.listData.slice(1..3),
        DoctorsData.listData.slice(4..6),
        DoctorsData.listData.slice(2..5),
        DoctorsData.listData.slice(3..8),
        DoctorsData.listData.slice(0..7),
        DoctorsData.listData.slice(0..3),
        DoctorsData.listData.slice(0..2),
        DoctorsData.listData.slice(0..1)
    )

    val listData: ArrayList<Hospital>
        get() {
            val arrList = arrayListOf<Hospital>()
            for (position in names.indices) {
                val hospital = Hospital()
                hospital.photo = photos[position]
                hospital.name = names[position]
                hospital.distance = distances[position]
                hospital.waitingStatus = status[position]
                Log.d("CHAAKSS HospsDocData", "${DoctorsData.listData.slice(0..5)}")
                hospital.doctors = listDoctors[position]
                arrList.add(hospital)
            }
            return arrList
        }
}