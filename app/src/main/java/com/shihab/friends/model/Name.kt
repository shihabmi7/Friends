package com.shihab.friends.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Name(

	@field:SerializedName("last")
	val last: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("first")
	val first: String? = null
) : Parcelable