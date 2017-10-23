package com.obezhenar.yukontestapp.view

import com.arellomobile.mvp.MvpView
import com.obezhenar.yukontestapp.model.entity.Store

/**
 * Defines the behavior of  details screen
 */
interface StoreDetailsView : MvpView {
    fun displayStore(store: Store)

    fun displayProgress(display: Boolean)
}