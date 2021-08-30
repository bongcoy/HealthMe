package com.example.labhealthme.maps.doctor

object DoctorsData {
    private val doctorPhotos = arrayOf(
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
                //TODO: Bikin array 2D
                val doctor = Doctor()
                doctor.photo = doctorPhotos[position]
                doctor.name = doctorNames[position]
                arrList.add(doctor)
            }
            return arrList
        }
}