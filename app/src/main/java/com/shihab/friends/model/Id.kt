package com.shihab.friends.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Id(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("value")
	val value: String? = null
) : Parcelable