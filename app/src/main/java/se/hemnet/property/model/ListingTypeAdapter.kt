package se.hemnet.property.model

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

/**
 * Moshi adapter for [ListingType].
 * */
class ListingTypeAdapter {
    @ToJson
    fun toJson(type: ListingType): String = type.type

    @FromJson
    fun fromJson(type: String): ListingType {
        return when (type) {
            "ActivePropertyListing" -> ListingType.ACTIVE
            "DeactivatedPropertyListing" -> ListingType.DEACTIVATED
            else -> throw NotImplementedError("Type not implemented")
        }
    }
}