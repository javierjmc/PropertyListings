package se.hemnet.property.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import se.hemnet.property.model.Listing
import se.hemnet.property.repository.ListingsRepository

/**
 * [ViewModel] for [listings][Listing].
 *
 * @param listingsRepository [ListingsRepository] to pull the listings from.
 * */
class ListingViewModel(listingsRepository: ListingsRepository) : ViewModel() {
    val viewState: MutableLiveData<ViewState> = MutableLiveData()

    init {
        with(viewState) {
            value = ViewState.Loading

            val listings = listingsRepository.getListings()

            value = if (listings.value == null) {
                ViewState.Error("Problem loading data")
            } else {
                ViewState.Loaded(listingsRepository.getListings().value)
            }
        }
    }
}