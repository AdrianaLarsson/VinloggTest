package com.example.testingkoltincode.ModelClasses


import com.google.gson.annotations.SerializedName


open class GetWineClass(

    val wineList: List<GetWineClass>? = null,
    @field:SerializedName("alcohol")
	val alcohol: Double? = null,

    @field:SerializedName("vintages")
	val vintages: List<GetVintagesClass?>? = null,

    @field:SerializedName("wineName")
	val wineName: String? = null,

    @field:SerializedName("district")
	val getDistrictClass: GetDistrictClass? = null,

    @field:SerializedName("wineGrapes")
	val getWineGrapes: List<GetWineGrapesClass?>? = null,

    @field:SerializedName("imageOriginal")
	val imageOriginal: Any? = null,

    @field:SerializedName("imageThumbnail")
	val imageThumbnail: Any? = null,

    @field:SerializedName("wineId")
	val wineId: Long? = null
)




abstract open class Resource {
    abstract var id: Long
    abstract var location: String
}

data class Book (
    override var id: Long = 0,
    override var location: String = "",
    var isbn: String
) : Resource()












