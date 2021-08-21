package com.example.labhealthme

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id : String?,
    val nama : String,
    val email : String
) : Parcelable
