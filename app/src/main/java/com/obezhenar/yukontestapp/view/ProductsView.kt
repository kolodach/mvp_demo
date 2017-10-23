package com.obezhenar.yukontestapp.view

import com.arellomobile.mvp.MvpView
import com.obezhenar.yukontestapp.model.entity.Product

/**
 * Created by kolod on 23.10.2017.
 */
interface ProductsView : MvpView {
    fun displayProgress(display: Boolean)

    fun onAllLoaded()

    fun displayProducts(products: List<Product>)
}