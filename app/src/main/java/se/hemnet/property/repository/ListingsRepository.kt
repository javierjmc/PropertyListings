package se.hemnet.property.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.res.Resources
import com.squareup.moshi.Moshi
import se.hemnet.property.R
import se.hemnet.property.model.Listing
import se.hemnet.property.model.ListingResponse
import se.hemnet.property.model.ListingTypeAdapter

/**
 * Repository for the [Listing]s.
 *
 * @param resources Resources to fetch the raw json file from.
 * */
open class ListingsRepository(resources: Resources?) {
    private val moshi = Moshi.Builder()
            .add(ListingTypeAdapter())
            .build()
    private val jsonAdapter = moshi.adapter(ListingResponse::class.java)

    private val listings = MutableLiveData<List<Listing>>().apply {
        resources ?: return@apply

        val json = resources.openRawResource(R.raw.listings).bufferedReader().use { it.readText() }
        jsonAdapter.fromJson(json)?.let {
            value = it.listings
        }
    }

    open fun getListings(): LiveData<List<Listing>?> = listings
}