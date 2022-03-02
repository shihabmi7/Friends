package com.shihab.friends.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(

    @field:SerializedName("nat")
    val nat: String? = null,

    @field:SerializedName("gender")
    val gender: String? = null,

    @field:SerializedName("phone")
    val phone: String? = null,

    @field:SerializedName("dob")
    val dob: Dob? = null,

    @field:SerializedName("name")
    val name: Name? = null,

    @field:SerializedName("registered")
    val registered: Registered? = null,

    @field:SerializedName("location")
    val location: Location? = null,

    @field:SerializedName("id")
    val id: Id? = null,

    @field:SerializedName("login")
    val login: Login? = null,

    @field:SerializedName("cell")
    val cell: String? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("picture")
    val picture: Picture? = null,
) : Parcelable {
    fun fullName(): String {
        return if (name != null) {
            name.title + " " + name.first + " " + name.last
        } else
            ""
    }

    fun userDetails(): String {
        var details = ""
        if (location != null) {
            details = location.street?.name + " " + location.state + "\n" +
                    location.country + "\n" + phone
        }
        return details
    }
}