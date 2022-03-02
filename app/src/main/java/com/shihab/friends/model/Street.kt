package com.shihab.friends.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Street(

	@field:SerializedName("number")
	val number: Int? = null,

	@field:SerializedName("name")
	val name: String? = null
) : Parcelable