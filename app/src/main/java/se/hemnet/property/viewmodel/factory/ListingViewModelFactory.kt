package se.hemnet.property.viewmodel.factory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.res.Resources
import se.hemnet.property.repository.ListingsRepository
import se.hemnet.property.viewmodel.ListingViewModel

/**
 * [ViewModelProvider.Factory] to be able to have parameters in the [ViewModel]'s constructor.
 *
 * @param resources [Resources] to be used by the [ListingsRepository].
 * */
class ListingViewModelFactory(resources: Resources) : ViewModelProvider.Factory {

    private val listingsRepository = ListingsRepository(resources)

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = ListingViewModel(listingsRepository) as T
}