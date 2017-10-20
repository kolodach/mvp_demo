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
package com.obezhenar.yukontestapp.model.dao

import android.support.annotation.IntRange
import com.obezhenar.yukontestapp.model.entity.Store
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Store Data Access Object. Defines operations on local Store objects.
 */
interface StoreDao {
    fun getStoresByPage(@IntRange(from = 1) page: Int): Observable<List<Store>>

    fun getStoreById(id: Long): Single<Store>

    fun insertAll(stores : List<Store>) : Completable
}