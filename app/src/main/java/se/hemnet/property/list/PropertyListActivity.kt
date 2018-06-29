package se.hemnet.property.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.moshi.Moshi
import kotlinx.android.synthetic.main.property_list_activity.*
import se.hemnet.property.R
import se.hemnet.property.model.ListingResponse
import se.hemnet.property.model.ListingTypeAdapter


/**
 * Displays the list of listings
 * */
class PropertyListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.property_list_activity)

        val text = resources.openRawResource(R.raw.listings).bufferedReader().use { it.readText() }

        val moshi = Moshi.Builder()
                .add(ListingTypeAdapter())
                .build()
        val jsonAdapter = moshi.adapter(ListingResponse::class.java)

        jsonAdapter.fromJson(text)?.let {
            propertyList.adapter = ListingAdapter(it.listings)
        }
    }
}
