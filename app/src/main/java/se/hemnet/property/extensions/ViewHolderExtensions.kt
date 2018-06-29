package se.hemnet.property.extensions

import android.support.v7.widget.RecyclerView

/**
 * Gets a [String] given a resource Id.
 *
 * @param resId Resource id of the desired string.
 * */
fun RecyclerView.ViewHolder.getString(resId: Int): String = this.itemView.context.getString(resId)

/**
 * Gets a formatted [String] given a resource Id and args.
 *
 * @param resId Resource id of the desired string.
 * @param args arguments to format the string with.
 * */
fun RecyclerView.ViewHolder.getFormattedString(resId: Int, vararg args: Any?): String = String.format(getString(resId), *args)

/**
 * Gets a plural [String] resource.
 *
 * @param resId Plural resource id of the desired string.
 * @param quantity The number used to get the correct string for the current language's plural rules.
 * @param args arguments to format the string with.
 * */
fun RecyclerView.ViewHolder.getPluralString(resId: Int, quantity: Int, vararg args: Any?): String = this.itemView.resources.getQuantityString(resId, quantity, *args)