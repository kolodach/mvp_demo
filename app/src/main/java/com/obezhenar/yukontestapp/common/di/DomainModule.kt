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

import com.obezhenar.yukontestapp.model.api.StoreApi
import com.obezhenar.yukontestapp.model.api.UserApi
import com.obezhenar.yukontestapp.model.dao.StoreDao
import com.obezhenar.yukontestapp.model.dao.UserDao
import com.obezhenar.yukontestapp.model.domain.EmailValidator
import com.obezhenar.yukontestapp.model.domain.Validator
import com.obezhenar.yukontestapp.model.repository.*
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * Dagger 2 module.Provides domain layer classes
 * (such as mappers, validators, repositories, use causes implementations and so).
 */
@Module
class DomainModule {

    @Provides
    @Singleton
    fun provideUserRepository(
            userApi: UserApi,
            userDao: UserDao
    ): UserRepository = UserRepositoryImpl(
            userDao, userApi
    )

    @Provides
    @Singleton
    fun provideStoreRepository(
            storeApi: StoreApi, storeDao: StoreDao
    ): StoreRepository = StoreRepositoryImpl(storeDao, storeApi)

    @Provides
    @Singleton
    fun provideProductRepository(): ProductRepository =
            ProductRepositoryImpl()

    @Provides
    @Singleton
    fun provideEmailValidator(): Validator<String> = EmailValidator()
}