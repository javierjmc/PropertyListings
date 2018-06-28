package se.hemnet.property.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Inflates a View to the given ViewGroup.
 *
 * @param layoutId The resource id of the layout to be inflated.
 * @return Inflated [View].
 * */
fun ViewGroup.inflate(layoutId: Int): View = LayoutInflater.from(context).inflate(layoutId, this, false)