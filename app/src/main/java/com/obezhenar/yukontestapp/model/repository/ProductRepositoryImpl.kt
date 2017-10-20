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

import com.obezhenar.yukontestapp.model.entity.Product
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by 1 on 10/19/2017.
 */
class ProductRepositoryImpl : ProductRepository {

    override fun getProductsByPage(page: Int): Flowable<List<Product>> {
        return Flowable.never();
    }

    override fun getProductById(): Single<Product> {
        return Single.never()
    }

    override fun syncProducts(): Completable {
        return Completable.complete()
    }
}