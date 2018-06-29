package se.hemnet.property.extensions

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import se.hemnet.property.viewmodel.factory.ListingViewModelFactory

/**
 * Gets the viewModel of the given type [T] on the Activity.
 *
 * @param factory the ViewModelProvider.Factory to create viewModels from.
 * */
inline fun <reified T : ViewModel> AppCompatActivity.viewModel(factory: ViewModelProvider.Factory = ListingViewModelFactory(resources)) = ViewModelProviders.of(this, factory).get(T::class.java)
