package com.obezhenar.yukontestapp.presenter

import com.arellomobile.mvp.InjectViewState
import com.obezhenar.yukontestapp.common.RxMvpPresenter
import com.obezhenar.yukontestapp.common.di.AppInjector
import com.obezhenar.yukontestapp.common.extensions.observeOnMainThread
import com.obezhenar.yukontestapp.model.repository.ProductRepository
import com.obezhenar.yukontestapp.view.ProductsView
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by kolod on 23.10.2017.
 */
@InjectViewState
class ProductsPresenter : RxMvpPresenter<ProductsView>() {
    @Inject
    lateinit var productsRepository: ProductRepository

    private var currentPage = 1

    init {
        AppInjector.inject(this)
    }

    fun loadMoreStores(storeId: Long) {
        viewState.displayProgress(true)
        addDisposable(productsRepository.getProductsInstore(storeId, currentPage)
                .subscribeOn(Schedulers.io())
                .observeOnMainThread()
                .subscribe({
                    viewState.displayProgress(false)
                    if (it.isEmpty())
                        viewState.onAllLoaded()
                    else
                        viewState.displayProducts(it)
                }, {
                    it.printStackTrace()
                    viewState.displayProgress(false)
                }))
    }

    fun refresh(storeId: Long) {
        addDisposable(productsRepository.removeAll()
                .subscribeOn(Schedulers.io())
                .observeOnMainThread()
                .subscribe({
                    currentPage = 1
                    loadMoreStores(storeId)
                }, {
                    it.printStackTrace()
                }))
    }
}