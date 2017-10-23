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
package com.obezhenar.yukontestapp.common.di

import com.obezhenar.yukontestapp.presenter.*
import com.obezhenar.yukontestapp.system.AppAuthenticator
import dagger.Component
import javax.inject.Singleton

/**
 * Created by 1 on 10/18/2017.
 */
@Component(modules = arrayOf(
        AppModule::class,
        DomainModule::class,
        ApiModule::class,
        DaoModule::class
))
@Singleton
interface AppComponent {
    fun inject(presenter: LogInPresenter)
    fun inject(presenter: SplashScreenPresenter)
    fun inject(presenter: RegistrationPresenter)
    fun inject(presenter: StoresPresenter)
    fun inject(presenter: LogOutPresenter)
    fun inject(presenter: StoreDetailsPresenter)
    fun inject(presenter: ProductsPresenter)
    fun inject(authenticator: AppAuthenticator)
}