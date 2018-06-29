package se.hemnet.property.ui.list

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.view.View
import kotlinx.android.synthetic.main.listings_activity.*
import se.hemnet.property.R
import se.hemnet.property.extensions.viewModel
import se.hemnet.property.model.Listing
import se.hemnet.property.ui.BaseActivity
import se.hemnet.property.viewmodel.ListingViewModel
import se.hemnet.property.viewmodel.ViewState

/**
 * Displays the list of listings
 * */
class ListingsActivity : BaseActivity() {
    override var layoutId = R.layout.listings_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel<ListingViewModel>().viewState.observe(this, Observer { render(it) })
    }

    override fun render(state: ViewState?) {
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
                propertyList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
            }
        }
    }
}