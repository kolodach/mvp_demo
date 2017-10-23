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
import com.obezhenar.yukontestapp.common.AppSchedulers
import com.obezhenar.yukontestapp.common.extensions.observable
import com.obezhenar.yukontestapp.model.api.ProductApi
import com.obezhenar.yukontestapp.model.api.StoreApi
import com.obezhenar.yukontestapp.model.dao.InventoryDao
import com.obezhenar.yukontestapp.model.dao.ProductDao
import com.obezhenar.yukontestapp.model.dao.StoreDao
import com.obezhenar.yukontestapp.model.entity.Inventory
import com.obezhenar.yukontestapp.model.entity.Product
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

/**
 * Created by 1 on 10/19/2017.
 */
class ProductRepositoryImpl(
        private val productDao: ProductDao,
        private val productApi: ProductApi,
        private val inventoryDao: InventoryDao
) : ProductRepository {

    override fun getProductsInstore(storeId: Long, page: Int) = productDao.getProductsInStore(storeId, page)
            .flatMap {
                if (it.isEmpty())
                    productApi.getProductsInStore(storeId, page, C.RECORDS_PER_PAGE)
                            .subscribeOn(Schedulers.io())
                            .flatMap { products ->
                                productDao.insertAll(products.result)
                                        .subscribeOn(AppSchedulers.database)
                                        .andThen(inventoryDao.insertAll(products.result.map {
                                            Inventory(
                                                    it.id, storeId, false, 0, ", ", "", 0L, 0)
                                        }))
                                        .andThen(observable { products.result })
                            }
                else observable { it }
            }

    override fun getProductById(id: Long) = productDao.getProductById(id).singleOrError()

    override fun removeAll() = productDao.removeAll()
}