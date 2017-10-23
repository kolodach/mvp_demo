package com.obezhenar.yukontestapp.model.dao

import android.support.annotation.IntRange
import android.util.Log
import com.obezhenar.yukontestapp.model.entity.Product
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Product data access object
 */
interface ProductDao {
    fun getProductsInStore(storeId: Long, @IntRange(from = 1) page: Int): Observable<List<Product>>

    fun getProductById(productId: Long): Observable<Product>

    fun insertAll(products: List<Product>): Completable

    fun removeAll(): Completable
}