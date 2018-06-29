package se.hemnet.property.model

/**
 * Represents listing types
 * */
enum class ListingType(val type: String) {
    ACTIVE("ActivePropertyListing"),
    DEACTIVATED("DeactivatedPropertyListing")
}