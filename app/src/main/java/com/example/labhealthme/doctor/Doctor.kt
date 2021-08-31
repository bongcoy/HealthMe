package com.example.labhealthme.doctor

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Doctor(
    var photo: Int = 0,
    var name: String = ""
) : Parcelable
