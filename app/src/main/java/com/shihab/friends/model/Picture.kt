package com.shihab.friends.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Picture(

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("large")
	val large: String? = null,

	@field:SerializedName("medium")
	val medium: String? = null
) : Parcelable