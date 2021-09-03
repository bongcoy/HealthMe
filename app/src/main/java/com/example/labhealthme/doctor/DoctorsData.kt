package com.example.labhealthme.doctor

import android.util.Log
import com.example.labhealthme.R

object DoctorsData {
    private val doctorPhotos = arrayOf(
        R.drawable.photo_doctordummy1,
        R.drawable.photo_doctordummy1,
        R.drawable.photo_doctordummy1,
        R.drawable.photo_doctordummy1,
        R.drawable.photo_doctordummy1,
        R.drawable.photo_doctordummy1,
        R.drawable.photo_doctordummy1,
        R.drawable.photo_doctordummy1,
        R.drawable.photo_doctordummy1,
        R.drawable.photo_doctordummy1
    )

    private val doctorNames = arrayOf(
        "dr. Nila Indria Utami",
        "dr. Siska Desy Sofyana",
        "dr. Muhammad Fadillah",
        "dr. Ajeng Savitri",
        "dr. Oktaviana Rinduan",
        "Dokter Henry Santosa Sungkono",
        "Dokter I Gusti Ayu Rai Astarini",
        "Dokter I Gede Jayantika",
        "Dr. Heryanto",
        "Dr. Ketut Mendra"
    )

    val listData: List<Doctor>
        get() {
            val listDoc = arrayListOf<Doctor>()
            for (position in doctorNames.indices) {
                val doctor = Doctor()
                doctor.photo = doctorPhotos[position]
                doctor.name = doctorNames[position]
                listDoc.add(doctor)
                Log.d("CHAAKSS DoctorsData","${listDoc}")
            }
            Log.d("CHAAKSS DoctorsData","${listDoc.size}")
            return listDoc.toList()
        }
}