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
package com.obezhenar.yukontestapp.model.api

import android.support.annotation.IntRange
import com.obezhenar.yukontestapp.C
import com.obezhenar.yukontestapp.model.api.model.ApiResponse
import com.obezhenar.yukontestapp.model.entity.Store
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * This class defines API methods specific for the Store object
 */
interface StoreApi {

    @GET("/stores")
    fun getStoresByPage(
            @Query("page")
            @IntRange(from = 1)
            page: Int,
            @Query("per_page")
            recordsPerPage: Int
    ): Observable<ApiResponse<List<Store>>>

    fun getStoreById(id: Long): Observable<ApiResponse<Store>>
}