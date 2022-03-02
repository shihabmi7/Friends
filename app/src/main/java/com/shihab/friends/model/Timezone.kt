package com.shihab.friends.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Timezone(

	@field:SerializedName("offset")
	val offset: String? = null,

	@field:SerializedName("description")
	val description: String? = null
) : Parcelable