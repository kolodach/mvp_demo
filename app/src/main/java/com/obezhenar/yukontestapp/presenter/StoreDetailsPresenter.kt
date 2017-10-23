package com.obezhenar.yukontestapp.presenter

import com.arellomobile.mvp.InjectViewState
import com.obezhenar.yukontestapp.common.AppSchedulers
import com.obezhenar.yukontestapp.common.RxMvpPresenter
import com.obezhenar.yukontestapp.common.di.AppInjector
import com.obezhenar.yukontestapp.common.extensions.observeOnMainThread
import com.obezhenar.yukontestapp.model.repository.StoreRepository
import com.obezhenar.yukontestapp.view.StoreDetailsView
import javax.inject.Inject

/**
 * Defines and implements operations available on store screen
 */
@InjectViewState
class StoreDetailsPresenter : RxMvpPresenter<StoreDetailsView>() {
    @Inject
    lateinit var storeRepository: StoreRepository

    init {
        AppInjector.inject(this)
    }

    fun loadStoreDetails(storeId: Long) {
        viewState.displayProgress(true)
        addDisposable(storeRepository.getStoreById(storeId)
                .subscribeOn(AppSchedulers.database)
                .observeOnMainThread()
                .subscribe({
                    viewState.displayProgress(false)
                    viewState.displayStore(it)
                }, { it.printStackTrace() }))
    }
}