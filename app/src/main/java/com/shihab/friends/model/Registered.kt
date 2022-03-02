package com.shihab.friends.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Registered(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("age")
	val age: Int? = null
) : Parcelable