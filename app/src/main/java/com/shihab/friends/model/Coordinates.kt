package com.shihab.friends.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Coordinates(

	@field:SerializedName("latitude")
	val latitude: String? = null,

	@field:SerializedName("longitude")
	val longitude: String? = null
) : Parcelable