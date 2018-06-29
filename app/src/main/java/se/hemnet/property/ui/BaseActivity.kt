package se.hemnet.property.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import se.hemnet.property.viewmodel.ViewState

/**
 * Base Activity for the app.
 * */
abstract class BaseActivity : AppCompatActivity() {
    open var layoutId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
    }

    /**
     * Renders the [ViewState]
     *
     * @param state State to be rendered.
     * */
    abstract fun render(state: ViewState?)
}
