package se.hemnet.property.model

import com.squareup.moshi.JsonClass

/**
 * Represents a property listing
 * */
@JsonClass(generateAdapter = true)
data class Listing(val listingType: String,
                   val id: String,
                   val askingPrice: String,
                   val monthlyFee: String,
                   val municipality: String,
                   val area: String,
                   val daysOnHemnet: Int,
                   val livingArea: Int,
                   val numberOfRooms: Int,
                   val streetAddress: String,
                   val thumbnail: String)