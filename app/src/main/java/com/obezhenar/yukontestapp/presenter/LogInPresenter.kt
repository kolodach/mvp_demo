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
import com.obezhenar.yukontestapp.common.RxMvpPresenter
import com.obezhenar.yukontestapp.common.di.AppInjector
import com.obezhenar.yukontestapp.model.domain.Validator
import com.obezhenar.yukontestapp.model.repository.UserRepository
import com.obezhenar.yukontestapp.view.LogInView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import javax.inject.Inject

/**
 * MVP presenter. Defines and implements operations available for the LogIn Scenario.
 */
@InjectViewState
class LogInPresenter : RxMvpPresenter<LogInView>() {
    @Inject
    lateinit var userRepository: UserRepository
    @Inject
    lateinit var emailValidator: Validator<String>

    init {
        AppInjector.inject(this)
    }

    fun logIn(email: String, password: String) {
        viewState.setDisplayProgress(true)
        if (emailValidator.valid(email)) {
            addDisposable(userRepository.basicAuth(email, password)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        viewState.setDisplayProgress(false)
                        viewState.onLogInSuccess()
                    }, {
                        it.printStackTrace()
                        viewState.setDisplayProgress(false)
                        if (it is HttpException && it.code() == 401)
                            viewState.invalidCredentialsError()
                        else
                            viewState.onNetworkError()
                    }))
        } else {
            viewState.setDisplayProgress(false)
            viewState.onInvalidEmailFormat()
        }
    }
}
