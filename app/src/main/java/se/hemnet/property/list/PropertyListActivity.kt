package se.hemnet.property.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.property_list_activity.*
import se.hemnet.property.R

/**
 * Displays the list of properties
 * */
class PropertyListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.property_list_activity)

        propertyList.adapter = ListingAdapter()

    }
}
