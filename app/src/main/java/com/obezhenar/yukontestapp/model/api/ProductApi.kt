package com.obezhenar.yukontestapp.model.api

import com.obezhenar.yukontestapp.model.api.model.ApiResponse
import com.obezhenar.yukontestapp.model.entity.Product
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductApi {
    @GET("/stores/{storeId}/products")
    fun getProductsInStore(
            @Path("storeId")
            storeId: Long,
            @Query("page")
            page: Int,
            @Query("per_page")
            perPage: Int
    ): Observable<ApiResponse<List<Product>>>
}