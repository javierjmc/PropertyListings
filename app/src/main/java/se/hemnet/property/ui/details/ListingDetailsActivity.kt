package se.hemnet.property.ui.details

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.listing_details.*
import se.hemnet.property.R
import se.hemnet.property.extensions.viewModel
import se.hemnet.property.model.Listing
import se.hemnet.property.ui.BaseActivity
import se.hemnet.property.viewmodel.ListingViewModel
import se.hemnet.property.viewmodel.ViewState

class ListingDetailsActivity : BaseActivity() {
    override var layoutId = R.layout.listing_details
    private val listingIndex: Int by lazy { intent?.getIntExtra("index", 0) ?: 0 }

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
            }
            is ViewState.Loading -> {
                errorView.visibility = View.GONE
                progressView.visibility = View.VISIBLE
            }
            is ViewState.Loaded -> {
                errorView.visibility = View.GONE
                progressView.visibility = View.GONE
                with((state.data as List<Listing>)[listingIndex]) {
                    address.text = streetAddress
                    rooms.text = String.format(getString(R.string.rooms), numberOfRooms, numberOfRooms)

                    Glide.with(baseContext)
                            .load(thumbnail)
                            .into(image)
                }
            }
        }
    }
}