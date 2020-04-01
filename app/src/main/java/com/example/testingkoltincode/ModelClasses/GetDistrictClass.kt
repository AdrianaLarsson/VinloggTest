package com.example.testingkoltincode.ModelClasses


import com.google.gson.annotations.SerializedName


data class GetDistrictClass(

	@field:SerializedName("districtId")
	val districtId: Long? = null,

	@field:SerializedName("districtName")
	val districtName: String? = null,

	@field:SerializedName("regionId")
	val regionId: Long? = null
)