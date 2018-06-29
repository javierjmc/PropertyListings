package se.hemnet.property.model

/**
 * Represents the api response of a [Listing] list.
 * */
data class ListingResponse(val listings: List<Listing> = emptyList())