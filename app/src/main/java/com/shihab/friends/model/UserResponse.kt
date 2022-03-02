package com.shihab.friends.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserResponse(

	@field:SerializedName("results")
	val results: List<User>? = null,

	@field:SerializedName("info")
	val info: Info? = null
) : Parcelable