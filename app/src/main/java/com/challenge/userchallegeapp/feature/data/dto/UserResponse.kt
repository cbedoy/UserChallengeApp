package com.challenge.userchallegeapp.feature.data.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class UserResponse(
    val id: Int? = null,
    val name: String? = null,
    val username: String? = null,
    val email: String? = null,
) : Parcelable