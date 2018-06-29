package se.hemnet.property.ui.list

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.listing_item.*
import se.hemnet.property.R
import se.hemnet.property.extensions.getFormattedString
import se.hemnet.property.extensions.getPluralString
import se.hemnet.property.model.Listing
import se.hemnet.property.model.ListingType
import kotlinx.android.synthetic.main.listing_item.area as dimensions

/**
 * [ViewHolder] for each [Listing] on the list.
 * */
class ListingViewHolder(override val containerView: View, val onClick: (Listing, Int) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    /**
     * Binds the given listing
     *
     * @param listing [Listing] to be bound.
     * */
    fun bind(listing: Listing): Unit = with(listing) {
        address.text = streetAddress
        localArea.text = getFormattedString(R.string.area_municipality, area, livingArea)
        price.text = askingPrice
        dimensions.text = getFormattedString(R.string.living_area, livingArea)
        rooms.text = getFormattedString(R.string.rooms, numberOfRooms)
        fee.text = monthlyFee
        days.text = getPluralString(R.plurals.days, daysOnHemnet, daysOnHemnet)

        when (listingType) {
            ListingType.DEACTIVATED -> {
                deactivated_background.visibility = View.VISIBLE
                deactivated.visibility = View.VISIBLE
            }
            ListingType.ACTIVE -> {
                deactivated_background.visibility = View.GONE
                deactivated.visibility = View.GONE
            }
        }

        Glide.with(containerView.context)
                .load(thumbnail)
                .into(image)

        containerView.setOnClickListener { onClick(this, adapterPosition) }
    }
}
