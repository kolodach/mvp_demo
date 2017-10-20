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
package com.obezhenar.yukontestapp.model.repository

import com.obezhenar.yukontestapp.C
import com.obezhenar.yukontestapp.model.api.StoreApi
import com.obezhenar.yukontestapp.model.dao.StoreDao
import com.obezhenar.yukontestapp.model.entity.Store
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

/**
 * Store repository implementation
 */
class StoreRepositoryImpl(
        private val storeDao: StoreDao,
        private val storeApi: StoreApi
) : StoreRepository {

    override fun getStoresByPage(page: Int): Observable<List<Store>> =
            storeDao.getStoresByPage(page)
                    .flatMap { stores ->
                        if (stores.isEmpty())
                            storeApi.getStoresByPage(page, C.RECORDS_PER_PAGE)
                                    .subscribeOn(Schedulers.io())
                                    .flatMap { response ->
                                        storeDao.insertAll(response.result)
                                                .andThen(Observable.just<List<Store>>(response.result))
                                    }
                        else
                            Observable.just(stores)
                    }


    override fun getStoreById(id: Long): Single<Store> = storeDao
            .getStoreById(id)
            .onErrorResumeNext {
                if (it is NoSuchElementException)
                    storeApi.getStoreById(id)
                            .map { it.result }
                            .singleOrError()
                else
                    throw it
            }
}