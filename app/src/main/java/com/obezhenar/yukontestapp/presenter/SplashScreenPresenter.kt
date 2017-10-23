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
import com.arellomobile.mvp.MvpPresenter
import com.obezhenar.yukontestapp.common.RxMvpPresenter
import com.obezhenar.yukontestapp.common.di.AppInjector
import com.obezhenar.yukontestapp.model.repository.ProductRepository
import com.obezhenar.yukontestapp.model.repository.StoreRepository
import com.obezhenar.yukontestapp.model.repository.UserRepository
import com.obezhenar.yukontestapp.view.SplashScreenView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * MVP presenter. Defines and implements operations available for Splash screen
 */
@InjectViewState
class SplashScreenPresenter : RxMvpPresenter<SplashScreenView>() {
    @Inject
    lateinit var userRepository: UserRepository
    @Inject
    lateinit var productRepository: ProductRepository
    @Inject
    lateinit var storesRepository: StoreRepository

    init {
        AppInjector.inject(this)
    }

    fun performSync() {
        addDisposable(userRepository.refreshToken()
                .delay(400, TimeUnit.MILLISECONDS)
                .andThen(storesRepository.getStoresByPage(1).ignoreElements())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ viewState.displayMainScreen() }, {
                    if ((it is HttpException && it.code() == 401)
                            || (it is IllegalArgumentException)
                            || (it is SecurityException))
                        viewState.displayLogInScreen()
                    else
                        viewState.displayMainScreen()
                    it.printStackTrace()
                }))
    }
}