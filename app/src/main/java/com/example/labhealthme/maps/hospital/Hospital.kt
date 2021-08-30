package com.example.labhealthme.maps.hospital

import android.os.Parcelable
import com.example.labhealthme.maps.doctor.Doctor
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hospital(
    var photo: Int = 0,
    var name: String = "",
    var distance: Int = 0,
    var waitingStatus: String = "",
    var doctors: ArrayList<Doctor> = arrayListOf()
) : Parcelable
