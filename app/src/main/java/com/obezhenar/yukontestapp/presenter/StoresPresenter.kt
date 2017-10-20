/**
 * Copyright © 2017 Oleg Bezhenar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.obezhenar.yukontestapp.presenter

import com.arellomobile.mvp.InjectViewState
import com.obezhenar.yukontestapp.common.AppSchedulers
import com.obezhenar.yukontestapp.common.RxMvpPresenter
import com.obezhenar.yukontestapp.common.di.AppInjector
import com.obezhenar.yukontestapp.common.extensions.observeOnMainThread
import com.obezhenar.yukontestapp.model.repository.StoreRepository
import com.obezhenar.yukontestapp.view.StoresView
import javax.inject.Inject

/**
 * MVP presenter class. Defines and implements operations available for Stores screen
 */
@InjectViewState
class StoresPresenter : RxMvpPresenter<StoresView>() {
    @Inject
    lateinit var storeRepository: StoreRepository

    private var currentPage = 1

    init {
        AppInjector.inject(this)
    }

    fun loadMoreStore() {
        viewState.displayProgress(true)
        addDisposable(storeRepository.getStoresByPage(currentPage)
                .subscribeOn(AppSchedulers.single)
                .observeOnMainThread()
                .subscribe({
                    viewState.displayProgress(false)
                    viewState.addStores(it)
                    currentPage++
                }, {
                    it.printStackTrace()
                    viewState.displayProgress(false)
                }))
    }
}