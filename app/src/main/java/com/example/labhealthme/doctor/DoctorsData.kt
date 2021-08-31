package com.example.labhealthme.doctor

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

    val listData: ArrayList<Doctor>
        get() {
            val arrList = arrayListOf<Doctor>()
            for (position in doctorNames.indices) {
                val doctor = Doctor()
                doctor.photo = doctorPhotos[position]
                doctor.name = doctorNames[position]
                arrList.add(doctor)
            }
            return arrList
        }
}