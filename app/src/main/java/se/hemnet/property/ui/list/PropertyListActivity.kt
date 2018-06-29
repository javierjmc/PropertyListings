package se.hemnet.property.ui.list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.view.View
import kotlinx.android.synthetic.main.property_list_activity.*
import se.hemnet.property.R
import se.hemnet.property.model.Listing
import se.hemnet.property.viewmodel.ListingViewModel
import se.hemnet.property.viewmodel.ViewState
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
        listingViewModel.viewState.observe(this, Observer { render(it) })

        propertyList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

    }

    /**
     * Renders the [ViewState]
     *
     * @param state State to be rendered.
     * */
    private fun render(state: ViewState?) {
        when (state) {
            is ViewState.Error -> {
                errorView.apply {
                    visibility = View.VISIBLE
                    text = state.error
                }
                progressView.visibility = View.GONE
                propertyList.visibility = View.GONE
            }
            is ViewState.Loading -> {
                errorView.visibility = View.GONE
                progressView.visibility = View.VISIBLE
                propertyList.visibility = View.GONE
            }
            is ViewState.Loaded -> {
                errorView.visibility = View.GONE
                progressView.visibility = View.GONE
                propertyList.visibility = View.VISIBLE
                propertyList.adapter = ListingAdapter(state.data as? List<Listing> ?: emptyList())
            }
        }
    }
}
