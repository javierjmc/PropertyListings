package se.hemnet.property

import android.arch.lifecycle.MutableLiveData
import org.junit.Assert.assertEquals
import org.junit.Test
import se.hemnet.property.model.Listing
import se.hemnet.property.repository.ListingsRepository
import se.hemnet.property.viewmodel.ListingViewModel
import se.hemnet.property.viewmodel.ViewState

/**
 * Tests for the [ListingViewModel]
 */
class ListingViewModelTest {

    class FaultyListingsRepository : ListingsRepository(null) {
        override fun getListings() = MutableLiveData<List<Listing>?>().apply { value = null }
    }

    @Test
    fun successfulDataLoading() {
        //val viewModel = ListingViewModel()
    }

    @Test
    fun errorDataLoading() {
        val viewModel = ListingViewModel(FaultyListingsRepository())
        assertEquals(ViewState.Error("Problem loading data"), viewModel.viewState)
    }
}
