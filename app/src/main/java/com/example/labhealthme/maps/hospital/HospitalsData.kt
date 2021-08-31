package com.example.labhealthme.maps.hospital

import com.example.labhealthme.R
import com.example.labhealthme.maps.doctor.Doctor

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
        "tidak penuh",
        "tidak penuh"
    )

    private var listDoctors: Array<ArrayList<Doctor>> = arrayOf(
        //TODO: Harus cepet selesai !!!
    )

    val listData: ArrayList<Hospital>
        get() {
            val arrList = arrayListOf<Hospital>()
            for (position in HospitalsData.names.indices) {
                val hospital = Hospital()
                hospital.photo = HospitalsData.photos[position]
                hospital.name = HospitalsData.names[position]
                hospital.distance = HospitalsData.distances[position]
                hospital.waitingStatus = HospitalsData.status[position]
//                hospital.doctors = HospitalsData.listDoctors[position]
                arrList.add(hospital)
            }
            return arrList
        }
}