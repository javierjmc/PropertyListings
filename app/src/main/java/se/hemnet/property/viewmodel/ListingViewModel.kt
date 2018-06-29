package se.hemnet.property.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import se.hemnet.property.model.Listing
import se.hemnet.property.repository.ListingsRepository

/**
 * [ViewModel] for [listings][Listing].
 *
 * @param listingsRepository [ListingsRepository] to pull the listings from.
 * */
class ListingViewModel(listingsRepository: ListingsRepository) : ViewModel() {
    val listings: LiveData<List<Listing>> = listingsRepository.getListings()
}