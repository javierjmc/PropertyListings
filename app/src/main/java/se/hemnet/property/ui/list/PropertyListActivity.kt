package se.hemnet.property.ui.list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.property_list_activity.*
import se.hemnet.property.R
import se.hemnet.property.model.Listing
import se.hemnet.property.viewmodel.ListingViewModel
import se.hemnet.property.viewmodel.factory.ListingViewModelFactory


/**
 * Displays the list of listings
 * */
class PropertyListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.property_list_activity)

        val factory = ListingViewModelFactory(resources)
        val listingViewModel = ViewModelProviders.of(this, factory).get(ListingViewModel::class.java)
        listingViewModel.listings.observe(this, Observer { render(it) })
    }

    private fun render(listings: List<Listing>?) {
        propertyList.adapter = ListingAdapter(listings ?: emptyList())
    }
}
