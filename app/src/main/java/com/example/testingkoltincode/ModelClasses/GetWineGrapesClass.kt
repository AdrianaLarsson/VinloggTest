package com.example.testingkoltincode.ModelClasses


import com.google.gson.annotations.SerializedName


open class GetWineGrapesClass(

	@field:SerializedName("grapeId")
	val grapeId: Long? = null,

	@field:SerializedName("grapeName")
	val grapeName: String? = null,

	@field:SerializedName("percent")
	val percent: Int? = null
)





